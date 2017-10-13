package com.inlocomedia.ads.sample.activities.ads.rewarded;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.views.util.BaseActivity;
import com.inlocomedia.android.ads.AdError;
import com.inlocomedia.android.ads.rewarded.Reward;
import com.inlocomedia.android.ads.rewarded.RewardedAd;
import com.inlocomedia.android.ads.rewarded.RewardedAdListener;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class RewardedAdActivity extends BaseActivity {

    private TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.fullscreen_ad_activity_layout);

        descriptionText = (TextView) findViewById(R.id.description_text);

        View view = findViewById(R.id.request_fullscreen_ad_button);
        view.setOnClickListener(new OnClickListener() {

            @SuppressLint("SetTextI18n")
            public void onClick(View view) {

                descriptionText.setText("Requesting Rewarded...");

                // Create the InterstitialAd
                final RewardedAd rewardedAd = new RewardedAd(RewardedAdActivity.this);

                // Register a listener to receive notifications for the RewardedAd events
                rewardedAd.setRewardedAdListener(new RewardedAdListener() {
                    @Override
                    public void onAdReady(final RewardedAd ad) {
                        /**
                         * RewardedAd is ready to be shown
                         */
                        descriptionText.setText("The RewardedAd is ready to be shown");

                        // Show the rewardedAd
                        ad.show();
                    }

                    @Override
                    public void onAdError(RewardedAd ad, AdError adError) {
                        /**
                         * The RewardedAd load has failed. Check the AdErrors to discover the received error
                         */
                        descriptionText.setText("AdError: " + adError);
                    }

                    @Override
                    public void onAdOpened(RewardedAd ad) {
                        /**
                         * RewardedAd is presented on the screen
                         */
                        descriptionText.setText("The RewardedAd was opened");
                    }

                    @Override
                    public void onRewarded(final RewardedAd ad, final Reward reward) {
                        /**
                         * The user has received the reward
                         */
                        Toast.makeText(RewardedAdActivity.this, reward.getAmount() + " " + reward.getItem(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAdClosed(RewardedAd ad) {
                        /**
                         * RewardedAd is closed
                         */
                        descriptionText.setText("The RewardedAd was closed");
                    }

                    @Override
                    public void onAdLeftApplication(RewardedAd ad) {
                        /**
                         * The user interacted with the RewardedAd and is leaving the application
                         */
                    }

                });

                // Loads the RewardedAd
                rewardedAd.loadAd(getString(R.string.rewarded_ad_unit));
            }
        });
    }

}