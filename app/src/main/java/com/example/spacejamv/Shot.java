package com.example.spacejamv;

import com.example.acelerometro.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Shot extends Actor
{
	private ShotType type;
	private int x;
	private int y;


	public Shot(int x, int y, ShotType type)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.shot);
	}
	
	@Override
	public void draw(Canvas canvas, Paint painter)
	{
		type.draw(canvas, painter, this.x, this.y);
	}

	//atualização do tiro, com a movimentação incrementando o x com a variável speed
	public void update(float speed)
	{
		//movement
		this.x += speed;
	}
}
