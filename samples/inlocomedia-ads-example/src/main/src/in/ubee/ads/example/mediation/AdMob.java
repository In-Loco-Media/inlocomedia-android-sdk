package in.ubee.ads.example.mediation;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public final class AdMob {
    
    public static final String BANNER_AD_UNIT = "";
    public static final String INTERSTITIAL_AD_UNIT = "";

    private AdMob() {}

    public static void interstitial(final Context context) {
        final InterstitialAd iAd = new InterstitialAd(context);
        iAd.setAdUnitId(INTERSTITIAL_AD_UNIT);
        iAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                iAd.show();
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        iAd.loadAd(adRequest);
    }

    public static void banner(final Activity activity) {
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(BANNER_AD_UNIT);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        activity.setContentView(adView);
    }
}
