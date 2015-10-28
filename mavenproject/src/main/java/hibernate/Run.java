package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Run {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }

        //Session session = sessionFactory.openSession();
        //session.beginTransaction();
        //session.save( new Event( "Our very first event!", new Date() ) );
        //session.save( new Event( "A follow up event", new Date() ) );
        //session.getTransaction().commit();
        //session.close();

        // now lets pull events from the database and list them

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List result = session.createCriteria(Test.class)
                .setMaxResults(50)
                .add(Restrictions.eq("name", "World"))
                .list();

        for ( Test event : (List<Test>) result ) {
            System.out.println( "Event (" + event.getName() + ") : " + event.getNumber() );
        }
        session.getTransaction().commit();
        session.close();

        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }
}
