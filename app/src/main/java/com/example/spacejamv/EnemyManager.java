package com.example.spacejamv;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class EnemyManager extends Actor{
	
	private List<Enemy> enemies;
	private Random random = new SecureRandom();
	private CurrentScene currentScene = new CurrentScene(c);

	public EnemyManager (Context c){
		this.c = c;

		enemies = new ArrayList<>();
	}
	
	@Override
	protected void draw(Canvas canvas, Paint painter)
	{
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).draw(canvas, painter);
		}
	}
	
	private void spawn(){
		if(enemies.size() < 3){
			random.nextDouble();
			enemies.add(new EnemyShoter( (int) (currentScene.getScreenW()/1.2), (int) (currentScene.getScreenH() * random.nextDouble()), this.c));
		}
	}
	
	public void update(Ship ship)
	{
		spawn();
		ship.isCanShot();
		ship.getScore();
		//for dos inimigos
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).update(ship);

			// Inimigos canto da tela
			if(collision3(enemies.get(i))){
				enemies.remove(i);
			}
			
			// nave principal tiros inimigos
			if(collision1(ship, enemies.get(i))){
				enemies.remove(i);
				ship.life--;
			}
			
			// for dos tiros da nave
			for(int j = 0; j < ship.getShots().size(); j++){

				// colisao tiros da nave e tela
				if(collision5(ship.getShots().get(j))){
					ship.getShots().remove(j);
					ship.setCanShot(true);
				}
				
				// tiros da nave principal com inimigos
				if(collision1(ship.getShots().get(j), enemies.get(i))){
					enemies.remove(i);
					ship.getShots().remove(j);
					ship.setCanShot(true);
					ship.setScore(ship.getScore()+1);
				}
			}
		}
	}
}
