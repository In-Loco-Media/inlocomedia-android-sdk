package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.ads.example.activities.util.ListItem;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.AdView;
import in.ubee.api.ads.AdViewListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class DisplayAdsActivity extends BaseActivity {

    public static final String DISPLAY_TYPE_KEY = "bundle_key";

    public static final int DISPLAY_BANNER_SMALL = 10;
    public static final int DISPLAY_BANNER_LARGE = 20;
    public static final int DISPLAY_FULL_SCREEN = 30;
    public static final int DISPLAY_TILE = 40;
    public static final int DISPLAY_SMART_BANNER = 50;
    public static final int DISPLAY_BANNER_FULL_IAB = 60;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_display_ad);

        ListItem item = (ListItem) getIntent().getSerializableExtra(MainActivity.EXTRA_ITEM);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ad_container);
        
        mAdView = new AdView(this);
        mAdView.setType(item.getAdType());
        mAdView.setAdListener(new AdViewListener() {
            @Override
            public void onAdViewReady(AdView adView) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
                adView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdError(AdView adView, AdError adError) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + adError);
                view.setVisibility(View.VISIBLE);

                adView.setVisibility(View.INVISIBLE);
            }
        });
        
        mAdView.loadAd();
        
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        
        mAdView.setVisibility(View.INVISIBLE);
        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdView.onPause();
    }
}
