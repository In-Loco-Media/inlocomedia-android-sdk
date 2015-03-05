package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.activities.util.BaseActivity;
import in.ubee.ads.example.activities.util.ListItem;
import in.ubee.ads.example.activities.util.ListItem.ItemType;
import in.ubee.ads.example.adapters.MainActivityListAdapter;
import in.ubee.api.Ubee;
import in.ubee.api.ads.AdType;
import in.ubee.api.ads.notification.NotificationAdRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

    public static final String EXTRA_ITEM = "extra_item";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_main);

        List<ListItem> mListItems = new ArrayList<>();

        ListItem[] displayItems = { new ListItem("Display Banner Small", AdType.DISPLAY_BANNER_SMALL, ItemType.DISPLAY),
                new ListItem("Display Banner Small Landscape", AdType.DISPLAY_BANNER_SMALL_LANDSCAPE, ItemType.DISPLAY),
                new ListItem("Display Banner Large", AdType.DISPLAY_BANNER_LARGE, ItemType.DISPLAY),
                new ListItem("Display Banner Full IAB", AdType.DISPLAY_BANNER_FULL_IAB, ItemType.DISPLAY),
                new ListItem("Display Banner Medium Rectangle", AdType.DISPLAY_BANNER_MEDIUM_RECTANGLE, ItemType.DISPLAY),
                new ListItem("Display Banner Tablet", AdType.DISPLAY_BANNER_TABLET, ItemType.DISPLAY),
                new ListItem("Display Banner Tile", AdType.DISPLAY_TILE, ItemType.DISPLAY),
                new ListItem("Display Smart Banner", AdType.SMART_BANNER, ItemType.DISPLAY) };

        ListItem[] interstitialItems = { new ListItem("Interstitial", ItemType.INTERSTITIAL) };

        ListItem[] nativeItems = { new ListItem("Native Small", AdType.NATIVE_SMALL, ItemType.NATIVE),
                new ListItem("Native Large", AdType.NATIVE_LARGE, ItemType.NATIVE), new ListItem("Native Offer", AdType.NATIVE_OFFER, ItemType.NATIVE) };

        ListItem[] notificationItems = { new ListItem("Notification", AdType.NOTIFICATION, ItemType.NOTIFICATION) };

        ListItem[] mediationItems = { new ListItem("AdMob banner", AdType.DISPLAY_BANNER_SMALL, ItemType.ADMOB_MEDIATION),
                new ListItem("AdMob interstitial", ItemType.ADMOB_MEDIATION),
                new ListItem("MoPub banner", AdType.DISPLAY_BANNER_SMALL, ItemType.MOPUB_MEDIATION),
                new ListItem("MoPub interstitial", ItemType.MOPUB_MEDIATION)};

        ListItem[] customUsage = { new ListItem("Feed", ItemType.FEED), new ListItem("AdView using xml", ItemType.AD_VIEW_USING_XML) };

        ListItem displayHeader = new ListItem("Display Ads", ItemType.HEADER);
        ListItem interstitialHeader = new ListItem("Interstitial Ads", ItemType.HEADER);
        ListItem nativeHeader = new ListItem("Native Ads", ItemType.HEADER);
        ListItem notificationHeader = new ListItem("Notification", ItemType.HEADER);
        ListItem mediationHeader = new ListItem("Mediation", ItemType.HEADER);
        ListItem othersHeader = new ListItem("Custom Usage", ItemType.HEADER);

        mListItems.add(displayHeader);
        Collections.addAll(mListItems, displayItems);

        mListItems.add(interstitialHeader);
        Collections.addAll(mListItems, interstitialItems);

        mListItems.add(nativeHeader);
        Collections.addAll(mListItems, nativeItems);

        mListItems.add(notificationHeader);
        Collections.addAll(mListItems, notificationItems);

        mListItems.add(mediationHeader);
        Collections.addAll(mListItems, mediationItems);

        mListItems.add(othersHeader);
        Collections.addAll(mListItems, customUsage);

        MainActivityListAdapter mAdapter = new MainActivityListAdapter(mListItems);
        ListView listView = (ListView) findViewById(android.R.id.list);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ListItem item = (ListItem) adapterView.getItemAtPosition(position);

                if (item.getType() == ItemType.INTERSTITIAL) {
                    Intent intent = new Intent(MainActivity.this, InterstitialAdActivity.class);
                    startActivity(intent);
                } else if (item.getType() == ItemType.DISPLAY) {
                    Intent intent = new Intent(MainActivity.this, DisplayAdsActivity.class);
                    intent.putExtra(EXTRA_ITEM, item);
                    startActivity(intent);
                } else if (item.getType() == ItemType.NATIVE ) {
                    Intent intent = new Intent(MainActivity.this, NativeAdActivity.class);
                    intent.putExtra(EXTRA_ITEM, item);
                    startActivity(intent);
                } else if (item.getType() == ItemType.FEED) {
                    Intent intent = new Intent(MainActivity.this, AdFeedActivity.class);
                    startActivity(intent);
                } else if (item.getType() == ItemType.ADMOB_MEDIATION) {

                    if (item.getAdType() != null && item.getAdType().isDisplay()) {
                        Intent intent = new Intent(MainActivity.this, AdMobDisplayAdsMediationActivity.class);
                        intent.putExtra(EXTRA_ITEM, item);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, AdMobInterstitialAdsMediationActivity.class);
                        intent.putExtra(EXTRA_ITEM, item);
                        startActivity(intent);
                    }
                } else if (item.getType() == ItemType.MOPUB_MEDIATION) {

                    if (item.getAdType() != null && item.getAdType().isDisplay()) {
                        Intent intent = new Intent(MainActivity.this, MoPubDisplayAdsMediationActivity.class);
                        intent.putExtra(EXTRA_ITEM, item);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, MoPubInterstitialAdsMediationActivity.class);
                        intent.putExtra(EXTRA_ITEM, item);
                        startActivity(intent);
                    }
                } else if (item.getType() == ItemType.AD_VIEW_USING_XML) {
                    Intent intent = new Intent(MainActivity.this, AdViewUsingXmlActivity.class);
                    startActivity(intent);
                }
            }
        });

        mAdapter.setNotificationClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!Ubee.isNotificationAdEnabled(MainActivity.this)) {
                    NotificationAdRequest request = new NotificationAdRequest();
                    request.setNotificationIconResourceId(R.drawable.ic_launcher);
                    Ubee.setNotificationAdRequest(MainActivity.this, request);
                }
                Ubee.setNotificationAdEnabled(MainActivity.this, !Ubee.isNotificationAdEnabled(MainActivity.this));
            }
        });

        listView.setAdapter(mAdapter);
    }
}
