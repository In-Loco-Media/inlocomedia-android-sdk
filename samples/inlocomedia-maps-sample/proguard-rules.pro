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