package com.example.spacejamv;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.acelerometro.R;

public class Game extends Scene
{

	private Ship ship;
	private EnemyManager EnemyManager;
	private PowerUp power;
	private CurrentScene currentScene;


	public Game(Context c) {
		super(c);
		currentScene = new CurrentScene(c);
		img = new BitmapFactory().decodeResource(this.c.getResources(), R.drawable.bg);
		ship = new Ship(0, currentScene.getScreenH()/2, this.c);
		EnemyManager = new EnemyManager(this.c);
		power = new PowerUp(currentScene.getScreenW()/2, currentScene.getScreenH()/2, this.c);

	}

	@Override
	protected void draw(Canvas canvas) {
		// TODO Auto-generated method stub
        canvas.drawBitmap(img, 0, 0, painter[0]);
		ship.draw(canvas,painter[1]);	
		power.draw(canvas, painter[1]);
		EnemyManager.draw(canvas, painter[1]);

		canvas.drawText("Record: " + ship.record.getRecordString(), (float) (currentScene.getScreenW()/1.4), (float) (currentScene.getScreenH()/13.0f), painter[0]);
		canvas.drawText("Score: " + Integer.toString(ship.getScore()), (float) (currentScene.getScreenW()/1.4), (float) (currentScene.getScreenH()/7.0f), painter[0]);

	}

	@Override
	protected void MotionEvent(android.view.MotionEvent event) {
		// TODO Auto-generated method stub
		ship.MotionEvent(event);
	}

	@Override
	protected void Update() {
		// TODO Auto-generated method stub
		this.ship.Update((float) (CurrentSceneActivity.y * 1.5));
		power.Update(ship);
		EnemyManager.Update(ship);
	}

}
