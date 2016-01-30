package com.itclass.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationBinder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}
