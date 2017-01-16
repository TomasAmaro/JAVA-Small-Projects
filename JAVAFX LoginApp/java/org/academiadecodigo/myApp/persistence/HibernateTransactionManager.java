package org.academiadecodigo.myApp.persistence;

import org.hibernate.SessionFactory;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateTransactionManager implements TransactionManager {

    HibernateSessionManager hibernateSessionManager;
    private SessionFactory sessionFactory;

    public HibernateTransactionManager() {
    }

    @Override
    public void beginTransaction() {
    hibernateSessionManager.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        hibernateSessionManager.commitTransaction();
    }

    @Override
    public void rollbackTransaction() {
    hibernateSessionManager.rollbackTransaction();
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
