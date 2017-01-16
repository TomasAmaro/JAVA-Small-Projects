package org.academiadecodigo.SniperElite.GameObject;

import org.academiadecodigo.SniperElite.SniperRiffle;

/**
 * Created by tomasamaro on 12/10/16.
 */
public class SoldierEnemy extends Enemy {

    public SoldierEnemy(int health) {
        super(health);
    }

    @Override
    public void hitEnemy(int hit){
    setHealth(getHealth() - hit);
        if(getHealth()<=0){
            die();
            //System.out.println("Im dead Soldier Enemy");
        }

    }

    @Override
    public String toString() {
        return "SoldierEnemy " +
                "health=" + getHealth();
    }
}
