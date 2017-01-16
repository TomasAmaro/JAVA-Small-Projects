package org.academiadecodigo.SniperElite.GameObject;

import org.academiadecodigo.SniperElite.GameObject.Enemy;
import org.academiadecodigo.SniperElite.SniperRiffle;

/**
 * Created by tomasamaro on 12/10/16.
 */
public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    @Override
    public void hitEnemy(int hit) {
        if (getHealth()<= 0) {
            die();
            System.out.println("Im dead Armoured Enemy");
            System.out.println(getMessage() + " and I'm dead");
        } else {
            if (armour > 0) {
               // setArmour(0);
                armour = armour - hit;
                System.out.println(getMessage() + " my armour is " + armour + " and my getHealth() is " + getHealth());
            } else {
                setHealth(getHealth() - hit);
                System.out.println(getMessage() + " my armour is " + armour + " and my health is " + getHealth());

            }
        }
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    @Override
    public String toString() {
        return "ArmouredEnemy{" +
                "armour=" + armour +
                "health=" + getHealth() +
                '}';
    }
}
