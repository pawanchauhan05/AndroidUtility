package com.androidutility.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.utility.RunTimePermission;
import com.android.utility.RuntimePermissionInterface;
import com.android.utility.Utils;
import com.androidutility.R;
import com.androidutility.fragment.TestFragment;


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permission.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
