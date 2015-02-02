package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.ads.example.mediation.AdMob;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

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
                iAd.setAdUnitId(AdMob.INTERSTITIAL_AD_UNIT);
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
                        view.setVisibility(View.VISIBLE);
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
