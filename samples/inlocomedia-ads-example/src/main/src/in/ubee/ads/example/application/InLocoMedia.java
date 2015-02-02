package in.ubee.ads.example.application;

import in.ubee.api.Ubee;
import in.ubee.api.UbeeOptions;
import in.ubee.api.ads.AdRequest;
import in.ubee.api.profile.UserProfile;
import android.content.Context;


public final class InLocoMedia {
    
    private InLocoMedia() {}

    public static void setup(final Context context) {
        UbeeOptions options = UbeeOptions.getInstance(context);
        options.setDevelopmentEnvironment(Settings.DEBUG);
        options.setLogEnabled(true);
        
        /**
         * App key - App User Id from ubee - find in http://inlocomedia.com/
         * App Secret - App Secret from ubee - find in http://inlocomedia.com/
         */
        options.setAdsKey(Settings.INLOCOMEDIA_KEY, Settings.INLOCOMEDIA_SECRET);

        Ubee.init(context, options);

        AdRequest adRequest = AdRequest.defaultRequest(context);
        adRequest.setUserProfile(new UserProfile(10, UserProfile.Gender.MALE));
        adRequest.saveAsDefaultRequest(context);
    }
}
