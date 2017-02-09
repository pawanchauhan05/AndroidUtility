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
### How to use ?
#### Save and get boolean value from shared perference
	* Save boolean value
		```
		Utils.savePreferenceData(getContext(), "BOOLEAN_KEY", true);
		```
	* Get boolean value
		```
		Utils.readPreferenceData(getContext(), "BOOLEAN_KEY", false);

		in readPreferenceData() method third perameter in default value 
		```


