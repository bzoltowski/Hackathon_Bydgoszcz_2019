package activities;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hackaton2019.R;

public class SplashActivity extends AppCompatActivity {

    private static int TIME_OUT = 4000;
    ImageView logo;
    Animation logoSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoSplash = AnimationUtils.loadAnimation(this, R.anim.splashlogo);
        logo = (ImageView) findViewById(R.id.logo);
        logo.startAnimation(logoSplash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, SignInActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
