package org.academiadecodigo.SniperElite;

/**
 * Created by tomasamaro on 12/10/16.
 */
public class RNG {

        public static int getRandom(int min, int max) {

            return (int) (Math.random() * (max - min) + min);
        }


    }
