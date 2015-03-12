package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.ads.example.activities.util.ListItem;
import in.ubee.api.ads.AdType;
import in.ubee.api.ads.AdvertisementAdapter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NativeAdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_activity_layout);

        final ListView listView = (ListView) findViewById(android.R.id.list);

        ListItem item = (ListItem) getIntent().getSerializableExtra(MainActivity.EXTRA_ITEM);

        String[] values = new String[] { "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum",
                "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum" };

        if (item.getAdType() == AdType.NATIVE_LARGE) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_large, android.R.id.text1, values);
            AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_large_list_item, 6);
            listView.setAdapter(adAdapter);

        } else if (item.getAdType() == AdType.NATIVE_OFFER) {
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.small_list_item, android.R.id.text1, values);
            AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_coupon_list_item, 6);
            listView.setAdapter(adAdapter);

        } else if (item.getAdType() == AdType.NATIVE_SMALL) {
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.small_list_item, android.R.id.text1, values);
            final AdvertisementAdapter adAdapter = new AdvertisementAdapter(this, adapter, R.layout.ad_small_list_item, 8);
            listView.setAdapter(adAdapter);
        }

    }
}
