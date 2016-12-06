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

    //Global variables
    ImageView imageView1;
    MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Create/link media player with wav file and then start
        mediaPlayer1 = MediaPlayer.create(this,R.raw.cheer);
        //make sure screen stays at current orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Link image view to
        imageView1 = (ImageView)findViewById(R.id.logoIV);
        //Create/load animation and link it to the splash_animation.xml
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation);
        imageView1.setAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            //start mediaplayer and play sound when the animation starts
            @Override
            public void onAnimationStart(Animation animation) {
                mediaPlayer1.start();
            }
            //on animation end start new class/switch activity
            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}
