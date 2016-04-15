package com.inlocomedia.ads.sample.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.MainActivity;
import com.inlocomedia.ads.sample.activities.ads.displays.DisplayAdViewUsingXmlActivity;
import com.inlocomedia.ads.sample.activities.ads.displays.DisplayAdsActivity;
import com.inlocomedia.ads.sample.activities.ads.interstitials.InterstitialAdActivity;
import com.inlocomedia.ads.sample.activities.ads.natives.NativeAdActivity;
import com.inlocomedia.ads.sample.activities.ads.natives.NativeLargeListAdActivity;
import com.inlocomedia.ads.sample.activities.ads.natives.NativeSmallListAdActivity;
import com.inlocomedia.ads.sample.activities.ads.notifications.NotificationActivity;
import com.inlocomedia.ads.sample.views.util.ListItem;
import com.inlocomedia.android.InLocoMedia;
import com.inlocomedia.android.ads.AdType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by: gabriel
 * Date: 4/28/15
 * Time: 5:02 PM
 */
public class MainActivityListView extends ListView {

    private MainActivityListAdapter mAdapter;

    private ListItem[] displayItems = {new ListItem("Display Banner Small", AdType.DISPLAY_BANNER_SMALL, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Small Landscape",
                                                    AdType.DISPLAY_BANNER_SMALL_LANDSCAPE,
                                                    ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Large", AdType.DISPLAY_BANNER_LARGE, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Full IAB", AdType.DISPLAY_BANNER_FULL_IAB, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Medium Rectangle",
                                                    AdType.DISPLAY_BANNER_MEDIUM_RECTANGLE,
                                                    ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Tablet", AdType.DISPLAY_BANNER_TABLET, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Tile", AdType.DISPLAY_TILE, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Smart Banner", AdType.SMART_BANNER, ListItem.ItemType.DISPLAY),
                                       new ListItem("Display Banner Large using Xml", ListItem.ItemType.DISPLAY_USING_XML)};

    private ListItem[] interstitialItems = {new ListItem("Interstitial", ListItem.ItemType.INTERSTITIAL)};

    private ListItem[] nativeItems = {new ListItem("Native Small", AdType.NATIVE_SMALL, ListItem.ItemType.NATIVE),
                                      new ListItem("Native Large", AdType.NATIVE_LARGE, ListItem.ItemType.NATIVE),
                                      new ListItem("Native Small - List", AdType.NATIVE_SMALL, ListItem.ItemType.NATIVE_LIST),
                                      new ListItem("Native Large - List", AdType.NATIVE_LARGE, ListItem.ItemType.NATIVE_LIST)};

    private ListItem[] notificationItems = {new ListItem("Notification", AdType.NOTIFICATION, ListItem.ItemType.NOTIFICATION)};

    private ListItem displayHeader = new ListItem("Display Ads", ListItem.ItemType.HEADER);
    private ListItem interstitialHeader = new ListItem("Interstitial Ads", ListItem.ItemType.HEADER);
    private ListItem nativeHeader = new ListItem("Native Ads", ListItem.ItemType.HEADER);
    private ListItem notificationHeader = new ListItem("Notification", ListItem.ItemType.HEADER);

    private List<ListItem> mListItems = new ArrayList<>();

    public MainActivityListView(Context context) {
        super(context);
        init();
    }

    public MainActivityListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MainActivityListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MainActivityListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        mListItems.add(notificationHeader);
        Collections.addAll(mListItems, notificationItems);

        mListItems.add(displayHeader);
        Collections.addAll(mListItems, displayItems);

        mListItems.add(interstitialHeader);
        Collections.addAll(mListItems, interstitialItems);

        mListItems.add(nativeHeader);
        Collections.addAll(mListItems, nativeItems);

        this.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ListItem item = (ListItem) adapterView.getItemAtPosition(position);

                if (item.getType() == ListItem.ItemType.NOTIFICATION) {
                    startActivity(NotificationActivity.class);

                } else if (item.getType() == ListItem.ItemType.INTERSTITIAL) {
                    startActivity(InterstitialAdActivity.class);

                } else if (item.getType() == ListItem.ItemType.DISPLAY) {
                    startActivityWithItem(DisplayAdsActivity.class, item);

                } else if (item.getType() == ListItem.ItemType.DISPLAY_USING_XML) {
                    startActivity(DisplayAdViewUsingXmlActivity.class);

                } else if (item.getType() == ListItem.ItemType.NATIVE_LIST && item.getAdType() == AdType.NATIVE_SMALL) {
                    startActivityWithItem(NativeSmallListAdActivity.class, item);

                } else if (item.getType() == ListItem.ItemType.NATIVE_LIST && item.getAdType() == AdType.NATIVE_LARGE) {
                    startActivityWithItem(NativeLargeListAdActivity.class, item);

                } else if (item.getType() == ListItem.ItemType.NATIVE) {
                    startActivityWithItem(NativeAdActivity.class, item);
                }
            }
        });

        mAdapter = new MainActivityListAdapter(mListItems);
        setAdapter(mAdapter);
    }

    public void setNotificationClickListener(final OnClickListener clickListener) {
        mAdapter.setNotificationClickListener(clickListener);
    }

    private void startActivity(final Class<? extends Activity> activityClass) {
        Intent intent = new Intent(this.getContext(), activityClass);
        getContext().startActivity(intent);
    }

    private void startActivityWithItem(final Class<? extends Activity> activityClass, final ListItem listItem) {
        Intent intent = new Intent(this.getContext(), activityClass);
        intent.putExtra(MainActivity.EXTRA_ITEM, listItem);
        getContext().startActivity(intent);
    }

    static class MainActivityListAdapter extends BaseAdapter {

        private List<ListItem> mItems;

        private OnClickListener mNotificationClickListener;

        public enum RowType {
            NOTIFICATION, LIST_ITEM, HEADER_ITEM
        }

        private MainActivityListAdapter(final List<ListItem> listItems) {
            mItems = listItems;
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public int getItemViewType(int position) {
            if (mItems.get(position).getType() == ListItem.ItemType.HEADER) {
                return RowType.HEADER_ITEM.ordinal();
            } else if (mItems.get(position).getType() == ListItem.ItemType.NOTIFICATION) {
                return RowType.NOTIFICATION.ordinal();
            } else {
                return RowType.LIST_ITEM.ordinal();
            }
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                if (mItems.get(position).getType() == ListItem.ItemType.HEADER) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_list_header, parent, false);
                } else if (mItems.get(position).getType() == ListItem.ItemType.NOTIFICATION) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_list_notification, parent, false);
                } else {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                }
            }

            if (mItems.get(position).getType() == ListItem.ItemType.NOTIFICATION) {
                ToggleButton notificationToggleButton = ((ToggleButton) convertView.findViewById(R.id.notification_switch));
                notificationToggleButton.setChecked(InLocoMedia.isNotificationAdEnabled(convertView.getContext()));
                notificationToggleButton.setOnClickListener(mNotificationClickListener);
            }

            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            textView.setText(getItem(position).toString());

            return convertView;
        }

        public void setNotificationClickListener(OnClickListener onClickListener) {
            mNotificationClickListener = onClickListener;
        }
    }
}
