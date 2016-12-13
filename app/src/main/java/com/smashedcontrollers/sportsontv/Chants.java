package com.smashedcontrollers.sportsontv;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.animation;
import static android.R.attr.start;
import static com.smashedcontrollers.sportsontv.R.id.tVChangeBG;

public class Chants extends Activity implements SensorEventListener {
    //SensorManager lets you access the device's sensors
    //declare global Variables
    RelativeLayout shaker;
    private SensorManager NewSensorManager;
    private boolean colour = false;
    private long finalUpdate;
    TextView newTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chants);
        //Entrance message
        Toast newToast = Toast.makeText(Chants.this ,"Shake to Celebrate", Toast.LENGTH_SHORT);
        newToast.show();
        //Create instance of Layout
        shaker = (RelativeLayout)findViewById(R.id.rL_Accelerometer);
        //Set the colour of the background on the first entrance
        shaker.setBackgroundColor(Color.RED);
        //create sensor manager and get system service to interact with Sensor
        NewSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        finalUpdate = System.currentTimeMillis();
        //linked textview
        newTextView = (TextView)findViewById(R.id.tVChangeBG);
        //Linked animation file
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation);
        newTextView.setAnimation(animation);
        //set animation length
        animation.setRepeatCount(Animation.INFINITE);
        //set listener
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    // method runs when the sensor parameter has changed
    @Override
    public void onSensorChanged(SensorEvent newSensorEvent) {
        if (newSensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(newSensorEvent);
        }
    }
    private void getAccelerometer(SensorEvent newSensorEvent) {
        float[] newValuesArray = newSensorEvent.values;
        // Capture Movement
        float x = newValuesArray[0];
        float y = newValuesArray[1];
        float z = newValuesArray[2];
        //To work out get acceleration
        float asr = (x * x + y * y + z * z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        //get current time
        long actualTime = System.currentTimeMillis();
        if (asr >= 2)
        {
            if (actualTime - finalUpdate < 200) {
                return;
            }
            finalUpdate = actualTime;
            if (colour) {
                shaker.setBackgroundColor(Color.YELLOW);
            } else {
                shaker.setBackgroundColor(Color.BLUE);
            }
            colour = !colour;
        }
    }
    //we don't need this
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    //Set to listen for orientation
    @Override
    protected void onResume() {
        super.onResume();
        NewSensorManager.registerListener(this, NewSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }
    //Stop listening
    @Override
    protected void onPause() {
        super.onPause();
        NewSensorManager.unregisterListener(this);
    }
}
