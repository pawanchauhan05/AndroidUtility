package com.android.utility;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pawan on 10/2/17.
 */

public class AlertDialog {
    public static String photoFileName = "photo.jpg";
    public static Activity activity;

    public void showSingleButtonAlertDialog(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message, final AlertDialogInterface alertDialogInterface) {
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

    /** override onRequestPermissionsResult in activity or fragment(cross check override in both) */

    public void selectPicture(final Activity activity, String title) {
        this.activity = activity;
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
                        if(act instanceof RuntimePermissionInitializerInterface) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, getPhotoFileUri(photoFileName, activity));
                            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                                activity.startActivityForResult(intent, 2); // solution for fragment/activity
                            }
                        }
                    }
                });
                if(activity instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) activity).setRuntimePermission(permission);
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
                        if(act instanceof RuntimePermissionInitializerInterface) {
                            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            activity.startActivityForResult(galleryIntent, 1);
                            if (galleryIntent.resolveActivity(activity.getPackageManager()) != null) {
                                activity.startActivityForResult(galleryIntent, 1); // solution for fragment/activity
                            }
                        }
                    }
                });

                if(activity instanceof RuntimePermissionInitializerInterface)
                    ((RuntimePermissionInitializerInterface) activity).setRuntimePermission(permission);
                permission.runtimePermission(RuntimePermissions.WRITE_EXTERNAL_STORAGE);
            }
        });
    }

    private static boolean isExternalStorageAvailable() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    public static Uri getPhotoFileUri(String fileName, Activity activity) {
        // Only continue if the SD Card is mounted
        if (isExternalStorageAvailable()) {
            // Get safe storage directory for photos
            // Use `getExternalFilesDir` on Context to access package-specific directories.
            // This way, we don't need to request external read/write runtime permissions.
            File mediaStorageDir = new File(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "PROFILE_FRAGMENT");

            // Create the storage directory if it does not exist
            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
                //Log.d("PROFILE_FRAGMENT", "failed to create directory");
            }

            // Return the file target for the photo based on filename
            return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator + fileName));
        }
        return null;
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
        public void selectedFromCamera() {
            Uri selectedImage = getPhotoFileUri(photoFileName, activity);
            File file = new File(selectedImage.getPath());
            Log.e("Camera", "call");
        }

        @Override
        public void selectedFromGallery(Intent intent) {
            if(intent != null) {
                Uri selectedImage = intent.getData();
                File file = new File(getPath(selectedImage, activity));
                Log.e("Gallery", "call");
            }
        }
    };

    public static String getPath(Uri uri, Activity activity) {
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

}
