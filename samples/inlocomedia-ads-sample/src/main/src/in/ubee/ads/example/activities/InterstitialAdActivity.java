package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.interstitial.InterstitialAd;
import in.ubee.api.ads.interstitial.InterstitialAdListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class InterstitialAdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.interstitial_ad_activity_layout);

        View view = findViewById(R.id.request_interstitial_button);

        view.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                TextView textView = (TextView) findViewById(R.id.description_text);
                textView.setText("Requesting Interstitial...");

                final InterstitialAd interstitialAd = new InterstitialAd(InterstitialAdActivity.this);

                textView.postDelayed(new Runnable() {
                    public void run() {
                        interstitialAd.show();
                    }
                }, 500);

                interstitialAd.setInterstitialAdListener(new InterstitialAdListener() {

                    @Override
                    public void onAdReady(final InterstitialAd ad) {

                        TextView textView = (TextView) findViewById(R.id.description_text);
                        textView.setText("The InterstitialAd is ready. Will be shown in half second");

                        textView.postDelayed(new Runnable() {
                            public void run() {
                                ad.show();
                            }
                        }, 500);
                    }

                    @Override
                    public void onAdOpened(InterstitialAd ad) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("The InterstitialAd was opened");
                    }

                    @Override
                    public void onAdError(InterstitialAd ad, AdError adError) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("AdError: " + adError);
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAdClosed(InterstitialAd ad) {
                        TextView view = (TextView) findViewById(R.id.description_text);
                        view.setText("The InterstitialAd was closed");
                    }

                    @Override
                    public void onAdLeftApplication(InterstitialAd ad) {}

                });
                interstitialAd.loadAd();
            }
        });
    }

}
