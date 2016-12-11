package com.smashedcontrollers.sportsontv;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Chants extends Activity implements SensorEventListener {
    //SensorManager lets you access the device's sensors
    //declare global Variables
    private SensorManager NewSensorManager;
    RelativeLayout shaker;
    private boolean colour = false;
    private long finalUpdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chants);
        //Entrance message
        Toast.makeText(this, "Shake to Celebrate", Toast.LENGTH_SHORT).show();
        //Create instance of Layout
        shaker = (RelativeLayout)findViewById(R.id.rL_Accelerometer);
        //Set the colour of the background on the first entrance
        shaker.setBackgroundColor(Color.GREEN);
        //create sensor manager and get system service to interact with Sensor
        NewSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        finalUpdate = System.currentTimeMillis();
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
        // Store Movement
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
                shaker.setBackgroundColor(Color.RED);
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