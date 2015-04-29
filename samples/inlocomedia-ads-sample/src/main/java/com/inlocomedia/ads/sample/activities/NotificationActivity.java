package com.inlocomedia.ads.sample.activities;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.activities.util.BaseActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);

        // Gets the url that was set on the NotificationAd creation
		Uri uri = getIntent().getData();

        // Gets the query parameter title that was set on inside the url the NotificationAd creation
        String title = uri.getQueryParameter("title");

        // Gets the query parameter description that was set on inside the url the NotificationAd creation
        String description = uri.getQueryParameter("description");

		((TextView) findViewById(R.id.tv_title)).setText(title);
		((TextView) findViewById(R.id.tv_description)).setText(description);
	}
}
