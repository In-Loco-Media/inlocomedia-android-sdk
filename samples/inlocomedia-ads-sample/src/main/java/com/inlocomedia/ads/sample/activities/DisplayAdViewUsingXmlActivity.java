package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.AdView;
import in.ubee.api.ads.AdViewListener;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
                 * The AdView load has failed. Check the AdErrors to discover the reason
                 */

                // Show the DisplayAdActivity with the AdError
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + adError);
                view.setVisibility(View.VISIBLE);
            }
        });
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
