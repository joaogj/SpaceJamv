package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Actor
{
	protected Bitmap img;
	protected int x, y, height, width, speedX, speedY,life;
	protected Context c;
	private CurrentScene currentScene = new CurrentScene(c);
	protected abstract void draw(Canvas canvas,Paint painter);	

	protected boolean Collision1(Actor actor, Enemy enemy){
		if(actor.x + actor.width > enemy.x && actor.x < enemy.x + enemy.width &&
			actor.y + actor.height > enemy.y && actor.y < enemy.y + enemy.height ){
			return true;
		}else{
			return false;
		}
	}	
	
//	protected boolean Collision2(Enemy enemy){
//		if(enemy.x < 0 || enemy.x + enemy.width > CurrentScene.screenW  ||
//				enemy.y < 0 || enemy.y + enemy.height > CurrentScene.screenH ){
//			return true;
//		}else{
//			return false;
//		}
//	}
	
	protected boolean Collision3(Enemy enemy){
		if(enemy.x < 0 - enemy.width ){
			return true;
		}else{
			return false;
		}		
	}
	
	protected boolean Collision4(Actor actor, Actor actor2){
		if(actor.x + actor.width > actor2.x && actor.x < actor2.x + actor2.width &&
			actor.y + actor.height > actor2.y && actor.y < actor2.y + actor2.height ){
			return true;
		}else{
			return false;
		}
	}
	
	protected boolean Collision5(Actor actor){
		if(actor.x + actor.width < currentScene.getScreenW() && actor.x + actor.width > 0 &&
			actor.y + actor.height < currentScene.getScreenH() && actor.y + actor.height > 0 ){
			return false;
		}else{
			return true;
		}
	}
}
