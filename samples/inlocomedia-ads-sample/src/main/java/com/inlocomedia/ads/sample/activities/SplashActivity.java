package com.inlocomedia.ads.sample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.inlocomedia.ads.sample.R;
import com.inlocomedia.ads.sample.application.InLocoMedia;

public class SplashActivity extends Activity {

    private static final long TIMEOUT = 3000;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_splash);
        View view = findViewById(R.id.splash_screen_click_view_id);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goToMainActivity();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!isFinishing()) {
                    goToMainActivity();
                }
            }
        }, TIMEOUT);
    }

    private void goToMainActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
