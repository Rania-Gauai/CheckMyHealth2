package com.lordroid.checkmyhealth;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashIcon = (ImageView) findViewById(R.id.image_view);
        /*Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        animation.setDuration(3000);
       splashIcon.startAnimation(animation);*/
        Animation animation_rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        splashIcon.startAnimation(animation_rotate);
        animation_rotate.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.reset();
                    mPlayer.release();
                   Intent intent = new Intent (SplashScreenActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }


            }

            public void onAnimationStart(Animation animation) {
                mPlayer = MediaPlayer.create(SplashScreenActivity.this, R.raw.welcome);
                mPlayer.start();
                setVolumeControlStream(AudioManager.STREAM_MUSIC);
            }

            public void onAnimationRepeat(Animation a) {
            }

        });

    }

}
