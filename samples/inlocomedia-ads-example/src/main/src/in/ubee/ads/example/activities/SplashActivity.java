package in.ubee.ads.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Timer;
import java.util.TimerTask;

import in.ubee.ads.example.R;
import in.ubee.ads.example.application.InLocoMedia;

public class SplashActivity extends Activity {

    private static final long TIMEOUT = 3000;

    private Timer timer;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InLocoMedia.setup(this);

        this.setContentView(R.layout.activity_splash);

        View view = findViewById(R.id.splash_screen_click_view_id);

        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                timer.cancel();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
                finish();
            }
        };
        this.timer = new Timer();
        this.timer.schedule(task, TIMEOUT);
    }

}
