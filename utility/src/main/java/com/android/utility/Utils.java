package com.android.utility;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


import java.io.File;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by pawan on 8/2/17.
 */

public class Utils {

    /**
     * this function is used for store String type value in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param value - value to be stored in shared preference
     */
    public static void savePreferenceData(Context context, String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * this function is used for store boolean type value in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param value - value to be stored in shared preference
     */
    public static void savePreferenceData(Context context, String key, Boolean value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * this function is used for store int type value in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param value - value to be stored in shared preference
     */
    public static void savePreferenceData(Context context, String key, int value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * this function is used for store Custom Object in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param value - custom object to be stored in shared preference
     */
    public static void savePreferenceData(Context context, String key, Object value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, new Gson().toJson(value));
        editor.commit();
    }

    /**
     * this function is used for clear all key value pair from shared preference.
     * Recommended - used this function while you want to clear all shared preference data like logout etc.
     *
     * @param context - to prevent unconditionally errors use application context.
     */
    public static void clearPreferences(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * this function is used for clear particular key value pair from shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     */
    public static void removePreferenceData(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().remove(key).commit();
    }

    /**
     * this function is used to get String type value which stored in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param defaultValue - provide default value to prevent unconditionally result.
     * @return - returns String value
     */
    public static String readPreferenceData(Context context, String key, String defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getString(key, defaultValue);
        }
        return null;
    }

    /**
     * this function is used to get Boolean type value which stored in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param defaultValue - provide default value to prevent unconditionally result.
     * @return - returns Boolean value
     */
    public static Boolean readPreferenceData(Context context, String key, boolean defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getBoolean(key, defaultValue);
        }
        return false;
    }

    /**
     * this function is used to get int type value which stored in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param defaultValue - provide default value to prevent unconditionally result.
     * @return - returns Int value
     */
    public static int readPreferenceData(Context context, String key, int defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getInt(key, defaultValue);
        }
        return -1;
    }

    /**
     * this function is used to get Custom Object value which stored in shared preference.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param key - shared preference key (not null)
     * @param defaultValue - provide default value to prevent unconditionally result.
     * @param clazz - provide .class which object want to get
     * @return - returns stored Object
     */
    public static Object readPreferenceData(Context context, String key, String defaultValue, Class clazz) {
        String result = readPreferenceData(context, key, defaultValue);
        if (result != null) {
            return new Gson().fromJson(result, clazz);
        }
        return result;
    }

    /**
     * this function is used for create directory in app storage.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param path - provide path eg. "main/sub/folder"
     */
    public static void createDirectory(Context context, String path) {
        String tempPath = "";
        File dirPath;
        for (String dir : path.split("/")) {
            dirPath = new File(context.getFilesDir(), tempPath + dir);
            if (!dirPath.exists()) {
                dirPath.mkdir();
                tempPath = tempPath + dir + "/";
            } else {
                tempPath = tempPath + dir + "/";
            }
        }
    }

