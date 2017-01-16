package org.academiadecodigo.SniperElite.GameObject;

/**
 * Created by tomasamaro on 13/10/16.
 */
public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;


    public boolean isDestroyed(){
        return destroyed;
    }

    public void hit (int hit){


    }

    public BarrelType getRandomType(){



    return barrelType;}

    @Override
    public String getMessage(){

        return "This is a Barrel";
    }



}
