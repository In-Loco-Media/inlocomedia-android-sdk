package com.inlocomedia.ads.sample.activities.mediation;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;

public class MoPubInterstitialAdsMediationActivity extends BaseActivity {

    private MoPubInterstitial mAd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.interstitial_ad_activity_layout);

        View view = findViewById(R.id.request_interstitial_button);

        view.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                TextView textView = (TextView) findViewById(R.id.description_text);
                textView.setText("Requesting Interstitial...");

                mAd = new MoPubInterstitial(MoPubInterstitialAdsMediationActivity.this, getString(R.string.mopub_interstitial_ad_unit));
                mAd.setInterstitialAdListener(new MoPubInterstitial.InterstitialAdListener() {
                    @Override
                    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
                        TextView textView = (TextView) findViewById(R.id.description_text);
                        textView.setText("The InterstitialAd is ready. Will be shown in half second");

                        textView.postDelayed(new Runnable() {
                            public void run() {
                                mAd.show();
                            }
                        }, 500);
                    }

                    @Override
                    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("AdError: " + moPubErrorCode);
                    }

                    @Override
                    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {

                    }

                    @Override
                    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {

                    }

                    @Override
                    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("The InterstitialAd was closed");
                    }
                });

                mAd.load();
            }
        });
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAd != null) {
            mAd.destroy();
        }
    }
}
