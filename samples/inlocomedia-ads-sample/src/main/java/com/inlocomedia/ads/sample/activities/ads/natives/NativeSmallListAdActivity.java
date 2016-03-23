package com.inlocomedia.ads.sample.activities.ads.natives;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.android.ads.AdRequest;
import com.inlocomedia.android.ads.nativeads.adapters.NativeAdListAdapter;

import java.util.ArrayList;

/**
 * Created by: gabriel
 * Date: 3/23/16
 * Time: 10:46 AM
 */
public class NativeSmallListAdActivity extends Activity {

    private NativeAdListAdapter mAdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate your layout with your own list
        setContentView(R.layout.list_activity_layout);

        // The selected item list from the previous screen that contains the AdType that will be loaded
        final ListView listView = (ListView) findViewById(android.R.id.list);

        // Populate your list with your values
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 75; i++) {
            list.add("Lorem Ipsum" + i);
        }

        // Create your own adapter to present on the screen
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.small_list_item, android.R.id.text1, list);

        // Create InLocoMedia's adapter to show the ads between your elements, it receive
        mAdAdapter = new NativeAdListAdapter(this, // Context
                                             adapter, // The adapter that will show Ads between the elements
                                             R.layout.ad_small_list_item); // The advertisement layout

        listView.setAdapter(mAdAdapter);

        // Create your adRequest
        AdRequest adRequest = new AdRequest();

        // Set your AdUnit
        adRequest.setAdUnitId(getString(R.string.native_ad_on_list_ad_unit));

        // Load the adapter with the AdUnit properties
        mAdAdapter.loadAds(adRequest);
    }

    @Override
    protected void onDestroy() {
        if (mAdAdapter != null) {
            mAdAdapter.destroy();
        }
        super.onDestroy();
    }
}
