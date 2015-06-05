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

v1.7
===

* Replacing AdvertisementView with AdView
* The project is now on Maven Central
* Optimizating the Ad deliver (Speed and Fill Rate)
* Included new AdSize: MEDIUM_RECTANGLE
* Included interface for DSP exchange

