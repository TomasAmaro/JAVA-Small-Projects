package org.academiadecodigo.myApp.service.user;

import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.service.Service;

import java.sql.SQLException;

/**
 * Created by codecadet on 15/11/16.
 */
public interface UserService extends Service {

    public boolean authenticate (String email, String password);


    public void addUser(User user);


    public User findByName(String email);


    public int count();


}
