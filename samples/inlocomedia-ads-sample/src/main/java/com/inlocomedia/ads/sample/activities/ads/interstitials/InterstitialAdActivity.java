package com.inlocomedia.ads.sample.activities.ads.interstitials;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.views.util.BaseActivity;
import com.inlocomedia.android.ads.AdError;
import com.inlocomedia.android.ads.AdRequest;
import com.inlocomedia.android.ads.interstitial.InterstitialAd;
import com.inlocomedia.android.ads.interstitial.InterstitialAdListener;

import android.annotation.SuppressLint;
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

            @SuppressLint("SetTextI18n")
            public void onClick(View view) {

                mDescriptionText.setText("Requesting Interstitial...");

                // Create the InterstitialAd
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
                         * The InterstitialAd load has failed. Check the AdErrors to discover the received error
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

                AdRequest adRequest = new AdRequest();
                adRequest.setAdUnitId(getString(R.string.interstitial_ad_unit));

                // Loads the InterstitialAd
                interstitialAd.loadAd(adRequest);
            }
        });
    }

}
