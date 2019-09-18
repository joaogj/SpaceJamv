package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.acelerometro.R;

public class GameOver extends Scene{

	private CurrentScene currentScene;

	GameOver(Context c) {
		super(c);
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
        currentScene = new CurrentScene(c);
	}

	@Override
	protected void draw(Canvas canvas) {

        canvas.drawBitmap(img, 0, 0, painter[0]);
		Record record = new Record(this.c);
		drawCenter(canvas, painter[0], "Record: " + record.getRecordString());
	}

	//verifica o toque na tela para fazer a transição de cena para o menu
	@Override
	protected void motionEvent(android.view.MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			currentScene.setCanInstantiate(true);
			currentScene.setChangeScene("menu");
		}
	}

	@Override
	protected void update() {
		//método implementado devido a herança da classe abstrata Scene
	}
}
