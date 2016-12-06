package com.smashedcontrollers.sportsontv;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
public class Splash extends AppCompatActivity {
    ImageView imageView;
    MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.cheer);
        mediaPlayer1.start();


        //make sure screen stays at current orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = (ImageView)findViewById(R.id.logoIV);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {//on animation end start new class
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}
