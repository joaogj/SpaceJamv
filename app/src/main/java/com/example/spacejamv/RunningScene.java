package com.example.spacejamv;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

public class RunningScene
{		
	private Scene scene;
	
	public RunningScene(Scene scene)
	{		
		this.scene = scene;
		//Log.d("change scene", "running scene  " + CurrentScene.changeScene );

	}
	
	public boolean MotionEvent(MotionEvent event)
	{	
		this.scene.MotionEvent(event);
		
		//Log.d("change scene", "motion event do " + CurrentScene.changeScene );

		return true;
	}
	
	public void draw(Canvas canvas)
	{
		
		this.scene.draw(canvas);
		//Log.d("change scene", "draw do " + CurrentScene.changeScene );
	}
	
	public void Update()
	{
		this.scene.Update();
		//Log.d("change scene", "update " + CurrentScene.changeScene );
	}
	
}
