package com.example.spacejamv;

public class ActorFactory {
    private Actor actor = null;

    public Actor GetActor(String type){
        if(type.equals("foe")){
            actor = new EnemyManager();
        }
        else if(type.equals("player")) {
            actor = new Ship();
        }
        else if(type.equals("power")) {
            actor = new PowerUp();
        }
        return actor;
    }
}
