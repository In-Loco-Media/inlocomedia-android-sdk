package in.ubee.ads.example.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;

import java.util.Date;
import java.util.GregorianCalendar;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;

public class AdMobDisplayAdsMediationActivity extends BaseActivity {

    private com.google.android.gms.ads.AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_display_ad);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ad_container);

        mAdView = new com.google.android.gms.ads.AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(getString(R.string.ad_mob_banner_ad_unit));

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
                mAdView.setVisibility(View.VISIBLE);
            }

            public void onAdFailedToLoad(int errorCode) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + errorCode);
                view.setVisibility(View.VISIBLE);

                mAdView.setVisibility(View.INVISIBLE);
            }

            ;
        });

        mAdView.setVisibility(View.INVISIBLE);

        Date birthday = new GregorianCalendar(1985, 1, 1).getTime();
        int gender = AdRequest.GENDER_FEMALE | AdRequest.GENDER_MALE;
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(gender)
                .setBirthday(birthday)
                .build();


        mAdView.loadAd(adRequest);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdView.pause();
    }
}
