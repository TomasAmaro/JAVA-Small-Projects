package org.academiadecodigo.myApp.model;

import java.util.Set;

/**
 * Created by codecadet on 05/12/16.
 */
public class Role {

    private String role;
    private Set<User> users;

    public Role() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
