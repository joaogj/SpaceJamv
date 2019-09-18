package com.example.spacejamv;

import com.example.acelerometro.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class EnemyFollower extends Enemy
{
	private CurrentScene currentScene = new CurrentScene(c);

	public EnemyFollower(int x, int y, Context c)
	{		
		this.x = x;
		this.y = y;
		this.c = c;
		this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.enemy0);
		this.height = img.getHeight();
		this.width = img.getWidth();
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		canvas.drawBitmap(img, this.x, this.y, painter);
	}

	@Override
	public void Update(Ship ship){
		
		//movement
		this.x -= currentScene.getScreenW()/1150 * (ship.getScore()/10 + 1);
		
		if(this.y > ship.y){
			this.y -= currentScene.getScreenH()/400;
		}
		else if(this.y < ship.y){
			this.y += currentScene.getScreenH()/400;
		}
	}
}
