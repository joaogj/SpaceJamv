package com.example.spacejamv;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Paint;

public class EnemyManager extends Actor{

	private Actor actor;
	private List<Enemy> enemies;
	private Random random = new SecureRandom();
	private CurrentScene currentScene = new CurrentScene(c);

	public EnemyManager (){
		enemies = new ArrayList<>();
	}


	//função que renderiza os inimigos
	@Override
	protected void draw(Canvas canvas, Paint painter)
	{
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).draw(canvas, painter);
		}
	}

	//função que chama novas waves de inimigos
	private void spawn(){
		if(enemies.size() < 3){
			random.nextInt();
			enemies.add(new EnemyShoter( (int) (currentScene.getScreenW()/1.2), (currentScene.getScreenH() * random.nextInt()), this.c));
		}
	}
	
	public void update()
	{
		spawn();
		//for dos inimigos
		for(int i = 0; i < enemies.size(); i++){

			// Inimigos canto da tela
			if(collision3(enemies.get(i))){
				enemies.remove(i);
			}
		}
	}
}
