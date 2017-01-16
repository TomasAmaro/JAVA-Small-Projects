package org.academiadecodigo.myApp.service.user;

import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.persistence.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by codecadet on 01/12/16.
 */
public class UserServiceHibernate implements UserService {

    HibernateSessionManager hibernateSessionManager;

    public UserServiceHibernate() {
    }

    @Override
    public boolean authenticate(String email, String password) {
        User user = null;
        try {
            user = findByName(email);
            if (user == null) {
                return false;
            }
            return findByName(email).getEmail().equals(email) && findByName(email).getPassword().equals(password);
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void addUser(User user) {

        Session session = hibernateSessionManager.beginTransaction();

        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String email) {
        User u = null;
        Session session = hibernateSessionManager.beginTransaction();
        try {
            u = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public int count() {
        Session session = hibernateSessionManager.beginTransaction();
        String query = "SELECT COUNT(*) FROM myApp_db.table_users";

        try {
           int count = session.createSQLQuery(query).list().size();
            session.getTransaction().commit();
            return count;
        }
        catch (HibernateException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public String getServiceName() {
        return this.getClass().getName();
    }
}
