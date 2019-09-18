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
	
	private void Spawn(){	
		if(enemies.size() < 3){
			random.nextDouble();
//			if(random.nextDouble() > 0.5f){
//				enemies.add(new Enemy_Follower((int) (CurrentScene.screenW/1.2f + ( CurrentScene.screenW/6 * enemies.size())),
//				(int) (CurrentScene.screenH * random.nextDouble()), this.c));
//			}else{
//				enemies.add(new Enemy_Shoter( (int) (CurrentScene.screenW/1.2),
//				(int) (CurrentScene.screenH * random.nextDouble()), this.c));
//			}

			enemies.add(new Enemy_Shoter( (int) (currentScene.getScreenW()/1.2), (int) (currentScene.getScreenH() * random.nextDouble()), this.c));
		}
	}
	
	public void Update (Ship ship)
	{
		Spawn();
		ship.isCanShot();
		ship.getScore();
		//for dos inimigos
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).Update(ship);

//			if(Collision4(this, this)){
//				this.y *= -1;
//			}

//			if(CollisionEnemy(enemies.get(i), enemies.get(i))){
//				this.y *= -1;
//			}

			// Inimigos canto da tela
			if(Collision3(enemies.get(i))){
				enemies.remove(i);
				//ship.setScore(); --;
				break;
			}
			
			// nave principal tiros inimigos
			if(Collision1(ship, enemies.get(i))){
				enemies.remove(i);
				ship.life--;
				break;
			}
			
			// for dos tiros da nave
			for(int j = 0; j < ship.getShots().size(); j++){

				//ship.isCanShot();
				
				// colisao tiros da nave e tela
				if(Collision5(ship.getShots().get(j))){
					ship.getShots().remove(j);
					ship.setCanShot(true);
					break;
				}
				
				// tiros da nave principal com inimigos
				if(Collision1(ship.getShots().get(j), enemies.get(i))){
					enemies.remove(i);
					ship.getShots().remove(j);
					ship.setCanShot(true);
					ship.setScore(ship.getScore()+1);
					break;
				}
			}
		}
	}
}
