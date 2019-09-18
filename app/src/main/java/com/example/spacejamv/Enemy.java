package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Enemy
{
	protected Bitmap img;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected Context c;

	protected abstract void draw(Canvas canvas,Paint painter);

	
	protected void update(Ship ship){ }
}
