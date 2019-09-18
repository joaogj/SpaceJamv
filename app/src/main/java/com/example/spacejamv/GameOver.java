package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.acelerometro.R;

public class GameOver extends Scene{

	private CurrentScene currentScene;

	public GameOver(Context c) {
		super(c);
		new BitmapFactory();
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
        currentScene = new CurrentScene(c);
	}

	@Override
	protected void draw(Canvas canvas) {

        canvas.drawBitmap(img, 0, 0, painter[0]);
		Record record = new Record(this.c);
		drawCenter(canvas, painter[0], "Record: " + record.getRecordString());
	}

	@Override
	protected void MotionEvent(android.view.MotionEvent event) {
		int action = event.getAction();
		
		switch(action){
		
		case MotionEvent.ACTION_DOWN:
			currentScene.setCanInstantiate(true);
			CurrentScene.changeScene = "menu";
			break;
		}
	}

	@Override
	protected void Update() {

	}

}
