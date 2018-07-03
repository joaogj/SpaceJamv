package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.acelerometro.R;

public class GameOver extends Scene{

	public GameOver(Context c) {
		super(c);
        img = new BitmapFactory().decodeResource(this.c.getResources(), R.drawable.bg);
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
			CurrentScene.canInstantiate = true;
			CurrentScene.changeScene = "menu";
			break;
		}
	}

	@Override
	protected void Update() {
		// TODO Auto-generated method stub
		
	}

}