    /**
     * this function is used to show short toast message.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param message - provide message which you want to show on Toast.
     */
    public static void generateShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * this function is used to show long toast message.
     *
     * @param context - to prevent unconditionally errors use application context.
     * @param message - provide message which you want to show on Toast.
     */
    public static void generateLongToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * this function is used to show custom progress dialog.
     *
     * @param progressDialog - progress dialog object (not be null)
     */
    public static void showProgressBar(ProgressDialog progressDialog) {
        if(progressDialog != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialog_layout);
            progressDialog.setCancelable(true);
        }
    }

    /**
     * this function is used to show default progress dialog.
     *
     * @param title - progress dialog title
     * @param message - progress dialog message
     * @param progressDialog - progress dialog object (not be null)
     */
    public static void showProgressBar(String title, String message, ProgressDialog progressDialog) {
        if(progressDialog != null) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.show();
            progressDialog.setCancelable(true);
        }
    }

    /**
     * this function is used to hide progress dialog.
     *
     * @param progressDialog - progress dialog object (not be null)
     */
    public static void hideProgressBar(ProgressDialog progressDialog) {
        try {
            if (progressDialog != null)
                progressDialog.cancel();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * this function is used to delete directory with contents in app storage.
     *
     * @param context - application context
     * @param directory - directory
     */
    public static void deleteDirectory(Context context, String directory) {
        File dir = new File(context.getFilesDir() + directory);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
        }
    }

    /**
     * this function is used to download music file from provided url.
     *
     * @param url - http url (not be null)
     * @param fileName - name of the music file (do not use extension)
     * @param activity - activity instance
     */
    public static void downloadMusicFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".mp3", Environment.DIRECTORY_MUSIC);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    /**
     * this function is used to download video file from provided url.
     *
     * @param url - http url (not be null)
     * @param fileName - name of the video file (do not use extension)
     * @param activity - activity instance
     */
    public static void downloadVideoFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".mp4", Environment.DIRECTORY_MOVIES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    /**
     * this function is used to download image file from provided url.
     *
     * @param url - http url (not be null)
     * @param fileName - name of the image file (do not use extension)
     * @param activity - activity instance
     */
    public static void downloadImageFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".jpg", Environment.DIRECTORY_PICTURES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    /**
     * this function is used to check internet connectivity.
     * it is always better to check internet connectivity before making a network call.
     *
     * @return provide true value if having internet access in device otherwise false.
     */
    public static boolean hasInternetAccess() {
        try {
            return new Task.InternetCheckTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * this function is used to check application state i.e background or foreground.
     * it is used while application is already in foreground and you do not want to show notification etc.
     *
     * @param context - application context
     * @return - returns boolean value
     */
    public static boolean hasAppInForeground(Context context) {
        try {
            return new Task.ForegroundCheckTask().execute(context).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * this function is used to show Alert Dialog with single button.
     *
     * @param activity - activity instance
     * @param buttonText - button name eg. ok, yes, no etc
     * @param title - alert dialog title
     * @param message - alert dialog message
     * @param alertDialogSingleInterface - alertDialogSingleInterface is used to set action on button
     */
    public static void showSingleButtonAlertDialog(Activity activity, String buttonText, String title, String message, AlertDialogSingleInterface alertDialogSingleInterface) {
        new AlertDialog().showSingleButtonAlertDialog(activity, buttonText, title, message, alertDialogSingleInterface);
    }

    /**
     * this function is used to show alert dialog with two buttons.
     *
     * @param activity - activity instance
     * @param positiveButtonText - button name eg. ok, yes etc
     * @param negativeButtonText - button name eg. no, cancel etc
     * @param title - alert dialog title
     * @param message - alert dialog message
     * @param alertDialogInterface - alertDialogInterface is used to set action on +ve or -ve button
     */
    public static void showMultiButtonAlertDialog(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message, AlertDialogInterface alertDialogInterface) {
        new AlertDialog().showMultiButtonAlertDialog(activity, positiveButtonText, negativeButtonText, title, message, alertDialogInterface);
    }

    /**
     * this function is used to show Time picker dialog.
     *
     * @param fragmentManager - fragment manager instance
     * @param timeInterface - timeinterface used to set time after selection
     */
    public static void showTimePicker(FragmentManager fragmentManager, TimeInterface timeInterface) {
        AlertDialog.TimePickerFragment fragment = new AlertDialog.TimePickerFragment();
        fragment.setTimeInterface(timeInterface);
        fragment.show(fragmentManager, "Time Picker");
    }

    /**
     * this function is used to show Date picker dialog.
     *
     * @param fragmentManager - fragment manager instance
     * @param dateInterface - dateinterface used to set date after selection
     */
    public static void showDatePicker(FragmentManager fragmentManager, DateInterface dateInterface) {
        AlertDialog.DatePickerFragment fragment = new AlertDialog.DatePickerFragment();
        fragment.setDateInterface(dateInterface);
        fragment.show(fragmentManager, "Date Picker");
    }

    /**
     * this function is used for show short length snackbar.
     *
     * @param activity - activity instance
     * @param message - message to show with snackbar
     */
    public static void showShortSnackBar(Activity activity, String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * this function is used for show long length snackbar.
     *
     * @param activity - activity instance
     * @param message - message to show with snackbar
     */
    public static void showLongSnackBar(Activity activity, String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * this function is used for hide keyboard panel.
     *
     * @param activity - activity instance
     */
    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }

    /**
     * this function is used to show layout for select image from camera or gallery.
     *
     * @param activity - activity instance
     * @param title - provide title for layout eg. select image, profile picture, choose from etc.
     */
    public static void selectImage(Activity activity, String title) {
        new AlertDialog().selectPicture(activity, title);
    }

    /**
     * this function is used to show layout for select image from camera or gallery.
     *
     * @param fragment - fragment instance
     * @param title - provide title for layout eg. select image, profile picture, choose from etc.
     */
    public static void selectImage(Fragment fragment, String title) {
        new AlertDialog().selectPicture(fragment, title);
    }

    /**
     * this function is used to login with facebook.
     *
     * @param fbLoginInterface - fbLoginInterface defines task which is performed after facebook login.
     * @param activity - activity instance
     */
    public static void facebookLogin(FBLoginInterface fbLoginInterface, Activity activity) {
        new FBLogin().fbLogin(fbLoginInterface, activity);
    }

    /**
     * this function is used to login with google.
     *
     * @param googleSignIn
     */
    public static void googleLogin(GoogleSignIn googleSignIn) {
        googleSignIn.login();
    }

    /**
     * this function is used to logout from google.
     *
     * @param googleSignIn
     */
    public static void googleLogout(GoogleSignIn googleSignIn) {
        googleSignIn.logout();
    }

}