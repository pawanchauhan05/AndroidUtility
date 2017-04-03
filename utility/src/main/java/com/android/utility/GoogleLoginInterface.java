package com.android.utility;

import android.os.Bundle;

/**
 * Created by pawan on 1/3/17.
 */

public interface GoogleLoginInterface {
    public void doTaskAfterLogin(Bundle googleBundle);
    public void doTaskAfterSignOut();
}
