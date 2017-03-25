package com.androidutility.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.utility.Utils;
import com.androidutility.R;
import com.androidutility.fragment.TestFragment;



public class MainActivity extends AppCompatActivity {
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
    }

    public void downloadSong(View view) {
        Utils.downloadMusicFile(url, musicFileName, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
