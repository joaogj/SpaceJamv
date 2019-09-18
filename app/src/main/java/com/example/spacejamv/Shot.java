package com.example.spacejamv;

import com.example.acelerometro.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Shot extends Actor
{
	
	public Shot(int x, int y, Context c)
	{
		this.x = x;
		this.y = y;
		this.c = c;
		new BitmapFactory();
		this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.shot);
		this.height = img.getHeight();
		this.width = img.getWidth();
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		canvas.drawBitmap(img, this.x, this.y, painter);
	}
	
	public void Update(float speed)
	{
		//movement
		this.x += speed;
	}
}
