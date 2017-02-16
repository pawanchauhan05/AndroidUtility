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
import com.androidutility.fragment.TestFragment;
import com.androidutility.model.CustomObject;

public class MainActivity extends AppCompatActivity {
    public RunTimePermission permission;
    private String url = "http://www.maninblack.org/demos/WhereDoAllTheJunkiesComeFrom.mp3";
    private String musicFileName = "music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new TestFragment())
                .commit();
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
        Utils.downloadMusicFile(url, musicFileName, this);
    }

}
