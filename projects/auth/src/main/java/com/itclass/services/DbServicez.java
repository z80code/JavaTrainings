package com.itclass.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.itclass.model.User;

public class DbServicez {
	private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";
    
    private final SessionFactory sessionFactory;
    
    public DbServicez() {
        Configuration configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }
    
    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/???");
        configuration.setProperty("hibernate.connection.username", "???");
        configuration.setProperty("hibernate.connection.password", "???");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        
        return configuration;
    }
    
    public List<User> getAll( ) {
    	Session session = sessionFactory.openSession();
    	List<User> users =  (List<User>)session.createQuery("from User").list();
    	session.close();
    	
    	return users;
    }
    
    public long addUser(String name) {
        //try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //session.sa
            //UsersDAO dao = new UsersDAO(session);
            //long id = dao.insertUser(name);
            transaction.commit();
            session.close();
            //return id;
        //} 
            
        return 0;
    }
    
    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
