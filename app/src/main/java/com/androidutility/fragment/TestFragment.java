package com.androidutility.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.utility.AlertDialog;
import com.android.utility.RunTimePermission;
import com.android.utility.RuntimePermissionInitializerInterface;
import com.android.utility.Utils;
import com.androidutility.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment implements RuntimePermissionInitializerInterface {
    private RunTimePermission permission;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        view.findViewById(R.id.buttonSelectImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.selectImage(getActivity(), TestFragment.this, "Select Image");
            }
        });
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(getRuntimePermission() != null)
            getRuntimePermission().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AlertDialog.imageHelperInterface.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setRuntimePermission(RunTimePermission runTimePermission) {
        this.permission = runTimePermission;
    }

    @Override
    public RunTimePermission getRuntimePermission() {
        return permission;
    }

    @Override
    public void setBitmap(Bitmap bitmap) {

    }
}
