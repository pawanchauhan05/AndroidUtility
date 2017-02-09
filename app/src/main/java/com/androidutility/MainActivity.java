package com.androidutility;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.utility.RunTimePermission;
import com.android.utility.RuntimePermissionInterface;

public class MainActivity extends AppCompatActivity {
    private RunTimePermission permission;

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permission.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
