package org.academiadecodigo.SniperElite;

import org.academiadecodigo.SniperElite.GameObject.Enemy;

/**
 * Created by tomasamaro on 12/10/16.
 */
public class SniperRiffle {
    int bulletDamage;


    public SniperRiffle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public void shoot(Enemy enemy){

        enemy.hitEnemy(bulletDamage);

    }

    @Override
    public String toString() {
        return "SniperRiffle{" +
                "bulletDamage=" + bulletDamage +
                '}';
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void setBulletDamage(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }
}
