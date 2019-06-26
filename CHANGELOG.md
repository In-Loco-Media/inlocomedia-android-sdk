Release 4.5.1 (26/06/2019)
==========================

### Hotfix:
- Fixes SDK instantiation error when not initialized properly

Release 4.5.0 (12/06/2019)
=========================

### Features:
- Improves SDK initialization time

### Fixes:
- Fixes a compatibility issue with gradle 5.1.1

Release 4.4.5 (14/05/2019)
=========================

### Hotfix:
- Removes unused test dependencies from the POM file

Release 4.4.4 (09/05/2019)
=========================

### Hotfix:
- Improves visit detection on Android Pie devices

Release 4.4.3 (07/05/2019)
=========================

### Hotfix:
- Fixes a bug preventing remote configuration of Ads and Engage SDKs

Release 4.4.2 (26/04/2019)
=========================

### Hotfix:
- Internal tweaks to improve reliability 

Release 4.4.1 (24/04/2019)
=========================

### Hotfix:
- Adds option to enable/disable SDK background wake ups

Release 4.4.0 (23/04/2019)
==========================

### Features:
- Improves Ads push notifications with new capabilities

### Refactor:
- Updates Location lifecycle classes, reducing memory consumption
- Reduces CPU usage and number of threads used
- Reduces network usage

### Fixes:
- Fixes RemoteServiceException occurrences

Release 4.3.16 (08/04/2019)
=========================

### Hotfix:
- Fixes data collection problem

Release 4.3.15 (27/03/2019)
=========================

### Hotfix:
- Allows notification ad icon to be set via manifest to prevent mismatched resource ids

Release 4.3.14 (25/03/2019)
=========================

### Hotfix:
- Fixes Google Play Services access in the main thread when using automatic permission requests for notification ads

Release 4.3.13 (01/03/2019)
=========================

### Hotfix:
- Fixes geofence settings

Release 4.3.12 (19/02/2019)
=========================

### Hotfix:
- Fixes unnecessary wakeups

Release 4.3.11 (23/01/2019)
=========================

### Hotfix:
- Fixes thread finishing issue

Release 4.3.10 (18/12/2018)
=========================

### Hotfix:
- Adds missing service options on InLocoMediaOptions

Release 4.3.9 (17/12/2018)
==========================

### Hotfix:
- Fixes app session tracking

Release 4.3.8 (13/12/2018)
==========================

### Hotfix:
- Fixes concurrency error and protects error logging

Release 4.3.7 (06/12/2018)
==========================

### Hotfix:
- Fixes proguard rules to prevent UserProfile.Gender enum obfuscation

Release 4.3.6 (29/11/2018)
==========================

### Hotfix:
- Fixes additional Google Play Services classes not being present on consumer proguard files

Release 4.3.5 (27/11/2018)
==========================

### Hotfix:
- Fixes Google Play Services new classes not being present on consumer proguard files

Release 4.3.4 (14/11/2018)
==========================

### Hotfix:
- Fixes null context on public interface methods

Release 4.3.3 (01/11/2018)
==========================
 
### Hotfix:
- Fixes concurrency problem when setting the privacy consent

Release 4.3.2 (31/10/2018)
==========================

### Hotfix:
- Fixes incorrect location requesting behaviour to reduce battery consumption

Release 4.3.1 (30/10/2018)
==========================

