package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Actor
{
	protected Bitmap img;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected int speedX;
	protected int speedY;
	protected int life;
	protected Context c;
	private CurrentScene currentScene;
	protected abstract void draw(Canvas canvas,Paint painter);	

	protected Actor(){
		c.getResources();
		currentScene = new CurrentScene(c);
	}

	protected boolean collision1(Actor actor, Actor actor2){
		return actor.x + actor.width > actor2.x && actor.x < actor2.x + actor2.width &&
				actor.y + actor.height > actor2.y && actor.y < actor2.y + actor2.height;
	}
	
	protected boolean collision3(Enemy enemy){
		return enemy.x < 0 - enemy.width;
	}
	
	protected boolean collision4(Actor actor, Actor actor2){
		return actor.x + actor.width > actor2.x && actor.x < actor2.x + actor2.width &&
				actor.y + actor.height > actor2.y && actor.y < actor2.y + actor2.height;
	}
	
	protected boolean collision5(Actor actor){
		return actor.x + actor.width >= currentScene.getScreenW() || actor.x + actor.width <= 0 ||
				actor.y + actor.height >= currentScene.getScreenH() || actor.y + actor.height <= 0;
	}
}
