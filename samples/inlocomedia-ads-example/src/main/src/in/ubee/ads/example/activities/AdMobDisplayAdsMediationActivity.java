package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.ads.example.mediation.AdMob;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;

public class AdMobDisplayAdsMediationActivity extends BaseActivity {

    public static final String DISPLAY_TYPE_KEY = "bundle_key";

    public static final int DISPLAY_BANNER_SMALL = 10;
    public static final int DISPLAY_BANNER_LARGE = 20;
    public static final int DISPLAY_FULL_SCREEN = 30;
    public static final int DISPLAY_TILE = 40;
    public static final int DISPLAY_SMART_BANNER = 50;
    public static final int DISPLAY_BANNER_FULL_IAB = 60;

    private com.google.android.gms.ads.AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_display_ad);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ad_container);

        mAdView = new com.google.android.gms.ads.AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(AdMob.BANNER_AD_UNIT);
        
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
                mAdView.setVisibility(View.VISIBLE);
            }

            public void onAdFailedToLoad(int errorCode) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + errorCode);
                view.setVisibility(View.VISIBLE);

                mAdView.setVisibility(View.INVISIBLE);
            };
        });

        mAdView.setVisibility(View.INVISIBLE);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdView.pause();
    }
}
