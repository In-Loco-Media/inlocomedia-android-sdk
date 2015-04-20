package com.inlocomedia.ads.sample.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;

public class DFPInterstitialAdsMediationActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.interstitial_ad_activity_layout);

        View view = findViewById(R.id.request_interstitial_button);

        view.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                TextView textView = (TextView) findViewById(R.id.description_text);
                textView.setText("Requesting Interstitial...");

                final PublisherInterstitialAd iAd = new PublisherInterstitialAd(DFPInterstitialAdsMediationActivity.this);
                iAd.setAdUnitId(getString(R.string.dfp_interstitial_ad_unit));
                iAd.setAdListener(new AdListener() {

                    @Override
                    public void onAdLoaded() {
                        TextView textView = (TextView) findViewById(R.id.description_text);
                        textView.setText("The InterstitialAd is ready. Will be shown in half second");

                        textView.postDelayed(new Runnable() {
                            public void run() {
                                iAd.show();
                            }
                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("AdError: " + errorCode);
                    }

                    @Override
                    public void onAdClosed() {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("The InterstitialAd was closed");
                    }
                });

                PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
                iAd.loadAd(adRequest);
            }
        });
    }
}
