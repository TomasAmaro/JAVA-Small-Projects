package org.academiadecodigo.myApp.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateSessionManager {
    private SessionFactory sessionFactory;

    public HibernateSessionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
      /*  try {

// Hold services needed by Hibernate
            System.out.println("Estou Aqui no topo!");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // Load settings from hibernate.cfg.xml
                    .build();
            System.out.println("Estou Aqui em baixo!");
            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata() // Tell Hibernate about sources of metadata (database mappings)
                    .buildSessionFactory();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Error creating hibernate session factory: " + ex.getMessage());
        }*/
    }


    // hibernate initialization code

    public Session getSession() {
        // Hibernate will automatically open a new session if needed
        // Closing the session is not required
        return sessionFactory.getCurrentSession();
    }

    // Required to stop hibernate and allow the application to terminate
    public void close() {
        sessionFactory.close();
    }


    public Session beginTransaction() {
        getSession().beginTransaction();
        return getSession();
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
}
