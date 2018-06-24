package com.example.spacejamv;

import android.content.Context;
import android.graphics.Canvas;

public class Game extends Scene
{
	//private final int FRAME_PERIOD = 1000 / 50; //50 � o fps desejado
		
	private Ship ship;
	private EnemyManager EnemyManager;
	
	//public static boolean menu;
	
	public Game(Context c) {
		super(c);
				
		ship = new Ship(0, CurrentScene.screenH/2, this.c);
		EnemyManager = new EnemyManager(this.c);
	}

	@Override
	protected void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		ship.draw(canvas,painter[1]);	
		
		EnemyManager.draw(canvas, painter[1]);

		canvas.drawText("Record : " + ship.record.getRecordString(), (float) (CurrentScene.screenW/1.4), (float) (CurrentScene.screenH/13), painter[0]);
		canvas.drawText("Score : " + Integer.toString(ship.score), (float) (CurrentScene.screenW/1.4), (float) (CurrentScene.screenH/7), painter[0]);

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

		EnemyManager.Update(ship);
	}

}
