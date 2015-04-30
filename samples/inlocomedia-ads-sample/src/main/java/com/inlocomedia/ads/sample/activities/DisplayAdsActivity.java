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

        // The selected item list from the previous screen that contains the AdType that will be loaded
        ListItem item = (ListItem) getIntent().getSerializableExtra(MainActivity.EXTRA_ITEM);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ad_container);

        // Instantiate the AdView
        mAdView = new AdView(this);

         // Set the AdType
        mAdView.setType(item.getAdType());

        // Register a listener to receive notifications for the AdView events
        mAdView.setAdListener(new AdViewListener() {
            public void onAdViewReady(AdView adView) {

                /**
                 * The AdView is ready to be shown
                 */

                // Hides the DisplayAdActivity notifying text
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAdError(AdView adView, AdError adError) {

                /**
                 * The AdView load has failed. Check the AdErrors to discover the reason
                 */

                // Show the DisplayAdActivity with the AdError
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + adError);
                view.setVisibility(View.VISIBLE);
            }
        });

        // Loads the AdView
        mAdView.loadAd();

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Notify the Activity's lifecycle
        mAdView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Notify the Activity's lifecycle
        mAdView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Notify the Activity's lifecycle
        mAdView.onDestroy();
    }
}
