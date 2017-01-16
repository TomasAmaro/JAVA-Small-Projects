package org.academiadecodigo.myApp.service.user;

import org.academiadecodigo.myApp.model.User;

import java.util.LinkedList;

/**
 * Created by codecadet on 15/11/16.
 */
public class MockUserService implements UserService {

    LinkedList<User> list = new LinkedList<>();


    @Override
    public boolean authenticate(String email, String password) {

        if(findByName(email) == null){
            return false;
        }

        return findByName(email).getEmail().equals(email) && findByName(email).getPassword().equals(password);
    }

    @Override
    public void addUser(User user) {
        list.add(user);

    }

    @Override
    public User findByName(String email) {
        for (User user:list) {
            if (user.getEmail().matches(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return list.size();
    }

    public LinkedList<User> getList() {
        return list;
    }

    @Override
    public String getServiceName() {
        return null;
    }
}
