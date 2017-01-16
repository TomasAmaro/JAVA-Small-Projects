package org.academiadecodigo.SniperElite.GameObject;

/**
 * Created by tomasamaro on 12/10/16.
 */
public abstract class Enemy extends GameObject implements Destroyable {

    private int health;
    private boolean isDead;


    public Enemy(int health) {
        this.health = health;
    }

    public boolean isDead() {

        return isDead;
    }

    public void die(){
        isDead = true;
    }

    public abstract void hitEnemy(int hit);

    @Override
    public String getMessage() {


        return "I'm an Enemy";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void isDead(boolean dead) {
        isDead = dead;
    }
}
