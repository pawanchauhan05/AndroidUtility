# AndroidUtility

Android Utility is combination of normal utility functions like described below in feature section. I decided to implement completely almost all features in order to make Android Utility easy to use for everyone and extensible as possible.

## Features
* Utility function for shared preference
    * save and get boolean value
	* save and get int value
	* save and get String value
	* save and get custom object
	* clear particular key data
	* clear all shared preference
* Runtime Permission for marshmallow and above sdk
* Download audio, video, image file
* Show custom or default progress dialog
* Check app foreground state
* Check internet connectivity
* Read and write custom object from file
* Create directory (from path) and delete directory with files
* Show short or long length toast
* Show short or long length snackbar
* Alert Dialog
	* show single button alert dialog
	* show multi button alert dialog
	* show date picker dialog
	* show time picker dialog
* Hide keyboard panel
* Choose image from camera or gallery
* Endless Scrolling for List view
* Endless Scrolling for Recycler view
* Circular Image View
* Login with Facebook
* Login with Google

## Usage
### Steps
#### Add gradle dependecy

```
dependencies {
  compile 'com.github.pawanchauhan05:utility:0.0.3'
}
```
## How to use ?
### Shared Preference
#### Save and get boolean value from shared perference
* Save boolean type value
```java
Utils.savePreferenceData(getContext(), "BOOLEAN_KEY", true);
```
* Get boolean type value
```java
Utils.readPreferenceData(getContext(), "BOOLEAN_KEY", false);
```

#### Save and get int value from shared perference
* Save int type value
```java
Utils.savePreferenceData(getContext(), "INT_KEY", 5);
```
* Get int type value
```java
Utils.readPreferenceData(getContext(), "INT_KEY", 0);
```

#### Save and get String value from shared perference
* Save String type value
```java
Utils.savePreferenceData(getContext(), "STRING_KEY", "STRING_VALUE");
```
* Get String type value
```java
Utils.readPreferenceData(getContext(), "STRING_KEY", "");
```

#### Save and get custom object value from shared perference
* Save custom object value
```java
Utils.savePreferenceData(getContext(), "CUSTOM_KEY", customObject);
```
* Get custom object value
```java
Utils.readPreferenceData(getContext(), "CUSTOM_KEY", customObject, CustomObject.class);
```

#### Clear particular key data
```java
Utils.removePreferenceData(getActivity(), "REMOVE_KEY");
```

#### clear all shared preference
```java
Utils.clearPreferences(getActivity());
```


>**_"in Utils.readPreferenceData() method third perameter is default value"_**

### Runtime Permission for marshmallow and above SDK
```java
RunTimePermission permission = new RunTimePermission(this, new RuntimePermissionInterface() {
            @Override
            public void doTaskAfterPermission() {
                Log.e("Task","Add you task which want to complete after getting permission");
            }
        });
permission.runtimePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permission.onRequestPermissionsResult(requestCode, permissions, grantResults);
}
```

>**_"To prevent application to crash you also have to add permission in application manifest file"_**

### Download audio, video, image file
* Download Audio file
```java
Utils.downloadMusicFile("music_url", "music_file_name", getActivity());
```
* Download Video File
```java
Utils.downloadVideoFile("video_url", "video_file_name", getActivity());
```
* Download Image File
```java
Utils.downloadImageFile("image_url", "image_file_name", getActivity());
```

### Show or Hide custom or default progress dialog
* Show Custom Progress Dialog
```java
ProgressDialog progressDialog = new ProgressDialog(getActivity());
Utils.showProgressBar(progressDialog);
```
* Show Default Progress Dialog
```java
ProgressDialog progressDialog = new ProgressDialog(getActivity());
Utils.showProgressBar("progress_dialog_title", "progress_dialog_message", progressDialog);
```
* Hide Progress Dialog
```java
Utils.hideProgressBar(progressDialog);
```

>**_"use same progress dialog instance to hideProgressBar() that used for showProgressBar()"_**

### Check app foreground state
```java
Utils.hasAppInForeground(getActivity());
```
hasAppInForeground() method returns boolean value.
>**_"true = app in foreground AND false = app in background"_**

### Check internet connectivity
```java
Utils.hasInternetAccess();
```
hasInternetAccess() method returns boolean value.
>**_"true = having internet access AND false = do not have internet access"_**

### Read and write custom object from file
* Write custom object to file
```java
FileDBUtils<CustomObject> fileDBUtils = new FileDBUtils<>(getActivity(), "file_name", CustomObject.class, "/db/custom");
fileDBUtils.saveObject(customObjectInstance);
```
* Read custom object from file
```java
FileDBUtils<CustomObject> fileDBUtils = new FileDBUtils<>(getActivity(), "file_name", CustomObject.class, "/db/custom");
fileDBUtils.readObject();
```

### Create directory (from path) and delete directory with files
* Create directory form path
```java
Utils.createDirectory(getActivity(), "top/main/sub");
```
* Delete directory including files
```java
Utils.deleteDirectory(getActivity(), "top/main/sub");
```

