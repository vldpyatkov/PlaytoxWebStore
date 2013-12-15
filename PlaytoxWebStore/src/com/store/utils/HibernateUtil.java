package com.store.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/6/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    //private static ServiceRegistry serviceRegistry;

    private static void buildSessionFactory() {
        try {
            // load from different directory
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure(/*"/conf/hibernate.cfg.xml"*/).buildSessionFactory();
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

}
