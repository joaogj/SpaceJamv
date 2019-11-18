package com.example.spacejamv;

public class EnemyStrategyFollow implements EnemyStrategy{
    public void execute(EnemyShoter enemyShoter, Ship ship){
        if(enemyShoter.y > ship.y){
            enemyShoter.y -= enemyShoter.getCurrentScene().getScreenH()/400;
        }
        else if(enemyShoter.y < ship.y){
            enemyShoter.y += enemyShoter.getCurrentScene().getScreenH()/400;
        }
    }
}
