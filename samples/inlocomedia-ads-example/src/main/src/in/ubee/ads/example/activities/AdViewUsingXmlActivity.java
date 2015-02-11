package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.AdView;
import in.ubee.api.ads.AdViewListener;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdViewUsingXmlActivity extends BaseActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view_using_xml);
        
        AdView adView = (AdView) findViewById(R.id.ad);
        
        adView.setAdListener(new AdViewListener() {
            @Override
            public void onAdViewReady(AdView adView) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setVisibility(View.GONE);
                adView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdError(AdView adView, AdError adError) {
                TextView view = (TextView) findViewById(R.id.description_text);
                view.setText("AdError: " + adError);
                view.setVisibility(View.VISIBLE);

                adView.setVisibility(View.INVISIBLE);
            }
        });

        adView.loadAd();
    }

}
