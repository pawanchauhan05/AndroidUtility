package com.androidutility.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.utility.CircularImageView;
import com.android.utility.FBLogin;
import com.android.utility.GoogleLoginInterface;
import com.android.utility.GoogleSignIn;
import com.android.utility.RunTimePermission;
import com.android.utility.Utils;
import com.androidutility.R;
import com.androidutility.fragment.TestFragment;


public class MainActivity extends AppCompatActivity {
    public RunTimePermission permission;
    private String url = "http://www.maninblack.org/demos/WhereDoAllTheJunkiesComeFrom.mp3";
    private String musicFileName = "music";
    private CircularImageView circularImageView;
    private GoogleSignIn googleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circularImageView = (CircularImageView) findViewById(R.id.circularImageView);
        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.pp);
        circularImageView.setImageBitmap(icon);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new TestFragment())
                .commit();
        googleSignIn = new GoogleSignIn(this, new GoogleLoginInterface() {
            @Override
            public void doTaskAfterLogin(Bundle googleBundle) {
                Log.e("Login", "ho gya");
            }

            @Override
            public void doTaskAfterSignOut() {
                Log.e("Logout", "ho gya");
            }
        });
    }

    public void checkPermission(View view) {
        /*permission = new RunTimePermission(this, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                Log.e("C","F");
            }
        });
        permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);*/
        Utils.googleLogout(googleSignIn);
    }

    public void downloadSong(View view) {
        //Utils.downloadMusicFile(url, musicFileName, this);
        /*Utils.facebookLogin(new FBLoginInterface() {
            @Override
            public void doTaskAfterLogin(Bundle facebookBundle) {
                Log.e("Login", "ho gya");
            }
        }, this);*/
        Utils.googleLogin(googleSignIn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FBLogin.onActivityResult(requestCode, resultCode, data);
        googleSignIn.onActivityResult(requestCode, resultCode, data);
    }
}
