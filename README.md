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
	* Show short or long toast

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

### Show short or long toast
	* Show Short Toast
		Utils.generateShortToast(getActivity(), "toast_message");

	* Show Long Toast
		Utils.generateLongToast(getActivity(), "toast_message");

## Getting Help

To report a specific problem or feature request, [open a new issue on Github](https://github.com/pawanchauhan05/AndroidUtility/issues/new).



