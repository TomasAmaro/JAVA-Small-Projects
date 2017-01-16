package org.academiadecodigo.myApp.dao.hibernate;

import org.academiadecodigo.myApp.dao.UserDao;
import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.persistence.HibernateSessionManager;
import org.hibernate.criterion.Restrictions;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserDao extends HibernateDao<User> implements UserDao {

    private HibernateSessionManager hibernateSessionManager;

    @Override
    public void add(User user) {
        hibernateSessionManager.getSession().save(user);
    }

    @Override
    public User findByName(String email) {

        return (User) hibernateSessionManager.getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @Override
    public int count() {

        return ((Long)hibernateSessionManager.getSession()
                .createSQLQuery("SELECT COUNT(*) FROM myApp_db.table_users")
                .uniqueResult()).intValue();
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }
}
