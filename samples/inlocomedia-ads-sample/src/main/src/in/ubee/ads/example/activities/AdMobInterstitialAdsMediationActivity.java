package in.ubee.ads.example.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;

public class AdMobInterstitialAdsMediationActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.interstitial_ad_activity_layout);

        View view = findViewById(R.id.request_interstitial_button);

        view.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                TextView textView = (TextView) findViewById(R.id.description_text);
                textView.setText("Requesting Interstitial...");

                final InterstitialAd iAd = new InterstitialAd(AdMobInterstitialAdsMediationActivity.this);
                iAd.setAdUnitId(getString(R.string.ad_mob_interstitial_ad_unit));
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

                AdRequest adRequest = new AdRequest.Builder().build();
                iAd.loadAd(adRequest);
            }
        });
    }
}
