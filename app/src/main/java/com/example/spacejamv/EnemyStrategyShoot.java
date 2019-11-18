package com.example.spacejamv;

public class EnemyStrategyShoot implements EnemyStrategy {

    public void execute(EnemyShoter enemyShoter, Ship ship){
        ShotType type = ShotFactory.getShotType("enemy", enemyShoter.c);
        enemyShoter.getShots().add(new Shot(enemyShoter.x - enemyShoter.width, (int) (enemyShoter.y - enemyShoter.height / 3f), type));
    }
}
