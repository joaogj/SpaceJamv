package com.example.spacejamv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public abstract class Scene{
	
	protected Context c;
	protected Paint[] painter;
	
	
	public Scene(Context c) {
		this.c = c;
		
		this.painter = new Paint[4];
		
		this.painter[0] = new Paint();
		this.painter[0].setColor(Color.BLACK);
		this.painter[0].setTextSize(50);

		this.painter[1] = new Paint();
		this.painter[1].setColor(Color.RED);
		this.painter[1].setTextSize(100);

		/*this.painter[2] = new Paint();
		this.painter[2].setColor(Color.GREEN);
		
		this.painter[3] = new Paint();
		this.painter[3].setColor(Color.BLUE);*/
	}
	
	protected abstract void draw (Canvas canvas);
	
	protected abstract void MotionEvent(MotionEvent event);
	
	protected abstract void Update();
	
	protected void drawCenter(Canvas canvas, Paint paint, String text) {
        int cHeight = canvas.getClipBounds().height();
        int cWidth = canvas.getClipBounds().width();
        Rect r = new Rect();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }
}
