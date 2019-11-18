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

	private List<Shot> shots;
	private CurrentScene currentScene;
	private Record record;

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

	public Ship()
	{
		shots = new ArrayList<>();
		imgLife = BitmapFactory.decodeResource(c.getResources(), R.drawable.life);
		this.x = 0;
		this.y = currentScene.getScreenH() / 2;
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
		//faz a varredura da quantidade de vidas que serão desenhadas na cena
		for(int i = 0; i < this.life; i++){
			canvas.drawBitmap(imgLife, currentScene.getScreenW()/15.0f * i, currentScene.getScreenH()/15.0f, painter);
		}

		canvas.drawBitmap(img, this.x, this.y, painter);

		//faz a varredura da quantidade de tiros que serão desenhados na cena
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).draw(canvas, painter);
		}
		canvas.drawText("Score : ", currentScene.getScreenW()/2.0f, 0, painter);
	}

	//verifica o touch e se o tiro está no cooldown, para poder instanciar um novo
	protected void motionEvent(MotionEvent event)
	{
		int action = event.getAction();
		ShotType type = ShotFactory.getShotType("ally",c);
		if(canShot && action == MotionEvent.ACTION_DOWN) {
			shots.add(new Shot(this.x + this.width, (int) (this.y + this.height / 3f), type));
			setCanShot(false);
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
	
	public void update()
	{
		float speed = 1;
		collision();

		//verifica quando a vida chega a 0, para fazer a transição de cena para Game Over
		if(life <= 0){
			this.record.saveRecord(score);
			currentScene.setCanInstantiate(true);
			currentScene.setChangeScene("gameover");
		}
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).update(currentScene.getScreenH()/100.0f);
		}
		
		
		this.y += speed ;
	}
}
