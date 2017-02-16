package com.android.utility;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pawan on 10/2/17.
 */

public class AlertDialog {
    public static final int CAMERA_REQUEST = 0;
    public static final int GALLERY_REQUEST = 1;
    public static final int CAMERA_CROP_REQUEST = 2;

    private static String photoFileName = "photo.jpg";
    private static Activity activity;
    private static Fragment fragment = new Fragment();

    public void showMultiButtonAlertDialog(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message, final AlertDialogInterface alertDialogInterface) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialogInterface.positiveButtonPressed();
                        dialogInterface.cancel();
                    }
                }).setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogInterface.negativeButtonPressed();
                dialogInterface.cancel();
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void showSingleButtonAlertDialog(Activity activity, String buttonText, String title, String message, final AlertDialogSingleInterface dialogSingleInterface) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogSingleInterface.doTaskOnClick();
                        dialogInterface.cancel();
                    }
                });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private static Bitmap getBitmapFromData(Intent data) {
        Bitmap photo = null;
        Uri photoUri = data.getData();
        if (photoUri != null) {
            photo = BitmapFactory.decodeFile(photoUri.getPath());
        }
        if (photo == null) {
            Bundle extra = data.getExtras();
            if (extra != null) {
                photo = (Bitmap) extra.get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            }
        }
        return photo;
    }
    /** override onRequestPermissionsResult in activity or fragment(cross check override in both) */

    public void selectPicture(final Activity activity, final Fragment fragment, String title) {
        this.activity = activity;
        if(fragment != null)
            this.fragment = fragment;
        final Dialog dialog = new Dialog(activity);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.select_image_layout);
        ((TextView) dialog.findViewById(R.id.textViewTitle)).setText(title);
        ImageView dialogChooseFormCamera = (ImageView) dialog.findViewById(R.id.imageViewChooseFromCamera);
        ImageView dialogChooseFormGallery = (ImageView) dialog.findViewById(R.id.imageViewChooseFromGallery);
        dialog.show();

        dialogChooseFormCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
                    @Override
                    public void doTaskAfterPermission() {
                        dialog.cancel();
                        initRuntimePermission(activity);
                    }

                    public void initRuntimePermission(Activity act) {
                        if(act instanceof RuntimePermissionInitializerInterface || fragment instanceof RuntimePermissionInitializerInterface) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            photoFileName = "file" + System.currentTimeMillis() + ".png";
                            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), photoFileName);
                            if(!file.exists()){
                                file.mkdirs();
                            }
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                            intent.putExtra("return-data", true);
                            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                                if(fragment instanceof RuntimePermissionInitializerInterface)
                                    fragment.startActivityForResult(intent, CAMERA_CROP_REQUEST);
                                else if(act instanceof RuntimePermissionInitializerInterface)
                                    act.startActivityForResult(intent, CAMERA_CROP_REQUEST);
                            }
                        }
                    }
                });
                if(activity instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) activity).setRuntimePermission(permission);
                else if(fragment instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) fragment).setRuntimePermission(permission);
                permission.runtimePermission(RuntimePermissions.CAMERA);

            }

        });

        dialogChooseFormGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
                    @Override
                    public void doTaskAfterPermission() {
                        dialog.cancel();
                        initRuntimePermission(activity);
                    }

                    public void initRuntimePermission(Activity act) {
                        if(act instanceof RuntimePermissionInitializerInterface || fragment instanceof RuntimePermissionInitializerInterface) {
                            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            if (galleryIntent.resolveActivity(activity.getPackageManager()) != null) {
                                if(fragment instanceof RuntimePermissionInitializerInterface)
                                    fragment.startActivityForResult(galleryIntent, GALLERY_REQUEST);
                                else if(activity instanceof RuntimePermissionInitializerInterface)
                                    activity.startActivityForResult(galleryIntent, GALLERY_REQUEST);
                            }
                        }
                    }
                });

                if(activity instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) activity).setRuntimePermission(permission);
                else if(fragment instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) fragment).setRuntimePermission(permission);
                permission.runtimePermission(RuntimePermissions.WRITE_EXTERNAL_STORAGE);
            }
        });
    }


    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        private TimeInterface timeInterface;

        public TimeInterface getTimeInterface() {
            return timeInterface;
        }

        public void setTimeInterface(TimeInterface timeInterface) {
            this.timeInterface = timeInterface;
        }

        public TimePickerFragment() {
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @SuppressWarnings("WrongConstant")
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            int hour, min;
            Calendar datetime = Calendar.getInstance();
            String am_pm = "" ;
            datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            datetime.set(Calendar.MINUTE, minute);

            if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                am_pm = "AM";
            else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                am_pm = "PM";
            hourOfDay = hourOfDay > 12 ? hourOfDay - 12 : hourOfDay;
            hour = hourOfDay > 9 ? hourOfDay : hourOfDay;
            min = minute > 9 ? minute : minute;
            timeInterface.setTime(hour, min, am_pm);
        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        private DateInterface dateInterface;

        public DateInterface getDateInterface() {
            return dateInterface;
        }

        public void setDateInterface(DateInterface dateInterface) {
            this.dateInterface = dateInterface;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            int updateMonth = month++;
            Date date = new Date(year, updateMonth, day);
            dateInterface.setDate(date);
        }
    }

    public static ImageHelperInterface imageHelperInterface = new ImageHelperInterface() {

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                if(requestCode == CAMERA_CROP_REQUEST)
                    selectedFromCamera();
                else if(requestCode == GALLERY_REQUEST)
                    selectedFromGallery(data);
                else if(requestCode == CAMERA_REQUEST)
                    if(activity instanceof RuntimePermissionInitializerInterface)
                        ((RuntimePermissionInitializerInterface)activity).setBitmap(getBitmapFromData(data));
                    else if(activity instanceof RuntimePermissionInitializerInterface)
                        ((RuntimePermissionInitializerInterface)fragment).setBitmap(getBitmapFromData(data));
            } catch(Exception e) {
                Log.e("Exp", e.getMessage());
            }
        }
    };

    private static String getPath(Uri uri, Activity activity) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = activity.getContentResolver().query(uri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        return cursor.getString(columnIndex);

    }

    private static Intent getCropIntent(Intent intent) {
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        intent.putExtra("return-data", true);
        return intent;
    }

    private static void selectedFromCamera() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        Uri uri = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), photoFileName));
        intent.setDataAndType(uri, "image/*");
        activity.startActivityForResult(getCropIntent(intent), CAMERA_REQUEST);
    }

    private static void selectedFromGallery(Intent data) {
        if(data != null) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            Uri selectedImage = data.getData();
            intent.setDataAndType(Uri.fromFile(new File(getPath(selectedImage, activity))), "image/*");
            activity.startActivityForResult(getCropIntent(intent), CAMERA_REQUEST);
        }
    }

}
