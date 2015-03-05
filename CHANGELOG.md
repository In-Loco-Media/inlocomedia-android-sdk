v1.7.5
===
* Removing necessity for the proguard '-keepattributes Signature' option 


v1.7.4
===

* New ad targets included
* Hotfix: AdvertisementView missing one of the constructors

v1.7.3
===

* Adjustments on AdRequest timeout for display and interstitial ads

v1.7.2
===

###Hotfixes
* AdView timeout wasn't cancelling the request correctly

###Refactor
* Fixed a memory leak in SplashActivity (sample project)
* Removed WebImageView and TypefacedTextView
* Removed res/layout/ub_native*.xml from the SDK to the sample project

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

