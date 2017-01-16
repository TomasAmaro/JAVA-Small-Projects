package org.academiadecodigo.SniperElite;

import org.academiadecodigo.SniperElite.GameObject.*;

import java.util.Arrays;

/**
 * Created by tomasamaro on 12/10/16.
 */
public class Game {

    private GameObject[] gameObjects;
    private SniperRiffle sniperRiffle;
    private int shotsFired;
    private int enemiesHealth;

    public void start(int numberOfObjects, int bulletDamage, int health) {

        enemiesHealth = health;
        sniperRiffle = new SniperRiffle(bulletDamage);
        gameObjects = createObjects(numberOfObjects);
        shoot();

    }

//TODO Define hit enemy

    public void shoot() {
            for (int i = 0; i < gameObjects.length; i++) {
                if (gameObjects[i] instanceof Enemy) {
                    System.out.println(gameObjects[i].toString());
                    Enemy enemy = (Enemy) gameObjects[i];
                    while(!enemy.isDead()){
                        sniperRiffle.shoot((Enemy) gameObjects[i]);
                        System.out.println("i'm shooting");
                        shotsFired++;
                    }
                    System.out.println("i'm dead");
            }
                else {
                    System.out.println("i'm tree");
                }
        }

    }


    private GameObject[] createObjects(int numberOfObjects) {
        GameObject[] tempArray = new GameObject[numberOfObjects];

        for (int i = 0; i < numberOfObjects; i++) {
            int randomizer = RNG.getRandom(0, 100);
            if (randomizer < 30) {
               tempArray[i] = new SoldierEnemy(this.enemiesHealth);
            } else if (randomizer < 40) {
                tempArray[i] = new ArmouredEnemy(this.enemiesHealth, (this.enemiesHealth * 2));
            } else {
                tempArray[i] = new Tree();
            }
        }
        return tempArray;
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public SniperRiffle getSniperRiffle() {
        return sniperRiffle;
    }

    public void setSniperRiffle(SniperRiffle sniperRiffle) {
        this.sniperRiffle = sniperRiffle;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    public int getEnemiesHealth() {
        return enemiesHealth;
    }

    public void setEnemiesHealth(int enemiesHealth) {
        this.enemiesHealth = enemiesHealth;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameObjects=" + Arrays.toString(gameObjects) +
                ", sniperRiffle=" + sniperRiffle +
                ", shotsFired=" + shotsFired +
                ", enemiesHealth=" + enemiesHealth +
                '}';
    }
}
