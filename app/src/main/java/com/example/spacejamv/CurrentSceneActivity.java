package com.example.spacejamv;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.acelerometro.R;

public class CurrentSceneActivity extends Activity implements SensorEventListener {
     
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private MediaPlayer mediaPlayer;

    
    public static float x,y,z;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(new CurrentScene(this));
         
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mediaPlayer = MediaPlayer.create(CurrentSceneActivity.this, R.raw.newmoon);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		// TODO Auto-generated method stub
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
