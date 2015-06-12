package com.inlocomedia.ads.sample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.views.MainActivityListView;

import in.ubee.api.Ubee;
import in.ubee.api.UbeeOptions;
import in.ubee.api.ads.notification.NotificationAdRequest;

public class MainActivity extends Activity {

    public static final String EXTRA_ITEM = "extra_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializing InLocoMedia Options. Put it on your first activity
        UbeeOptions options = UbeeOptions.getInstance(this);

        // The deviceId can be obtained by viewing the logcat output after creating a new ad:
        options.setDevelopmentDevices();

        // Enabling verbose mode
        options.setLogEnabled(getResources().getBoolean(R.bool.inlocomedia_ads_sample_logs_enabled));

        /*
         * App key - App User Id from ubee - find in http://inlocomedia.com/
         * App Secret - App Secret from ubee - find in http://inlocomedia.com/
         */
        options.setAdsKey(getString(R.string.inlocomedia_ads_sample_key),
                          getString(R.string.inlocomedia_ads_sample_secret));

        // Initializating the InLocoMedia SDK. Put this on your first activity
        Ubee.init(this, options);

        // Sets the layout that contains the access to each Ad usage available for the SDK
        setContentView(R.layout.activity_new_main);
        MainActivityListView listView = (MainActivityListView) findViewById(android.R.id.list);

        // Toggle event to enable and disable notification ads
        listView.setNotificationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Ubee.isNotificationAdEnabled(MainActivity.this)) {

                    NotificationAdRequest request = new NotificationAdRequest();

                    // Sets the notification ad resource icon
                    request.setNotificationIconResourceId(R.drawable.ic_launcher);

                    // Enable sounds on the notification
                    request.setSoundEnabled(true);

                    // Enables vibration when the notification is received
                    request.setVibrationEnabled(true);

                    // Set the requests with the notification parameters
                    Ubee.setNotificationAdRequest(MainActivity.this, request);
                }
                Ubee.setNotificationAdEnabled(MainActivity.this, !Ubee.isNotificationAdEnabled(MainActivity.this));
            }
        });
    }
}


