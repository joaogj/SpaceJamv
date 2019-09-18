package com.example.spacejamv;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class CurrentSceneActivity extends Activity implements SensorEventListener {
     
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    
    private float x;
    private float y;
    private float z;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(new CurrentScene(this));

        //definição do sensor de acelerômetro
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
       
    @Override
    protected void onResume() 
    {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
     
    @Override
    protected void onPause() 
    {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) 
	{

	}

	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		 y = event.values[0];
	     x = event.values[1];
	     z = event.values[2];
	}
	
	@Override
    public void onDestroy() 
	{
        super.onDestroy();

    }
}
