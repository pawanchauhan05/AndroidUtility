package com.android.utility;

import android.content.Context;

import com.google.gson.Gson;
import com.android.utility.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by pawan on 8/2/17.
 */

public class FileDBUtils<T> {

    private Context context;
    private String dbFileName;
    private File file;
    private String filePath;
    private Class<T> clazz;
    private String directory;

    public FileDBUtils(Context context, String dbFileName, Class<T> clazz, String directory) {
        this.context = context;
        this.dbFileName = dbFileName;
        this.clazz = clazz;
        this.filePath = context.getFilesDir()+ directory;
        this.file = new File(context.getFilesDir()+ directory, dbFileName);
        this.directory = directory;
    }

    /**
     * this function is used to save object in file.
     *
     * @param object
     */
    public void saveObject(T object) {
        Utils.createDirectory(context, directory);
        String writeData = new Gson().toJson(object);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(writeData);
            outputStreamWriter.close();
        } catch (IOException e) {
        }
    }

    /**
     * this function is used to read object from file.
     *
     * @return
     */
    public T readObject() {
        if (file.exists()) {
            try {
                //check whether file exists
                FileInputStream is = new FileInputStream(file);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                return new Gson().fromJson(new String(buffer), clazz);
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }
}
