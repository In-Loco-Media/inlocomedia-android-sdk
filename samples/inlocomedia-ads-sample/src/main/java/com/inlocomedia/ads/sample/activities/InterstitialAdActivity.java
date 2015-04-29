package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.interstitial.InterstitialAd;
import in.ubee.api.ads.interstitial.InterstitialAdListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class InterstitialAdActivity extends BaseActivity {

    private TextView mDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.interstitial_ad_activity_layout);

        mDescriptionText = (TextView) findViewById(R.id.description_text);

        View view = findViewById(R.id.request_interstitial_button);
        view.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                mDescriptionText.setText("Requesting Interstitial...");

                // Initializate the InterstitialAd
                final InterstitialAd interstitialAd = new InterstitialAd(InterstitialAdActivity.this);

                // Register a listener to receive notifications for the InterstitialAd events
                interstitialAd.setInterstitialAdListener(new InterstitialAdListener() {

                    @Override
                    public void onAdReady(final InterstitialAd ad) {

                        /**
                         * InterstitialAd is ready to be shown
                         */

                        mDescriptionText.setText("The InterstitialAd is ready to be shown");

                        // Show the interstitialAd
                        ad.show();
                    }

                    @Override
                    public void onAdError(InterstitialAd ad, AdError adError) {

                        /**
                         * InterstitialAd is presented on the screen
                         */

                        mDescriptionText.setText("AdError: " + adError);
                    }

                    @Override
                    public void onAdOpened(InterstitialAd ad) {

                        /**
                         * InterstitialAd is presented on the screen
                         */

                        mDescriptionText.setText("The InterstitialAd was opened");
                    }

                    @Override
                    public void onAdClosed(InterstitialAd ad) {

                        /**
                         * InterstitialAd is closed
                         */

                        mDescriptionText.setText("The InterstitialAd was closed");
                    }

                    @Override
                    public void onAdLeftApplication(InterstitialAd ad) {

                        /**
                         * The user interacted with the InterstitialAd and is leaving the application
                         */
                    }

                });

                // Loads the InterstitialAd
                interstitialAd.loadAd();
            }
        });
    }

}
