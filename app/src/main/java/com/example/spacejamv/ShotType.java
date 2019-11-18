package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class ShotType {
    private Bitmap img;
    private String name;
    private int width;
    private int height;
    private Context c;
    private int idImg;

    public ShotType(String name, int idImg, Context c){
        this.name = name;
        this.c = c;
        this.idImg = idImg;
        this.img = BitmapFactory.decodeResource(this.c.getResources(), idImg);
        this.width = this.img.getWidth();
        this.height = this.img.getHeight();
    }

    protected void draw(Canvas canvas, Paint painter, int x, int y) {
        canvas.drawBitmap(img, x, y, painter);
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
