package com.android.utility;

import android.graphics.Bitmap;

/**
 * Created by pawan on 15/2/17.
 */

public interface RuntimePermissionInitializerInterface {
    public void setRuntimePermission(RunTimePermission runTimePermission);
    public RunTimePermission getRuntimePermission();
    public void setBitmap(Bitmap bitmap);
}
