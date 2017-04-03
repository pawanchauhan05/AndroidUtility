package com.android.utility;

import android.os.Bundle;

/**
 * Created by pawan on 28/2/17.
 */

public interface FBLoginInterface {
    /**
     * this function is execute after fbLogin successful.
     * @param facebookBundle - facebookBundle contains (profile_pic, idFacebook, first_name, last_name, email, gender, birthday, location)
     */
    public void doTaskAfterLogin(Bundle facebookBundle);
}
