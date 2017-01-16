package org.academiadecodigo.myApp.dao;

import org.academiadecodigo.myApp.model.User;



/**
 * Created by codecadet on 01/12/16.
 */
public interface UserDao extends Dao<User> {

     void add(User user);


     User findByName(String email);


     int count();

}
