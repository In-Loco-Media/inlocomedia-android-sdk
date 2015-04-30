package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import com.inlocomedia.ads.sample.activities.util.ListItem;
import in.ubee.api.ads.AdType;
import in.ubee.api.ads.AdvertisementAdapter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NativeAdActivity extends BaseActivity {

    private final String[] listValues = new String[] { "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum",
                                                       "Lorem Ipsum" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_activity_layout);

        // The selected item list from the previous screen that contains the AdType that will be loaded
        final ListView listView = (ListView) findViewById(android.R.id.list);

        ListItem item = (ListItem) getIntent().getSerializableExtra(MainActivity.EXTRA_ITEM);

        if (item.getAdType() == AdType.NATIVE_LARGE) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_large, android.R.id.text1, listValues);
            AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_large_list_item, 6);
            listView.setAdapter(adAdapter);

        } else if (item.getAdType() == AdType.NATIVE_OFFER) {
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.small_list_item, android.R.id.text1, listValues);
            AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_coupon_list_item, 6);
            listView.setAdapter(adAdapter);

        } else if (item.getAdType() == AdType.NATIVE_SMALL) {
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.small_list_item, android.R.id.text1, listValues);
            final AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_small_list_item, 8);
            listView.setAdapter(adAdapter);
        }

    }
}
