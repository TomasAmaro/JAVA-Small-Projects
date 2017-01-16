package org.academiadecodigo.SniperElite.GameObject;

/**
 * Created by tomasamaro on 13/10/16.
 */
public enum BarrelType {
    PLASTIC(30),
    WOOD(10),
    METAL(50);

    int maxDamage;

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}

