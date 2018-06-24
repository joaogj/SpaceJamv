package com.example.spacejamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Menu extends Scene{

	public Menu(Context c) {
		super(c);
	}
	
	@Override
	protected void draw(Canvas canvas) {
		//canvas.drawText("MENU", CurrentScene.screenW/2 - painter.getTextSize(), CurrentScene.screenH/2, painter);
		drawCenter(canvas, painter[1], "MENU");
		canvas.drawText("João Gabriel", 0, (float) (CurrentScene.screenH/1.6), painter[0]);
		canvas.drawText("João Vítor", 0, (float) (CurrentScene.screenH/1.4), painter[0]);
		canvas.drawText("Matheus Escovino", 0, (float) (CurrentScene.screenH/1.25), painter[0]);
	}

	@Override
	protected void MotionEvent(android.view.MotionEvent event) {
		// TODO Auto-generated method stub
		
		int action = event.getAction();
		
		switch(action){
			case MotionEvent.ACTION_DOWN:
				CurrentScene.canInstantiate = true;
				CurrentScene.changeScene = "game";
				break;
		}
	}

	@Override
	protected void Update() {
	}

}
