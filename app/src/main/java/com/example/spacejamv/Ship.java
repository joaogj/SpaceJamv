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
	public List<Shot> getShots() {
		return shots;
	}

	public void setShots(List<Shot> shots) {
		this.shots = shots;
	}

	private List<Shot> shots;
	private CurrentScene currentScene;
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

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
		this.img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ship);
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.life = 3;
		this.record = new Record(c);
		currentScene = new CurrentScene(c);
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		for(int i = 0; i < this.life; i++){
			canvas.drawBitmap(imgLife, currentScene.getScreenW()/15.0f * i, currentScene.getScreenH()/15.0f, painter);
		}

		canvas.drawBitmap(img, this.x, this.y, painter);
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).draw(canvas, painter);
		}
		canvas.drawText("Score : ", currentScene.getScreenW()/2.0f, 0, painter);
	}
	
	protected void motionEvent(MotionEvent event)
	{
		int action = event.getAction();

		if(canShot){
            if (action == MotionEvent.ACTION_DOWN) {
                shots.add(new Shot(this.x + this.width, (int) (this.y + this.height / 3f), this.c));
                setCanShot(false);
            }
		}
	}
	
	public void collision()
	{
		if( this.y > currentScene.getScreenH() - (this.height * 1.5f))
		{
			this.y = (int) (currentScene.getScreenH() - (this.height * 1.5f));
		}
		else if( this.y < 0)
		{
			this.y = 0;
		}
	}
	
	public void update(float speed)
	{
		collision();
		
		if(life <= 0){
			this.record.saveRecord(score);
			currentScene.setCanInstantiate(true);
			currentScene.setChangeScene("gameover");
		}
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).Update(currentScene.getScreenH()/100.0f);
		}
		
		
		this.y += speed ;
	}
}
