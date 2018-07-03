package com.example.spacejamv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.acelerometro.R;

import java.util.ArrayList;

public class PowerUp extends Actor {


    public PowerUp(int x, int y, Context c){

        c.getResources();
        this.x = x;
        this.y = y;
        this.speedX = 3;
        this.speedY = 3;
        this.c = c;
        this.img = new BitmapFactory().decodeResource(this.c.getResources(), R.drawable.shot);
        this.height = img.getHeight();
        this.width = img.getWidth();
    }

    @Override
    protected void draw(Canvas canvas, Paint painter) {
        canvas.drawRect(new Rect(0, 480, CurrentScene.screenW/15 * 3, CurrentScene.screenH/15), painter);
        canvas.drawBitmap(img, this.x, this.y, painter);
    }

    public void Movement(){
        this.x += speedX;
        this.y += speedY;
    }

    public void Collision(){
        if(this.y > CurrentScene.screenH - (this.height * 1.5f) || this.y < 0) {
            //this.speedX *= -1;
            this.speedY *= -1;
        }
//        else if (this.y < CurrentScene.screenH){
//            this.y *= 1;
//        }

        if(this.x > CurrentScene.screenW - (this.width * 1.5f) || this.x < 0){
            this.speedX *= -1;
        }
        else if(this.x < CurrentScene.screenW)
            this.speedX *= 1;


    }

    public void Update(Ship ship){

        for(int i = 0; i < ship.shots.size(); i++){
            if(Collision4(this, ship.shots.get(i))){
                ship.setCanShot(true);
            }
        }


        Movement();
        Collision();
    }
}
