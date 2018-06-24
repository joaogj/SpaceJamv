package com.example.spacejamv;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameOver extends Scene{

	public GameOver(Context c) {
		super(c);
	}

	@Override
	protected void draw(Canvas canvas) {
		Record record = new Record(this.c);
		drawCenter(canvas, painter[0], "Record : " + record.getRecordString());
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
