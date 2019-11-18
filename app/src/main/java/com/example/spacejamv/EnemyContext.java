package com.example.spacejamv;

public class EnemyContext {
    private EnemyStrategy strategy;

    public void setEnemyStrategy(EnemyStrategy strategy){
        this.strategy = strategy;
    }

    public void executeEnemyStrategy(EnemyShoter enemy, Ship ship){
        strategy.execute(enemy, ship);
    }
}
