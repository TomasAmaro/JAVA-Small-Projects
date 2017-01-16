package org.academiadecodigo.myApp.dao;



/**
 * Created by codecadet on 05/12/16.
 */
public interface Dao<S> {


    public void add(S source);


    public S findByName(String email);


    public int count();

}
