package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import in.ubee.api.ads.AdError;
import in.ubee.api.ads.AdRequest;
import in.ubee.api.ads.AdType;
import in.ubee.api.ads.feed.AdFeedListViewAdapter;
import in.ubee.api.ads.feed.AdFeedListener;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;

public class AdFeedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_activity_layout);

        final ListView listView = (ListView) findViewById(android.R.id.list);

        final AdFeedListViewAdapter adAdapter = new AdFeedListViewAdapter(this, AdType.NATIVE_OFFER, R.layout.ad_feed_list_item, R.id.advertisement_id);
        adAdapter.setAdFeedListener(new AdFeedListener() {
            @Override
            public void onPageLoaded(int pageIndex, int pageItemsCount) {
                Toast.makeText(AdFeedActivity.this, "Page " + pageIndex + " loaded with " + pageItemsCount + " items.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdError(final AdError error) {
                Toast.makeText(AdFeedActivity.this, "No ad available", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adAdapter);

        listView.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                    adAdapter.loadNextPage();
                }
            }
        });

        adAdapter.loadFeed(new AdRequest());
    }
}
