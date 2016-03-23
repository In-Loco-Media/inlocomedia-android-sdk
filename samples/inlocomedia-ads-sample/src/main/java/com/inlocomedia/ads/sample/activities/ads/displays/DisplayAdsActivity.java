package com.inlocomedia.ads.sample.activities.ads.displays;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.MainActivity;
import com.inlocomedia.ads.sample.views.util.BaseActivity;
import com.inlocomedia.ads.sample.views.util.ListItem;
import com.inlocomedia.android.ads.AdError;
import com.inlocomedia.android.ads.AdRequest;
import com.inlocomedia.android.ads.AdView;
import com.inlocomedia.android.ads.AdViewListener;

@SuppressLint("SetTextI18n")
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
                 * The AdView load has failed. Check the AdErrors to discover the received error
                 */

                // Show the DisplayAdActivity with the AdError
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + adError);
                view.setVisibility(View.VISIBLE);
            }
        });

        // Loads the AdView

        AdRequest adRequest = new AdRequest();
        adRequest.setAdUnitId(getString(R.string.display_ad_unit));

        mAdView.loadAd(adRequest);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                     LayoutParams.WRAP_CONTENT,
                                                     Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);

        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            // Notify the Activity's lifecycle
            mAdView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdView != null) {
            // Notify the Activity's lifecycle
            mAdView.pause(isFinishing());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            // Notify the Activity's lifecycle
            mAdView.destroy();
        }
    }
}
