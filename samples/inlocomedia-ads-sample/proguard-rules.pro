#InLocoMedia exceptions
-dontwarn in.ubee.**, com.inlocomedia.**
-keep class in.ubee.**, com.inlocomedia.** { *; }
-keepclassmembers class in.ubee.**, com.inlocomedia.** { *; }

# Support for Android Advertiser ID
-keep class com.google.android.gms.common.GooglePlayServicesUtil {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {*;}

# Support for ActivityRecognition
-keep class com.google.android.gms.location.ActivityRecognition { *; }

# For mediation
#-keepattributes *Annotation*

# Other required classes for Google Play Services
# Read more at http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

# Google Play Service Ads

-keep public class com.google.android.gms.ads.** { public *; }

-keep public class com.google.ads.** { public *; }