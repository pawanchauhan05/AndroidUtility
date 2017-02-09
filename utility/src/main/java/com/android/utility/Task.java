package com.android.utility;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by pawan on 8/2/17.
 */

public class Task {

    public static boolean hasInternetAccess() {
        try {
            return new InternetCheckTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean hasAppInForeground(Context context) {
        try {
            return new ForegroundCheckTask().execute(context).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void downloadMusicFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new DownloadFileTask().execute(url, fileName + ".mp3", Environment.DIRECTORY_MUSIC);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static void downloadVideoFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new DownloadFileTask().execute(url, fileName + ".mp4", Environment.DIRECTORY_MOVIES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static void downloadImageFile(final String url, final String fileName, Activity activity) {
        RunTimePermission permission = new RunTimePermission(activity, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                new DownloadFileTask().execute(url, fileName + ".jpg", Environment.DIRECTORY_PICTURES);
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }


    public static class InternetCheckTask extends AsyncTask<Context, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Context... params) {
            return hasInternetAccess();
        }

        private boolean hasInternetAccess() {
            try {
                HttpURLConnection urlc = (HttpURLConnection)(new URL("http://clients3.google.com/generate_204").openConnection());
                urlc.setRequestProperty("User-Agent", "Android");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                Log.e("TAG", "network available!");
                return (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0);
            } catch (IOException e) {
                Log.e("TAG", "Error checking internet connection", e);
            }
            return false;
        }
    }

    public static class ForegroundCheckTask extends AsyncTask<Context, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Context... params) {
            final Context context = params[0].getApplicationContext();
            return isAppOnForeground(context);
        }

        private boolean isAppOnForeground(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            if (appProcesses == null) {
                return false;
            }
            final String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class DownloadFileTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... musicURL) {
            int count;
            String fileName = musicURL[1];
            String directory = musicURL[2];
            try {
                URL url = new URL(musicURL[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                File file = new File(Environment.getExternalStoragePublicDirectory(directory), fileName);
                OutputStream output = new FileOutputStream(file);

                byte data[] = new byte[1024];

                while ((count = input.read(data)) != -1) {
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("File", "file downloaded");
        }
    }

}
