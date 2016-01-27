package com.inlocomedia.ads.sample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.ListItem;

import in.ubee.api.ads.AdError;
import in.ubee.api.ads.AdType;
import in.ubee.api.ads.AdView;
import in.ubee.api.ads.AdViewListener;

/**
 * Created by: larissa
 * Date: 1/27/16
 * Time: 2:25 PM
 */
public class NativeAdActivity extends Activity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_native_ad);

        // The selected item list from the previous screen that contains the AdType that will be loaded
        ListItem item = (ListItem) getIntent().getSerializableExtra(MainActivity.EXTRA_ITEM);

        FrameLayout parent = (FrameLayout) findViewById(R.id.native_ad_container);

        // Inflate correct layout
        LayoutInflater inflater = LayoutInflater.from(this);

        if (item.getAdType() == AdType.NATIVE_LARGE) {
            mAdView = (AdView) inflater.inflate(R.layout.native_ad_large, parent, false);

        } else if (item.getAdType() == AdType.NATIVE_SMALL) {
            mAdView = (AdView) inflater.inflate(R.layout.native_ad_small, parent, false);
        }

        mAdView.setVisibility(View.INVISIBLE);

        // Set the AdType
        mAdView.setType(item.getAdType());

        // Register a listener to receive notifications for the AdView events
        mAdView.setAdListener(new AdViewListener() {
            public void onAdViewReady(AdView adView) {
                /**
                 * The AdView is ready to be shown
                 */
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdError(AdView adView, AdError adError) {
                /**
                 * The AdView load has failed. Check the AdErrors to discover the reason
                 */
                onError(adError.toString());
            }
        });

        mAdView.loadAd();

        // Display the ad
        parent.addView(mAdView);
    }

    private void onError(String error) {
        // Show the DisplayAdActivity with the AdError
        TextView view = (TextView) findViewById(R.id.native_description);
        view.setText("Error: " + error);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Notify the Activity's lifecycle
        mAdView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Notify the Activity's lifecycle
        mAdView.pause(isFinishing());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Notify the Activity's lifecycle
        mAdView.destroy();
    }
}
