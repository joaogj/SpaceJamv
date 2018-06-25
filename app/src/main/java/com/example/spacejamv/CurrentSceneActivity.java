package com.example.spacejamv;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;

public class CurrentSceneActivity extends Activity implements SensorEventListener {
     
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    protected PowerManager.WakeLock mWakeLock;
    
    
    public static float x,y,z;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(new CurrentScene(this));
         
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        boolean alarmeAtivo = (PendingIntent.getBroadcast(this, 0, new Intent("ALARME_DISPARADO"), PendingIntent.FLAG_NO_CREATE) == null);
		
		if(alarmeAtivo)
		{
			Log.i("Script", "Novo alarme");
			
			Intent intent = new Intent("ALARME_DISPARADO");
			PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);
			
			Calendar c = Calendar.getInstance();
			//c.setTimeInMillis(System.currentTimeMillis());
			c.set(Calendar.HOUR, 23);
			c.set(Calendar.MINUTE, 54);
			c.set(Calendar.SECOND, 00);
			
			AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
			alarme.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), AlarmManager.INTERVAL_DAY, p);
		}
		else
		{
			Log.i("Script", "Alarme j� ativo");
		}
         
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
		 x = event.values[0];
	     y = event.values[1];
	     z = event.values[2];
	}
	
	@Override
    public void onDestroy() 
	{
        this.mWakeLock.release();
        super.onDestroy();
        
        /*Intent intent = new Intent("ALARME_DISPARADO");
		PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);
		
		AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarme.cancel(p);*/
    }
}
