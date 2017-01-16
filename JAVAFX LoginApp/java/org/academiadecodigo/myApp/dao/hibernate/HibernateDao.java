package org.academiadecodigo.myApp.dao.hibernate;

import org.academiadecodigo.myApp.dao.Dao;
import org.academiadecodigo.myApp.model.Role;
import org.academiadecodigo.myApp.model.User;

/**
 * Created by codecadet on 05/12/16.
 */
public class HibernateDao<myAppTables> implements Dao<myAppTables> {

    @Override
    public void add(myAppTables source) {
    }

    @Override
    public myAppTables findByName(String email) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
