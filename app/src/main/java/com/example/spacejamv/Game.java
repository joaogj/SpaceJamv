package com.example.spacejamv;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;

import com.example.acelerometro.R;

public class Game extends Scene
{

	private Ship ship;
	private EnemyManager EnemyManager;
	private PowerUp power;


	public Game(Context c) {
		super(c);

		img = new BitmapFactory().decodeResource(this.c.getResources(), R.drawable.bg);
		ship = new Ship(0, CurrentScene.screenH/2, this.c);
		EnemyManager = new EnemyManager(this.c);
		power = new PowerUp(CurrentScene.screenW/2, CurrentScene.screenH/2, this.c);

	}

	@Override
	protected void draw(Canvas canvas) {
		// TODO Auto-generated method stub
        canvas.drawBitmap(img, 0, 0, painter[0]);
		ship.draw(canvas,painter[1]);	
		power.draw(canvas, painter[1]);
		EnemyManager.draw(canvas, painter[1]);

		canvas.drawText("Record: " + ship.record.getRecordString(), (float) (CurrentScene.screenW/1.4), (float) (CurrentScene.screenH/13), painter[0]);
		canvas.drawText("Score: " + Integer.toString(ship.getScore()), (float) (CurrentScene.screenW/1.4), (float) (CurrentScene.screenH/7), painter[0]);

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
