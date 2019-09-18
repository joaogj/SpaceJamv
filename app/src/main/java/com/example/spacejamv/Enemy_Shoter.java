package com.example.spacejamv;

import java.util.ArrayList;
import java.util.List;

import com.example.acelerometro.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Enemy_Shoter extends Enemy
{
	private List<Shot> shots;
	private CurrentScene currentScene = new CurrentScene(c);

	public Enemy_Shoter(int x, int y, Context c)
	{		
		shots = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.c = c;
		this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.enemy1);
		this.height = img.getHeight();
		this.width = img.getWidth();
	}
	
	private List<Shot> getShots (){
		return shots;
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		canvas.drawBitmap(img, this.x, this.y, painter);
		
		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).draw(canvas, painter);
		}
	}
	
	@Override
	public void Update(Ship ship){
				
		if(this.y > ship.y){
			this.y -= currentScene.getScreenH()/400;
		}
		else if(this.y < ship.y){
			this.y += currentScene.getScreenH()/400;
		}
		if(this.y + (this.height * 2) > ship.y && this.y < ship.y + (ship.height * 2) && shots.isEmpty()){
			shots.add(new Shot(this.x - this.width, (int) (this.y - this.height / 3f), this.c));
		}

		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).Update(- currentScene.getScreenH()/80.0f);
			
			if(ship.Collision4(ship, shots.get(i))){
				shots.remove(i);
				ship.life--;
				break;
			}
			
			if(ship.Collision5(shots.get(i))){
				shots.remove(i);
				break;
			}
		}
	}
}
