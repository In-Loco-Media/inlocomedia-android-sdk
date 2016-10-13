Release 2.3.8 (13/10/2016)
===

### Fix:
- Geofencing Refresh through ad clicking
- Notification Ad click is working again

Release 2.3.7 (07/10/2016)
===

### Fix:
- Remove Google Play Services Location hard dependency

Release 2.3.6 (05/10/2016)
===

### Fix:
- Improved background location tracker, preventing redundancies

Release 2.3.5 (29/09/2016)
===

### Feature:
- Add recovery system to prevent the permanent death of the Location module

Release 2.3.4 (26/09/2016)
===

### Hotfix:
- Fix WebView deadlock in KitKat

Release 2.3.3 (19/09/2016)
===

### Fixed:
- Null Pointer Exception that could occur during InLocoMediaService start process

Release 2.3.2 (14/09/2016)
===

### Fixed:
- Missing GoogleApiAvailability line on consumer proguard
- Older Android API incompatibility problems

Release 2.3.1 (05/09/2016)
===

### Feature:
- Add Android Nougat (7.0) support
- Update Google Play Services dependencies to version 9.4.0

Release 2.3.0-rc4 (03/09/2016)
===
### Fixed:
- Missing advertising id on offline background data collected

Release 2.3.0-rc3 (01/09/2016)
===
### Fixed:
- Restablished Gingerbread support

Release 2.3.0-rc2 (01/09/2016)
===
### Fixed:
- Synchronization error in InLocoMediaService remote configuration

Release 2.3.0-rc1 (31/08/2016)
===
### Feature:
- Improved background location tracker
- Marshmallow runtime permissions added to Mraid save picture option
- AdReceiver and LocationReceiver added in order to modularize InLocoMediaReceiver
- Mraid now supports screen rotation

### Fixed:
- InstallTrackerReceiver failure with wrong tracking URLs
- MiniBrowser now opens urls with deeplinks

Release 2.2.7 (22/08/2016)
===
### Fixed:
- Dependency problem with RecyclerView when Android Support-v7 is not available

Release 2.2.6 (17/08/2016)
===
### Fixed:
- Logs for Install Tracker weren't available

Release 2.2.5 (08/08/2016)
===

### Fixed:
- Error that was making the location unavailable when uploading the collected data

Release 2.2.4 (01/08/2016)
===

### Fixed:
- Removing user applications collector

Release 2.2.3 (21/07/2016)
===

### Fixed:
- Prevented cursor leaks

v2.2.2
===
### Hotfix:
- Fixed error on the application custom configuration request when it was missing the application id

v2.2.1
===
### Hotfix:
- Methods being called without the required permission

v2.2.0 (09/06/2016)
===
### Feature:
- Custom Ads
- Better customization on location profile
- New app install tracker for stores outside google play
- AdRequest with tag filtering

### Fix:
- Release that wasn't accepting .+ versions on gradle
- DevelopmentDevices error that was keeping the app in development mode even after removing the device id

v2.1.4
===
- Hotfix: Errors when storing location data to upload later

v2.1.3
===
- Hotfix: Wifi error when the value from the scan was null

v2.1.2
===
- Hotfix: AndroidManifest.xml file was missing the InLocoMediaReceiver class

v2.1.1
===
- Hotfix: Minimum version for the sdk was wrong on the previous version. Returning to 9

v2.1.0 (08/04/2016)
===
- Updating Protocol Buffers to 2.6.1
- Replaced the identifiers for ub to ilm that were missing on last release
- NativeAd default style replaced from UBNativeAd to Widget.InLocoMedia.NativeAd
- Location initialization error that was causing the device to be unable to locate for a session
- Optimizating Visit Tracker

