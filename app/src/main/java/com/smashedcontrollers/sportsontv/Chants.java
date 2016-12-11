package com.smashedcontrollers.sportsontv;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Chants extends Activity implements SensorEventListener {
    //SensorManager lets you access the device's sensors
    //declare Variables
    private SensorManager sensorManager;
    private boolean color = false;
    private long lastUpdate;
    RelativeLayout rL_Accelerometer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Hide Navigation and make this full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chants);
        //Entrance message
        Toast.makeText(this, "Shake to Celebrate", Toast.LENGTH_SHORT).show();
        //Create instance of Layout
        rL_Accelerometer= (RelativeLayout)findViewById(R.id.rL_Accelerometer);
        //change background color 1st
        rL_Accelerometer.setBackgroundColor(Color.GREEN);
        //create instance of sensor manager and get system service to interact with Sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }
    // called when sensor value have changed
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];
        //get acceleration
        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        //get current time
        long actualTime = System.currentTimeMillis();
        if (accelationSquareRoot >= 2)
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;

            if (color) {
                rL_Accelerometer.setBackgroundColor(Color.RED);

            } else {
                rL_Accelerometer.setBackgroundColor(Color.BLUE);
            }
            color = !color;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}