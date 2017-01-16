package org.academiadecodigo.myApp.dao.hibernate;

import org.academiadecodigo.myApp.dao.RoleDao;
import org.academiadecodigo.myApp.model.Role;

/**
 * Created by codecadet on 05/12/16.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao {

    @Override
    public void add(Role source) {

    }

    @Override
    public Role findByName(String email) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
