package com.example.spacejamv;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.acelerometro.R;

public class Ship extends Actor
{
	public List<Shot> shots;
	
	public Record record;

	public int getScore() {return score;}

	public void setScore(int score) { this.score = score; }

	private int score;

	public boolean isCanShot() {
		return canShot;
	}

	public void setCanShot(boolean canShot) {
		this.canShot = canShot;
	}

	private boolean canShot = true;

	private Bitmap imgLife;

	public Ship(int x, int y, Context c)
	{
		c.getResources();
		shots = new ArrayList<>();
		new BitmapFactory();
		imgLife = BitmapFactory.decodeResource(c.getResources(), R.drawable.life);
		this.x = x;
		this.y = y;
		this.c = c;
		new BitmapFactory();
		this.img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ship);
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.life = 3;
		this.record = new Record(c);
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		for(int i = 0; i < this.life; i++){
			canvas.drawBitmap(imgLife, CurrentScene.screenW/15.0f * i, CurrentScene.screenH/15.0f, painter);
		}

		//canvas.drawRect(new Rect(0 ,0, CurrentScene.screenW/15 * this.life, CurrentScene.screenH/15), painter);
		canvas.drawBitmap(img, this.x, this.y, painter);
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).draw(canvas, painter);
		}
		canvas.drawText("Score : ", CurrentScene.screenW/2.0f, 0, painter);
	}
	
	protected void MotionEvent(MotionEvent event)
	{
		int action = event.getAction();

		if(canShot){
			switch(action)
			{
				case MotionEvent.ACTION_DOWN:
					shots.add(new Shot(this.x + this.width, (int) (this.y + this.height/3f), this.c));
					setCanShot(false);
					break;
			}
		}
	}
	
	public void Collision()
	{
		if( this.y > CurrentScene.screenH - (this.height * 1.5f))
		{
			this.y = (int) (CurrentScene.screenH - (this.height * 1.5f));
		}
		else if( this.y < 0)
		{
			this.y = 0;
		}
	}
	
	public void Update(float speed)
	{
		Collision();
		
		if(life <= 0){
			this.record.SaveRecord(score);
			CurrentScene.canInstantiate = true;
			CurrentScene.changeScene = "gameover";
		}
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).Update(CurrentScene.screenH/100.0f);
		}
		
		
		this.y += speed ;
	}
}