### Hotfix:
- Removes redundant console log
`
Release 4.3.0 (29/10/2018)
==========================

### Features:
- Adds Android Pie support
- Address enrichment with forward-geocoding

### Fixes:
- Checks if bluetooth is enabled before trying to interact with the Bluetooth adapter
- Fixes databases being accessed by different threads

Release 4.2.5 (31/10/2018)
==========================

### Hotfix:
- Fixes incorrect location requesting behaviour to reduce battery consumption

Release 4.2.4 (24/10/2018)
==========================

### Hotfix:
- Fixes data collection, validating each sensor request to prevent system errors on older Android versions

Release 4.2.3 (19/10/2018)
==========================

### Hotfix:
- Prevents memory errors when creating a new thread

Release 4.2.2 (15/10/2018)
==========================

### Hotfix:
- Fixes Visits detection latency issues

Release 4.2.1 (01/10/2018)
==========================

### Hotfix:
- Prevents multiple calls to the `SQLiteDatabase.openDatabase()` method

Release 4.2.0 (28/09/2018)
==========================

### Feature:
- Engage periodic recovery registration
- Engage icon fallback in case of image download failure
- Adds user address to engage user registration

Release 4.1.6 (31/10/2018)
==========================

### Hotfix:
- Fixes incorrect location requesting behaviour to reduce battery consumption

Release 4.1.5 (26/09/2018)
=========================

### Hotfix:
- Adds option to enable/disable the Foreground Service

Release 4.1.4 (21/09/2018)
=========================

### Hotfix:
- Prevents InLocoMediaService crash

Release 4.1.3 (13/09/2018)
==========================

### Hotfix:
- Prevents service crash on Oreo devices or later

Release 4.1.2 (30/08/2018)
===

### Hotfix:
- Prevents crashes during SDK initialization

Release 4.1.1 (27/08/2018)
===

### Hotfix:
- Prevents crash on Lollipop Samsung devices

Release 4.1.0 (24/08/2018)
===

### Features:
- Android Oreo complete support
- Adds several improvements on the location algorithm


### Fixes:
- Several Location SDK bug fixes

Release 4.0.3 (17/08/2018)
===

### Hotfix:
- Decreases daily number of requests

Release 4.0.2 (01/08/2018)
===

### Hotfix:
- Fixes bug that prevented remote configuration on older Android versions

Release 4.0.1 (11/07/2018)
===

### Hotfix:
- Makes EngageUser class available

Release 4.0.0 (10/07/2018)
===

### Features:
- GDPR Support
- Notification channels support
- Adds several improvements on the location algorithm
- Adds app usage events
- Changes the Engage public API

Release 3.5.14 (24/10/2018)
===========================

### Hotfix:
- Fixes data collection, validating each sensor request to prevent system errors on older Android versions

Release 3.5.13 (23/08/2018)
===

### Hotfix:
- Prevents unnecessary registration requests on Engage

Release 3.5.12 (16/08/2018)
===

### Hotfix:
- Decreases daily number of requests

Release 3.5.11 (04/07/2018)
===

### Hotfix:
- Fixes bug that prevented buttons from working on video ads

Release 3.5.10 (08/06/2018)
===

### Hotfix:
- Fixes bug that prevented InLocoEngagementOptions from being persisted

Release 3.5.9 (14/05/2018)
===

### Hotfix:
- Fixes a minor error on the location module

Release 3.5.8 (09/05/2018)
===

### Hotfix:
- Prevents Google Play Services crash from happening on Nexus 5X devices

Release 3.5.7 (30/04/2018)
===

### Hotfix:
- Fixes error on visits detection algorithm

Release 3.5.6 (17/04/2018)
===

### Hotfix:
- Fixes an alarm scheduling error

Release 3.5.5 (16/04/2018)
===

### Hotfix:
- Fixes minor null pointer on location module

Release 3.5.4 (11/04/2018)
===

### Hotfix:
- Fixes error when calling API methods right after init in the main thread

Release 3.5.3 (10/04/2018)
===

### Hotfix:
- Fixes a critical failure when the service is disabled
- Fixes incorrect behaviour after leaving a place to reduce battery consumption

Release 3.5.2 (09/04/2018)
===

### Hotfix:
- Fixes minor database error

Release 3.5.1 (06/04/2018)
===

### Hotfix:
- Fixes bug in location algorithm

Release 3.5.0 (04/04/2018)
===

### Features:
- Bluetooth LE scan support
- Improvements on the SDK thread framework
- Several improvements on the location algorithm
- ActivityRecognition support
- Improvements on connectivity detection

### Fix:
- Fixed disable notifications logic
- Removed HTML pre-load from Notification Ads
- Prevents crashes if Ad Unit Config is invalid
- Fixed thread blocking on GooglePlayServices clients
- Download Image file provider

Release 3.4.3 (21/02/2018)
===

### Hotfix:
- Fixes minor null pointer on location module
- Fix NativeAdRecyclerAdapter behaviour when removing items

Release 3.4.2 (30/01/2018)
===

### Hotfix:
- Fixes Engage public interface

Release 3.4.1 (24/01/2018)
===

### Features:
- Engage opt-in/out

Release 3.4.0 (05/12/2017)
===

### Features:
- Mini Browser improvements
- Optimizations to Location Module and location tracking algorithm
- Video streaming

### Fix:
- Null pointer on base64 encoding
- Location system null pointer errors protected
- Check if the Notification icon is a valid drawable
- Check for permission before reading mobile network info
- Protect mini browser onCreate method
- Check if any app can handle the url before loading on mini browser

Release 3.3.10 (01/11/2017)
===

### Feature:
- Adds support to optional airplane mode broadcast

### Hotfix:
- Fixes Location module behaviour when the phone is rebooted

Release 3.3.9 (27/10/2017)
===

### Hotfix:
- Prevents a crash in older webviews when the locale is changed

Release 3.3.8 (19/10/2017)
===

### Hotfix:
- Fixed null pointer exceptions that happened when there was no listener associated with an Advertisement request

Release 3.3.7 (18/10/2017)
===

### Refactor:
- Optimizes the video viewability detection

Release 3.3.6 (17/10/2017)
===

### Hotfix:
- Fix remote configuration errors

Release 3.3.5 (16/10/2017)
===

### Hotfix:
- Fix mini browser layout issues on some devices

Release 3.3.4 (13/10/2017)
===

### Hotfix:
- Removing Engage dependency with GCM when using Webhook

Release 3.3.3 (10/10/2017)
===

### Hotfix:
- Fixed SecurityException thrown on older devices because of permissions missing
- Fixed page view event registration

### Features
- Improved mini browser layout

Release 3.3.2 (05/10/2017)
===

### Hotfix:
- Fixing null pointer exception when the device did not have sim cards
- Reducing the max size for each request the sdk can make

Release 3.3.1 (28/09/2017)
===
### Hotfix:
- Engage User Id not being sent on request

Release 3.3.0 (27/09/2017)
===

### Features:
- New InLoco Experience and Engage Experience apps
- Rewarded Video Ads
- Portrait Videos
- Optimizations to Location Module and location tracking algorithm

### Fix:
- Video orientation change no longer causes a null pointer
- Prevents redundant data from being sent to Analytics server

### Refactor:
- Refactored modules' architecture
- Refactored modules' initialization
- Refactored Location Tracking
- Removed Protobuf dependency completely

Release 3.2.5 (12/09/2017)
===

### Hotfix:
- Fixed a viewability error for video ads

Release 3.2.4 (01/09/2017)
===

### Hotfix:
- Fixed null pointer exception in InLocoMediaActivity

Release 3.2.3 (30/08/2017)
===

### Hotfix:
- Fixed error that made ACCESS_WIFI_STATE permission obligatory. It's now optional again

Release 3.2.2 (23/08/2017)
===

### Feature:
- Created a WebhookDeviceRequestRequest object to make it easier to register a webhook

### Hotfix:
- Notification Ads working on apps that target Android Oreo when run on devices that are not running Oreo
- Use external browser as default method to show urls
- Music stream is now unmuted after video
- User Id wasn't being attributed when registering an Endpoint on Engage SDK
- Check deep links before using the mini browser

Release 3.2.1 (11/08/2017)
===

### Hotfix:
- Location module exceptions fixed

Release 3.2.0 (09/08/2017)
===

### Feature:
- Ad click destination is shown in an internal mini browser by default
- Protobuf as an optional dependency

### Fix
- Notification ads working again
- Prevent apps targeting android O from crashing
- Increase WebView timeout for video ads

### Refactor
- GCMToken removed from Engage

Release 3.1.5 (02/08/2017)
===

### Refactor:
- Global cache for files

### Hotfix:
- Fixes internal storage trim logic
- Validates video banner

Release 3.1.4 (25/07/2017)
===

### Refactor:
- Refactors Location Service lifecycle

### Fix:
- Several null pointer errors in the Location module
- Files will only be downloaded once in video ads

Release 3.1.3 (18/07/2017)
===

### Hotfix:
- Fix location tracking startup issue
- Fix concurrent modification exception in Location module

Release 3.1.2 (12/07/2017)
===

### Fix:
- Location module concurrency problems
- Remove mandatory push provider token from register device request on Engage SDK

Release 3.1.1 (11/07/2017)
===

### Fix:
- Fix back button error on video ads
- Database insertion failures handled properly
- Location module concurrency problem

Release 3.1.0 (06/07/2017)
===

### Feature:
- Video ads are now supported
- In Loco Engagement SDK released
- Native Ads now support external views
- Enables dom storage for web view
- Improved Location module

### Fix:
- NullpointerExceptions fixed
- Stop throwing geofencing storage exception

### Refactor:
- Removes Custom Ad and Native Offer
- Removes Maps modules

Release 3.0.10 (23/06/2017)
===

### Hotfix:
- Geofencing service error when the location service did not supply the latitude and longitude

Release 3.0.9 (20/06/2017)
===

### Hotfix:
- Enabling AdWebView to receive external load javascript calls

Release 3.0.8 (15/06/2017)
===

### Hotfix
- Missing the RECEIVE_BOOT_COMPLETED permission no longer disables Notification

Release 3.0.7 (12/05/2017)
===

### Hotfix
- Reducing the frequency of updates for the SDK's remote configuration

Release 3.0.6 (27/04/2017)
===

### Refactor:
- Enabling AdWebView to receive external WebViewClient

Release 3.0.5 (26/04/2017)
===

### Hotfix:
- Fixed WebView onDestroy call when Accessibility is enabled

Release 3.0.4 (24/04/2017)
===

### Hotfix:
- Fixing alarm error introduced on 3.0.3

Release 3.0.3 (20/04/2017)
===

### Hotfix:
- Fix javascript errors on Androids below API 15
- Fix location tracking issues with navigation
- Fix request spike on fixed hours

Release 3.0.2 (19/04/2017)
===

### Hotfix:
- Fixing wrong method call on Location Module on devices using api 18 and below

Release 3.0.1 (13/04/2017)
===

### Hotfix:
- Fixing wrong method call on WebView on devices using api 18 and below

Release 3.0.0 (06/04/2017)
===

### Feature:
- InLocoMedia SDK now has two independent modules: Ads and Location, along with the full version
- Improved Location Detection algorithm
- VPaid ads

### Fix:
- Google Play Services hard dependency fixed
- Check permissions and Google Play Services availability before interacting with Geofences
- Calendar errors caused by different time zones

### Refactor:
- Android minimum API version increased to 14
- Google Play Services version increased to 10.2.x
- Several packages were refactored
- Reduced SDK size print

Release 2.5.1 (03/04/2017)
===

### Hotfix:
- Fix SDK Error reporting while on background

Release 2.5.0 (13/02/2017)
===

### Feature:
- Location module improvements

### Fix:
- Location module null pointers and errors fixed

### Refactor:
- SDK completely modularized

Release 2.4.7 (28/11/2016)
===

### Hotfix:
- Prevent SDK from crashing when loading accessibility javascript in older Android versions

Release 2.4.6 (25/11/2016)
===

### Hotfix:
- SharedPreferencesManager is now thread-safe
- Fix InLocoMediaWebView KitKat workaround by adding the second WebView to the same ViewGroup
- NativeAdRecyclerAdapter setOnScrollListener to access the RecyclerView onScrollListener events that were being consumed by the Adapter

Release 2.4.5 (17/11/2016)
===

### Hotfix:
- NativeAdListAdapter setOnScrollListener to access the ListView onScrollListener adapter that was being consumed by the Adapter

Release 2.4.4 (13/11/2016)
===

### Hotfix:
- Error caused when multiple interstitial were shown at the same time

Release 2.4.3 (11/11/2016)
===

### Feature:
- Add Background Location Tracking toggle

Release 2.4.2 (07/11/2016)
===

### Hotfix:
- Fix file storage size limit bug

Release 2.4.1 (04/11/2016)
===

### Hotfix:
- Remove Google Play Services Ads hard dependency
- Fix InLocoMediaService finishing problem

Release 2.4.0 (27/10/2016)
===

### Feature:
- In Loco Media unique user id
- Geofencing module improvements
- Support Android API 25

### Refactor:
- Remove Eclipse support

### Fixed:
- SharedPreferencesManager saving properly when there was an old file
- RecyclerView references without Support v7 library

Release 2.3.10 (21/10/2016)
===

### Hotfix:
- Fix WebView error in Android KitKat

Release 2.3.9 (19/10/2016)
===

### Hotfix:
- Timestamp, Hour and Timezone parameters were being kept constant during the app session

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