v2.0.0 (23/03/2016)
===
- NativeListAdapter: Adapter for native to be easier to put on Lists/RecyclerView
- Support for AdUnit
- Easier support to request permissions on Android M when enabling NotificationAds
- Notification Ads Audio/Vibration events now can be configured on the campaings
- Improvement on battery life and targeting capacity for NotificationAds
- Improvement on Viewability detection
- Many improvements on known errors
- Hotfix on a few MRAID scenarios
- Click on Ad is only possible after Viewability is triggered
- 'in.ubee.api' package was replaced with 'com.inlocomedia.android'. Check the guideline to migrate from v1 to v2
- AdView lifecycle methods changed
- AdvertisementView was removed (AdView is being used as default since release 1.6)
- NativeAd button can now be a regular TextView
- Removed 'Secret' from the sdk init method

v1.11.5
===
- Feature: Age range included on UserProfile
- Hotfix: Wrong database synchronization monitor

v1.11.4
===
- Hotfix: UserProfile not working properly for Native nor Notification Ads

v1.11.3
===
- Hotfix: InterstitialAd onCreate error
- Optimization: Reducing sensors usage on the application start

v1.11.2
===
- Hotfix: Proguard obfuscating wrong class 

v1.11.1
===
- Hotfix: Wrong flow for the first wifi scan on android m

v1.11.0 (25/10/2015)
===
- MRAID
- Support for Android M

v1.10.9
===
- Hotfix: Notification error when there was multiple targets on a small radius

v1.10.8
===
- Hotfix: AdView invalid state on AdContent loading error

v1.10.7
===
- Optimizating GPS provider decision

v1.10.6
===
- Hotfix: Unused cached location

v1.10.5
===
- Hotfix: Wrong timestamp used for IndoorTimestamp

v1.10.4
===
- Hotfix: Missing error description when an Internal Error happens while requesting ads

v1.10.3
===
- Hotfix: Geocode reverse error

v1.10.2
===
- Optimizating Fill Rate with ACESS_WIFI_STATE permission

v1.10.1
===
- Hotfix: NativeAd request failure wasn't printing on the log
- Hotfix: NativeAd request wasn't notifying failures

v1.10 (25/07/2015)
===
* Feature: Support for MoPub Native Ads mediation
* OnLocationListener replaced with LocationListener
* Battery Optimizations for Notification Ads
* Hotfix: ACCESS_WIFI_STATE was still required
* Small bugfixes

v1.9.3
===
* Removing ACCESS_WIFI_STATE and CHANGE_WIFI_STATE as required permissions.
* Hotfix: Analytics location error

v1.9.2
===
* Bugfixes

v1.9.1 
===
* Hotfix: Proguard wrong code stripping

v1.9.0 (04/06/2015)
===
* Feature: Optimizating notification delivery
* Bugfixes

v1.8 (20/04/2015)
===
* Hotfix: Solving Issue [#1][https://github.com/In-Loco-Media/inlocomedia-android-sdk/issues/1]
* Hotfix: FeedAdapter reloading error
* Hotfix: InterstitialAd notifyAdReady without registered listeners
* Increasing IndoorLocation precision
* AdView refresh is now resuming after being previously paused
* AdView register a new ScreenStateReceiver only when the auto refresh is enabled.
* Method ubeeOptions.setDevelopmentMode(boolean) is now deprecated, use ubeeOptions.setDevelopmentDeviceId(String...) instead.
* Updated gradle plugin to 1.1.0
* UserProfile usage is now modified (As a result if you are using the old mediation library (<= 1.2.3) you will need to update it)

v1.7.7
===
* Hotfix for the DisplayAd WebView that was failing to load some advertisements

v1.7.6
===
* Included maps sample project
* Hotfix for the InterstitialAd that was logging the fail error twice

v1.7.5
===
* Removing necessity for the proguard '-keepattributes Signature' option for the ads project

v1.7.4
===
* New ad targets included
* Hotfix for AdvertisementView missing one of the constructors

v1.7.3
===
* Updating AdRequest timeout for display and interstitial ads

v1.7.2
===
* Hotfix: AdView timeout wasn't cancelling the request correctly

v1.7.1
===
* Included required permissions on the sdk manifest for auto merge

v1.7 (11/02/2015)
===

* Replacing AdvertisementView with AdView
* The project is now on Maven Central
* Optimizating the Ad deliver (Speed and Fill Rate)
* Included new AdSize: MEDIUM_RECTANGLE
* Included interface for DSP exchange

