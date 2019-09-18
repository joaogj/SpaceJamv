package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.acelerometro.R;

public class Game extends Scene
{

	private Ship ship;
	private EnemyManager enemyManager;
	private PowerUp power;
	private CurrentScene currentScene;
	private CurrentSceneActivity currentSceneActivity;


	Game(Context c) {
		super(c);
		currentScene = new CurrentScene(c);
		currentSceneActivity = new CurrentSceneActivity();
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
		ship = new Ship(0, currentScene.getScreenH()/2, this.c);
		enemyManager = new EnemyManager(this.c);
		power = new PowerUp(currentScene.getScreenW()/2, currentScene.getScreenH()/2, this.c);

	}

	@Override
	protected void draw(Canvas canvas) {
        canvas.drawBitmap(img, 0, 0, painter[0]);
		ship.draw(canvas,painter[1]);	
		power.draw(canvas, painter[1]);
		enemyManager.draw(canvas, painter[1]);

		canvas.drawText("Record: " + ship.getRecord().getRecordString(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/13.0f), painter[0]);
		canvas.drawText("Score: " + ship.getScore(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/7.0f), painter[0]);

	}

	@Override
	protected void MotionEvent(android.view.MotionEvent event) {
		ship.motionEvent(event);
	}

	@Override
	protected void Update() {
		this.ship.update((float) (currentSceneActivity.getY() * 1.5));
		power.update(ship);
		enemyManager.update(ship);
	}

}
