#InLocoMedia exceptions

-dontwarn in.ubee.**
-keep public class in.ubee.**
-keepclassmembers public class in.ubee.* {
    *;
}

-dontwarn com.inlocomedia.**
-keep public class com.inlocomedia.**
-keepclassmembers public class com.inlocomedia.* {
    *;
}

#InLocoMedia GooglePlayServices exceptions requirements
-keep public class com.google.android.gms.common.GooglePlayServicesUtil, com.google.android.gms.ads.identifier.** { *; }

-keepclassmembers public class com.google.android.gms.common.GooglePlayServicesUtil, com.google.android.gms.ads.identifier.** { *; }

