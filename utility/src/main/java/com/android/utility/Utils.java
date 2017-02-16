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
import android.support.v4.app.FragmentManager;
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

    public static void savePreferenceData(Context context, String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void savePreferenceData(Context context, String key, Boolean value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void savePreferenceData(Context context, String key, int value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void savePreferenceData(Context context, String key, Object value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, new Gson().toJson(value));
        editor.commit();
    }

    public static void clearPreferences(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    public static void removePreferenceData(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().remove(key).commit();
    }

    public static String readPreferenceData(Context context, String key, String defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getString(key, defaultValue);
        }
        return null;
    }

    public static Boolean readPreferenceData(Context context, String key, boolean defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getBoolean(key, defaultValue);
        }
        return false;
    }

    public static int readPreferenceData(Context context, String key, int defaultValue) {
        if (context != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            return sp.getInt(key, defaultValue);
        }
        return -1;
    }

    public static Object readPreferenceData(Context context, String key, String defaultValue, Class clazz) {
        String result = readPreferenceData(context, key, defaultValue);
        if (result != null) {
            return new Gson().fromJson(result, clazz);
        }
        return result;
    }

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

    public static void generateShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void generateLongToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showProgressBar(ProgressDialog progressDialog) {
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog_layout);
        progressDialog.setCancelable(true);
    }

    public static void showProgressBar(String title, String message, ProgressDialog progressDialog) {
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
        progressDialog.setCancelable(true);
    }

    public static void hideProgressBar(ProgressDialog progressDialog) {
        try {
            if (progressDialog != null)
                progressDialog.cancel();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDirectory(Context context, String directory) {
        File dir = new File(context.getFilesDir() + directory);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
        }
    }

    public static void downloadMusicFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".mp3", Environment.DIRECTORY_MUSIC);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static void downloadVideoFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".mp4", Environment.DIRECTORY_MOVIES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static void downloadImageFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new Task.DownloadFileTask().execute(url, fileName + ".jpg", Environment.DIRECTORY_PICTURES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

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

    public static void showSingleButtonAlertDialog(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message, AlertDialogInterface alertDialogInterface) {
        new AlertDialog().showSingleButtonAlertDialog(activity, positiveButtonText, negativeButtonText, title, message, alertDialogInterface);
    }

    public static void showMultiButtonAlertDialog(Activity activity, String buttonText, String title, String message, AlertDialogSingleInterface singleInterface) {
        new AlertDialog().showSingleButtonAlertDialog(activity, buttonText, title, message, singleInterface);
    }

    public static void showTimePicker(FragmentManager fragmentManager, TimeInterface timeInterface) {
        AlertDialog.TimePickerFragment fragment = new AlertDialog.TimePickerFragment();
        fragment.setTimeInterface(timeInterface);
        fragment.show(fragmentManager, "Time Picker");
    }

    public static void showDatePicker(FragmentManager fragmentManager, DateInterface dateInterface) {
        AlertDialog.DatePickerFragment fragment = new AlertDialog.DatePickerFragment();
        fragment.setDateInterface(dateInterface);
        fragment.show(fragmentManager, "Date Picker");
    }

    public static void showShortSnackBar(Activity activity, String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    public static void showLongSnackBar(Activity activity, String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }

    public static void selectImage(Activity activity, String title) {
        new AlertDialog().selectPicture(activity, null, title);
    }

}