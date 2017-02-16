package com.androidutility;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.utility.AlertDialog;
import com.android.utility.FileDBUtils;
import com.android.utility.RunTimePermission;
import com.android.utility.RuntimePermissionInitializerInterface;
import com.android.utility.RuntimePermissionInterface;
import com.android.utility.Task;
import com.android.utility.Utils;
import com.androidutility.model.CustomObject;

public class MainActivity extends AppCompatActivity implements RuntimePermissionInitializerInterface {
    public RunTimePermission permission;
    private String url = "http://www.maninblack.org/demos/WhereDoAllTheJunkiesComeFrom.mp3";
    private String musicFileName = "music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPermission(View view) {
        permission = new RunTimePermission(this, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                Log.e("C","F");
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void downloadSong(View view) {
        //Utils.downloadMusicFile(url, musicFileName, this);
        Utils.selectImage(this, "Profile Picture");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //permission.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(getRuntimePermission() != null)
            getRuntimePermission().onRequestPermissionsResult(requestCode, permissions, grantResults);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AlertDialog.imageHelperInterface.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setRuntimePermission(RunTimePermission runTimePermission) {
        permission = runTimePermission;
    }

    @Override
    public RunTimePermission getRuntimePermission() {
        return permission;
    }

    @Override
    public void setBitmap(Bitmap bitmap) {

    }
}
