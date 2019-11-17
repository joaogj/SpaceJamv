package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.acelerometro.R;

public class Game extends Scene
{

	private void createActor(String type){
		ActorFactory actorFactory = new ActorFactory();
		Actor actor = actorFactory.GetActor(type);
	}

	Game(Context c) {
		super(c);
		CurrentScene currentScene = new CurrentScene(c);
		CurrentSceneActivity currentSceneActivity = new CurrentSceneActivity();
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
		createActor("player");
		createActor("foe");
		createActor("power");
	}

	@Override
	protected void draw(Canvas canvas) {
        canvas.drawBitmap(img, 0, 0, painter[0]);
		//ship.draw(canvas,painter[1]);
		//power.draw(canvas, painter[1]);
		//enemyManager.draw(canvas, painter[1]);

//		canvas.drawText("Record: " + ship.getRecord().getRecordString(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/13.0f), painter[0]);
//		canvas.drawText("Score: " + ship.getScore(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/7.0f), painter[0]);

	}

	@Override
	protected void motionEvent(android.view.MotionEvent event) { }

	@Override
	protected void update() { }
}
