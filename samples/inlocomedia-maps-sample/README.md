Requirements
===
* Minimum supported version: Android API 14
* [Protocol Buffers] [protobuff] (Already included on the repository)
* (Recommended) Google Play Services (Ads) 6.5.87 & up.

1. Register your App
===
Create your application [**here**] [create_app] (You will need to have an account to do that).

2. Adding the SDK to your project
===
2a. Using Android Studio
---

- Include the following line to your build.gradle file
```groovy
    compile 'com.inlocomedia.android:android-sdk:1.7.+'
```
- Include the dependencies
```
compile 'com.android.support:support-v4:21.0.+'
compile 'com.google.android.gms:play-services-ads:6.5.+'
```

2b. Using Eclipse
---

- Download the latest [*InLocoMedia Android SDK*] [library_project]. Or clone it at *https://github.com/In-Loco-Media/inlocomedia-android-sdk.git*.

- Select **File > Import**.
- Select **Existing Android Code Into Workspace** and click **Next**.
- Browse to the *inlocomedia-android-sdk/sdk/* folder.
- Click Finish to import the project. You should now see a new project titled *inlocomedia-android-sdk*.

You now have a library project for the InLocoMedia SDK that you can use with one or more application projects.

Add the library to your application project:

- In the Project Explorer, right-click your project and select **Properties**.
- In the category panel on the left side of the dialog, select **Android**.
- In the Library pane, click the **Add** button.
- Select the *inlocomedia-android-sdk* library project and click **OK**.
- In the properties window, click **OK**.

> We use the Android Support Library v4, so if you use it in your project, it may cause conflict. You can just remove the one from your project, copy yours to our project, or copy ours to your project, which is on your folder libs/android-support-v4.jar.

#### Dependencies 
- Android Support Library v4 *(Already included on the InLocoMedia Android SDK)*
- Google Protocol Buffers v2.5.0 *(Already included on the InLocoMedia Android SDK)*
- Google Play Services SDK (Download [**here**] [google_play_services_doc_install]).

3. Update your AndroidManifest.xml
===
 
Add the following permissions to your manifest file:
```xml
<manifest>
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
</manifest>
```
Adding the following Activity and Service to your manifest file:
```xml
<application> 
    [...]
    <service android:name="in.ubee.api.location.LocationService" 
        android:exported="false"/>
</application>
```

4. Include Google Play Services SDK
===
Add the Google Play Services SDK to your application project.

```xml
<application> 
    [...]
    <meta-data
        android:name="com.google.android.gms.version"
        android:value="@integer/google_play_services_version" />
</application>
```

> If you need some help, see the official [**documentation**] [google_play_services_doc] to integrate the Google Play Services SDK.
5. Initializating SDK
---

You will need to use your application id (app_id) and secret (app_secret) that you received when you created your application [**here**] [create_app].
Just add the lines below in your first Activity onCreate method.
```java
UbeeOptions options = UbeeOptions.getInstance(this);
options.setMapsKey(<Your_Maps_Key>,<Your_Maps_Secret>);
options.setLogEnabled(true);
Ubee.init(this, options);
```
----------------------
Usage Indoor Location
===
- Register/Unregister a context to receive the device current indoor location

```java
private OnLocationListener mLocationListener = new OnLocationListener() {

    @Override
    public void onLocationChanged(in.ubee.api.models.Location location) {
        mIndoorMapView.setUserLocation(location);
    }

    @Override
    public void onError(LocationError locationError) {
        Log.w(TAG, "Location Received error: " + locationError.getValue());
    }

};

@Override
protected void onResume() {
    super.onResume();
    Ubee.registerLocationCallback(this, mLocationListener);
}

@Override
protected void onPause() {
    super.onPause();
    Ubee.unregisterLocationCallback(this, mLocationListener);
}
```

------------------
Request User Retails
==
Request the list of the retails authorized for the user application 
```java
Ubee.requestRetails(context, new RetailsRequestListener() {
    @Override
    public void onRequestFinished(List<Retail> retails) {}

    @Override
    public void onRequestFailed(UbeeAPIException e) {}
});
```

------------------
Usage IndoorMapView
==

###Current Features: 
- Zoom
- Translation
- Fling
- SVG Parser

###QuickStart:
- Load a retail at the view
- Receive the list of retail maps loaded for the selected retail on the method **onRetailLoadFinished(Retail retail, List<RetailMap> retailMaps)**
- Use one of the following methods switch floors (No map will be shown until any of the following methods are run)

```java
public void setPreviousFloor();
public void setNextFloor();
public void setFloor(int floor);
```

###Example

```java

public class MyClass extends Activity {
    private IndoorMapView mIndoorMapView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndoorMapView = new IndoorMapView(this);

        mIndoorMapView.setRetailById("your_retail_id", new MapViewLoadListener() {
        
	    	@Override
	    	public void onRetailLoadFinished(Retail retail, List<RetailMap> retailMaps) {
                /**
                 * The IndoorMapView is ready to show the maps. You can choose a retail map to be shown or just show the next floor
                 */
        		mIndoorMapView.setNextFloor();
                // mIndoorMapView.setRetailMap(retailMaps.get(0));
	    	}


            @Override
            public void onRetailMapLoadFinished(RetailMap retailMap) {
                /**
                 * The map is already ready to be shown
                 */
            }
        
		
	    	@Override
	    	public void onLoadError(UbeeAPIException e) {
                Log.w(TAG, "Error: " + e.getMessage(), e);
            }
        });

        this.setContentView(mIndoorMapView);
	}
}
```
####You can also validate if there is a floor to be shown on the next/previous methods.
```java
public boolean hasNextFloor();
public boolean hasPreviousFloor();
```
###Loading the user position
```java 
public void setUserLocation(Location newLocationPoint);
```

####Usage
Steps:
- Create your IndoorMapView.
- Create the OnMapsLocationListener
- Pass the callback of OnLocationChanged(Location location) to the IndoorMapView.
- Register the LocationCallback when you want to start tracking
- Unregister the LocationCallback when you want to stop tracking

####Example
```java
IndoorMapView mIndoorMapView = [...];
OnMapsLocationListener mLocationListener =  new OnMapsLocationListener() {

	@Override
	public void onLocationChanged(Location location) {
		if (mIndoorMapView != null && mIndoorMapView.isRetailLoaded()) {
			mIndoorMapView.setUserLocation(location);
		}
	}
    	@Override
	public void onError(LocationError locationError) {}
};
Ubee.registerLocationCallback(context, mLocationListener);
[...]
Ubee.unregisterLocationCallback(context, mLocationListener);

```
---

[android_support_library]: http://developer.android.com/tools/support-library/setup.html
[v4_download_link]: https://s3.amazonaws.com/mobile-api/android-support-v4.jar
[library_project]: https://github.com/in-loco-media/inlocomedia-android-sdk/archive/master.zip
[maps_demo_project]: https://github.com/ubee/ubee-maps-example
[create_app]: http://maps.ubee.in/oauth/applications/new
[javadocs]: http://ubee.github.io/ubee-maps-example
[google_play_services_doc_install]: http://developer.android.com/google/play-services/setup.html#Install
[google_play_services_doc]: http://developer.android.com/google/play-services/setup.html

