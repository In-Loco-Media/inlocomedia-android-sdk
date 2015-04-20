package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import com.inlocomedia.ads.sample.activities.util.ListItem;

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
