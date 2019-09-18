package com.example.spacejamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CurrentScene extends View implements Runnable
{

	private Handler handler;
	private Context c;
	private int screenW;
	private int screenH;
	private RunningScene runningScene;
	
	private boolean canInstantiate ;
	public static String changeScene = "menu";

	public void setCanInstantiate(boolean canInstantiate) {
		this.canInstantiate = canInstantiate;
	}

	public boolean isCanInstantiate() {
		return canInstantiate;
	}

	public void setScreenW(int screenW) {
		this.screenW = screenW;
	}

	public int getScreenW() {
		return screenW;
	}

	public int getScreenH() {
		return screenH;
	}

	public void setScreenH(int screenH) {
		this.screenH = screenH;
	}

	public CurrentScene(Context context)
	{
		super(context);

		setScreenW(context.getResources().getDisplayMetrics().widthPixels);
		setScreenH(context.getResources().getDisplayMetrics().heightPixels);
		setCanInstantiate(true);
		setBackgroundColor(Color.WHITE);
		
		c = context;

		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setTextSize(screenW /5.0f);
		
		handler = new Handler();
		handler.post(this);
		
		Log.d("View", "Boom");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{			 
		runningScene.MotionEvent(event);
		return true;
	}
	
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		runningScene.draw(canvas);
	}
	
	private void update()
	{
		//Log.d("WIDTH", String.valueOf(screenW));
		//Log.d("HEIGHT", String.valueOf(screenH));

		if(canInstantiate){
			switch(changeScene){
			
				case "menu":
					runningScene = new RunningScene(new Menu(c));
					//Log.d("switch", "switch " + changeScene);
					canInstantiate = false;
				break;
				case "game":
					runningScene = new RunningScene(new Game(c));
					//Log.d("switch", "switch " + changeScene);
					canInstantiate = false;
				break;
				
				case "gameover":
					runningScene = new RunningScene(new GameOver(c));
					//Log.d("switch", "switch " + changeScene);
					canInstantiate = false;
				break;
			}
		}
		
		runningScene.Update();
	}
	
	public void run()
	{
		//Adiciona o Runnable na fila de mensagens da thread principal para ser executado depois de um tempo espec?fico.
		// Em outras palavras, reexecuta o run.

		int time = 1;
		handler.postDelayed(this, time);

		update();
		postInvalidate();
	}
}
