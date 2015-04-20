package com.inlocomedia.ads.sample.adapters;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.ListItem;
import com.inlocomedia.ads.sample.activities.util.ListItem.ItemType;
import in.ubee.api.Ubee;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivityListAdapter extends BaseAdapter {

    private List<ListItem> mItems;

    private OnClickListener mNotificationClickListener;

    public enum RowType {
        NOTIFIFICATION_ITEM, LIST_ITEM, HEADER_ITEM;
    }

    public MainActivityListAdapter(final List<ListItem> listItems) {
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
        if (mItems.get(position).getType() == ItemType.HEADER) {
            return RowType.HEADER_ITEM.ordinal();
        } else if (mItems.get(position).getType() == ItemType.NOTIFICATION) {
            return RowType.NOTIFIFICATION_ITEM.ordinal();
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
            if (mItems.get(position).getType() == ItemType.HEADER) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_list_header, parent, false);
            } else if (mItems.get(position).getType() == ItemType.NOTIFICATION) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_list_notification, parent, false);
            } else {
                convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }
        }

        if (mItems.get(position).getType() == ItemType.NOTIFICATION) {
            ToggleButton notificationToggleButton = ((ToggleButton) convertView.findViewById(R.id.notification_switch));
            notificationToggleButton.setChecked(Ubee.isNotificationAdEnabled(convertView.getContext()));
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
