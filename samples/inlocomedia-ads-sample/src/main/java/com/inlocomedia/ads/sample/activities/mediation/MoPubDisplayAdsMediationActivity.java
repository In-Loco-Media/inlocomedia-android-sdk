package com.inlocomedia.ads.sample.activities.mediation;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;

public class MoPubDisplayAdsMediationActivity extends BaseActivity {

    private MoPubView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_display_ad);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ad_container);

        mAdView = new MoPubView(this);
        mAdView.setAdUnitId(getString(R.string.mopub_banner_ad_unit));

        mAdView.setBannerAdListener(new MoPubView.BannerAdListener() {
            @Override
            public void onBannerLoaded(MoPubView moPubView) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + moPubErrorCode.toString());
                view.setVisibility(View.VISIBLE);

                mAdView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onBannerClicked(MoPubView moPubView) {

            }

            @Override
            public void onBannerExpanded(MoPubView moPubView) {

            }

            @Override
            public void onBannerCollapsed(MoPubView moPubView) {

            }
        });

        mAdView.setVisibility(View.INVISIBLE);
        mAdView.loadAd();

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        frameLayout.addView(mAdView, layoutParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }
}
