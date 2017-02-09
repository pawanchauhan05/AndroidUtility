# AndroidUtility

## Features
	* Utility function for shared preference
		* save and get boolean value
		* save and get int value
		* save and get String value
		* save and get custom object
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


>**_"in Utils.readPreferenceData() method third perameter in default value"_**

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