### Show short or long length toast
* Show Short Toast
```java
Utils.generateShortToast(getActivity(), "toast_message");
```
* Show Long Toast
```java
Utils.generateLongToast(getActivity(), "toast_message");
```
### Show short or long length snack bar
* Show Short length Snack bar
```java
Utils.showShortSnackBar(getActivity(), "Snack bar message");
```
* Show Long length Snack bar
```java
Utils.showLongSnackBar(getActivity(), "Snack bar message");
```
### Alert Dialog
* Show Single Button Alert Dialog
```java
Utils.showSingleButtonAlertDialog(this, "button_text", "dialog_title", "dialog_message", new AlertDialogSingleInterface() {
    @Override
    public void doTaskOnClick() {
	    // TODO add code which want to execute on button click
    }
});
```
* Show Multi Button Alert Dialog
```java
Utils.showMultiButtonAlertDialog(this, "positive_button_name", "negative_button_name", "dialog_title", "dialog_message", new AlertDialogInterface() {
            @Override
            public void positiveButtonPressed() {
                // TODO add code which want to execute on click positive button
            }

            @Override
            public void negativeButtonPressed() {
                // TODO add code which want to execute on click negative button
            }
        });
```
* Show Date picker dialog
```java
Utils.showDatePicker(getSupportFragmentManager(), new DateInterface() {
    @Override
    public void setDate(Date date) {
    	// TODO get date after select from date picker dialog   
    }
});
```
* Show Time picker dialog
```java
Utils.showTimePicker(getSupportFragmentManager(), new TimeInterface() {
    @Override
    public void setTime(int hour, int minute, String am_pm) {
	    // TODO get time after select from time picker dialog     
    }
});
```
### Hide keyboard panel
```java
Utils.hideKeyboard(getActivity());
```
### Choose image from camera or gallery
```java
public class TestFragment extends Fragment implements RuntimePermissionInitializerInterface {
    private RunTimePermission permission;

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
	    // TODO get select image file in bitmap format
    }
}
```
>**_"implement RuntimePermissionInitializerInterface, override onRequestPermissionsResult(), onActivityResult() method is compulsory."_**

### Endless Scroll for List View
```java
listViewInstance.setOnScrollListener(new ListViewEndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                /*
                TODO
                1. show progress dialog
                2. Load data from api
                3. hide progress dialog
                */
                return false; // ONLY if more data is actually being loaded; false otherwise.
            }
        });
```
### Endless Scroll for Recycler View
```java
LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
recyclerViewInstance.setLayoutManager(linearLayoutManager);
recyclerViewInstance.addOnScrollListener(new RecyclerViewEndlessScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
            /*
            TODO
            1. Show progress Dialog
            2. load data from api
            3. Hide progress Dialog
            */
            }
        });
```
### Circular image view
```xml
<com.android.utility.CircularImageView
    android:id="@+id/circularImageView"
    android:src="@drawable/drawable_name"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```
```java
// set image using java
Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.drawable_name);
circularImageViewInstance.setImageBitmap(icon);
```
### Login with Facebook
#### Follow steps described below
* AndroidManifest.xml
```xml
<application>
    <meta-data android:name="com.facebook.sdk.ApplicationId" android:value="@string/facebook_app_id"/>
</application>
```
* strings.xml
```xml
<resources>
    <string name="facebook_app_id">add_facebook_app_id</string>
</resources>
```
* Java code
```java
Utils.facebookLogin(new FBLoginInterface() {
            @Override
            public void doTaskAfterLogin(Bundle facebookBundle) {
                // code to be executed after FB login
            }
        }, getActivity());
        
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    FBLogin.onActivityResult(requestCode, resultCode, data);
}
```
### Login with Google
#### Follow steps described below
* build.gradle (project level gradle file)
```xml
buildscript {
    dependencies {
        classpath 'com.google.gms:google-services:3.0.0'
    }
}
```
* build.gradle (app level gradle file)
```xml
apply plugin: 'com.android.application'
dependencies {
    compile 'com.google.android.gms:play-services-auth:10.2.0'
}
apply plugin: 'com.google.gms.google-services'
```
* java file
```java
private GoogleSignIn googleSignIn;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    googleSignIn = new GoogleSignIn(this, new GoogleLoginInterface() {
        @Override
        public void doTaskAfterLogin(Bundle googleBundle) {
            // code to be executed after Google login
        }

        @Override
        public void doTaskAfterSignOut() {
            // code to be executed after Logout from Google
        }
    });
}

private void googleLogin() {
    Utils.googleLogin(googleSignIn);
}

private void googleLogout() {
    Utils.googleLogout(googleSignIn);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    googleSignIn.onActivityResult(requestCode, resultCode, data);
}
```
>**_"Add google-services.json at application level."_**

## Release Notes
### v0.0.3
* Bug fixes
* Marshmallow permission support added for fragment also
* Endless scroll for list view
* Endless scroll for recycler view
* Circular image view
* Login with Facebook
* Login with Google

### v0.0.2
* Bug fixes
* Show short or long length snackbar
* Alert Dialog
	* show single button alert dialog
	* show multi button alert dialog
	* show date picker dialog
	* show time picker dialog
* Hide keyboard panel
* Choose image from camera or gallery

### v0.0.1
* Utility function for shared preference
    * save and get boolean value
	* save and get int value
	* save and get String value
	* save and get custom object
	* clear particular key data
	* clear all shared preference
* Runtime Permission for marshmallow and above sdk
* Download audio, video, image file
* Show custom or default progress dialog
* Check app foreground state
* Check internet connectivity
* Read and write custom object from file
* Create directory (from path) and delete directory with files
* Show short or long length toast

## Contribution
I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using `CMD`+`Option`+`L` (Reformat code) on Mac (not sure for Windows) with Android Studio defaults.
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
  4. Pull requests _must_ be made against `developer` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Check for existing [issues](https://github.com/pawanchauhan05/AndroidUtility/issues/new) first, before filing an issue.
  6. Have fun!

## Getting Help

To report a specific problem or feature request, [open a new issue on Github](https://github.com/pawanchauhan05/AndroidUtility/issues/new).



