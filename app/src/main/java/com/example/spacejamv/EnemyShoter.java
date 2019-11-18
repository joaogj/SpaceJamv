package com.example.spacejamv;

import java.util.ArrayList;
import java.util.List;

import com.example.acelerometro.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class EnemyShoter extends Enemy
{
	private List<Shot> shots;
	private CurrentScene currentScene = new CurrentScene(c);

	public EnemyShoter(int x, int y, Context c)
	{		
		shots = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.c = c;
		this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.enemy1);
		this.height = img.getHeight();
		this.width = img.getWidth();
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
	
	public void update(Ship ship){

		EnemyContext enemyContext = new EnemyContext();

		if(this.y != ship.y){
			enemyContext.setEnemyStrategy(new EnemyStrategyFollow());
		}

		if(this.y + (this.height * 2) > ship.y && this.y < ship.y + (ship.height * 2) && shots.isEmpty()){
			enemyContext.setEnemyStrategy(new EnemyStrategyShoot());
		}

		enemyContext.executeEnemyStrategy(this, ship);

		for(int i = 0; i < shots.size(); i++)
		{
			shots.get(i).update(- currentScene.getScreenH()/80.0f);
			
			if(ship.collision4(ship, shots.get(i))){
				shots.remove(i);
				ship.life--;
			}
			
			if(ship.collision5(shots.get(i))){
				shots.remove(i);
			}
		}
	}

	public List<Shot> getShots() {
		return shots;
	}

	public void setShots(List<Shot> shots) {
		this.shots = shots;
	}

	public CurrentScene getCurrentScene() {
		return currentScene;
	}


}
