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
	}
	
	public boolean motionEvent(MotionEvent event)
	{	
		this.scene.MotionEvent(event);

		return true;
	}
	
	public void draw(Canvas canvas)
	{
		this.scene.draw(canvas);
	}
	
	public void update()
	{
		this.scene.Update();
	}
	
}
