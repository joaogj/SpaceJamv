package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Enemy
{
	protected Bitmap img;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected Context c;
	private CurrentScene currentScene = new CurrentScene(c);

	protected abstract void draw(Canvas canvas,Paint painter);

	
	protected void Update(Ship ship){	
	}
	
	protected boolean collision1(EnemyShoter actor, EnemyShoter actor2){
		if(actor.x + actor.width > actor2.x && actor.x < actor2.x + actor2.width &&
			actor.y + actor.height > actor2.y && actor.y < actor2.y + actor2.height ){
			return true;
		}
		return false;
	}	
	
	protected boolean collision2(Actor actor){
		if(actor.x < 0 || actor.x + actor.width > currentScene.getScreenW()  ||
				actor.y < 0 || actor.y + actor.height > currentScene.getScreenH() ){
			return true;
		}
		return false;
	}
	
	protected boolean collision3(Actor actor){
		if(actor.x < 0 - actor.width ){
			return true;
		}
		return false;
	}

	protected boolean collisionEnemy(Enemy enemy, Enemy enemy2){
		if(enemy.x + enemy.width > enemy2.x && enemy.x < enemy2.x + enemy2.width &&
				enemy.y + enemy.height > enemy2.y && enemy.y < enemy2.y + enemy2.height){
			return true;
		}
		return false;
	}
}
