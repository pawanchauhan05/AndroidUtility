# AndroidUtility

Android Utility is combination of normal utility functions like described below in feature section. I decided to implement completely almost all features in order to make Android Utility easy to use for everyone and extensible as possible.

## Features
	* Utility function for shared preference
		* save and get boolean value
		* save and get int value
		* save and get String value
		* save and get custom object
		* clear perticular key data
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


## Usage
### Steps
#### Add gradle dependecy

```
dependencies {
  compile 'com.android.utility:Android-Utility:{latest_release}'
}
```
## How to use ?
### Shared Preference
#### Save and get boolean value from shared perference
	* Save boolean type value
		Utils.savePreferenceData(getContext(), "BOOLEAN_KEY", true);

	* Get boolean type value
		Utils.readPreferenceData(getContext(), "BOOLEAN_KEY", false);

#### Save and get int value from shared perference
	* Save int type value
		Utils.savePreferenceData(getContext(), "INT_KEY", 5);

	* Get int type value
		Utils.readPreferenceData(getContext(), "INT_KEY", 0);

#### Save and get String value from shared perference
	* Save String type value
		Utils.savePreferenceData(getContext(), "STRING_KEY", "STRING_VALUE");

	* Get String type value
		Utils.readPreferenceData(getContext(), "STRING_KEY", "");

#### Save and get custom object value from shared perference
	* Save custom object value
		Utils.savePreferenceData(getContext(), "CUSTOM_KEY", customObject);

	* Get custom object value
		Utils.readPreferenceData(getContext(), "CUSTOM_KEY", customObject, CustomObject.class);

#### Clear perticular key data
	Utils.removePreferenceData(getActivity(), "REMOVE_KEY");

#### clear all shared preference
	Utils.clearPreferences(getActivity());


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
```

>**_"To prevent application to crash you also have to add permission in application manifest file"_**

### Download audio, video, image file
	* Download Audio file
		Utils.downloadMusicFile("music_url", "music_file_name", getActivity());

	* Download Video File
		Utils.downloadVideoFile("video_url", "video_file_name", getActivity());

	* Download Image File
		Utils.downloadImageFile("image_url", "image_file_name", getActivity());

### Show or Hide custom or default progress dialog
	* Show Custom Progress Dialog
		ProgressDialog progressDialog = new ProgressDialog(getActivity());
		Utils.showProgressBar(progressDialog);

	* Show Default Progress Dialog
		ProgressDialog progressDialog = new ProgressDialog(getActivity());
		Utils.showProgressBar("progress_dialog_title", "progress_dialog_message", progressDialog);

	* Hide Progress Dialog
		Utils.hideProgressBar(progressDialog);

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
		FileDBUtils<CustomObject> fileDBUtils = new FileDBUtils<>(getActivity(), "file_name", CustomObject.class, "/db/custom");
		fileDBUtils.saveObject(customObjectInstance);

	* Read custom object from file
		FileDBUtils<CustomObject> fileDBUtils = new FileDBUtils<>(getActivity(), "file_name", CustomObject.class, "/db/custom");
		fileDBUtils.readObject();

### Create directory (from path) and delete directory with files
	* Create directory form path
		Utils.createDirectory(getActivity(), "top/main/sub");

	* Delete directory including files
		Utils.deleteDirectory(getActivity(), "top/main/sub");

### Show short or long length toast
	* Show Short Toast
		Utils.generateShortToast(getActivity(), "toast_message");

	* Show Long Toast
		Utils.generateLongToast(getActivity(), "toast_message");

### Show short or long length snack bar
	* Show Short length Snack bar
		Utils.showShortSnackBar(getActivity(), "Snack bar message");

	* Show Long length Snack bar
		Utils.showLongSnackBar(getActivity(), "Snack bar message");

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
* Hide keyboard panel
```java
Utils.hideKeyboard(getActivity());
```
* Choose image from camera or gallery
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
## Getting Help

To report a specific problem or feature request, [open a new issue on Github](https://github.com/pawanchauhan05/AndroidUtility/issues/new).



