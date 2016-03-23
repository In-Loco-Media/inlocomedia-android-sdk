package com.inlocomedia.ads.sample.activities.ads.displays;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.views.util.BaseActivity;
import com.inlocomedia.android.ads.AdError;
import com.inlocomedia.android.ads.AdRequest;
import com.inlocomedia.android.ads.AdView;
import com.inlocomedia.android.ads.AdViewListener;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

@SuppressLint("SetTextI18n")
public class DisplayAdViewUsingXmlActivity extends BaseActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Inflates the Layout that contains a AdView
          The XML contains the AdType and the LoadOnAttach attributes.
          It will automatically loads the AdView as soon as it is attached on the screen
          */
        setContentView(R.layout.activity_ad_view_using_xml);

        mAdView = (AdView) findViewById(R.id.ad);

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

        AdRequest adRequest = new AdRequest();
        adRequest.setAdUnitId(getString(R.string.display_ad_unit));

        mAdView.loadAd(adRequest);
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
