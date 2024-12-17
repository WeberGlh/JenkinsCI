package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final Logger logger = Logger.getLogger("org.hibernate");

    static {
        logger.setLevel(Level.WARNING); // Set Hibernate logging level
    }

    private static SessionFactory sessionFactory = null;

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            // Add shutdown hook for cleanup
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (sessionFactory != null) {
                    sessionFactory.close();
                    logger.info("SessionFactory closed on shutdown.");
                }
            }));

            return factory;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "SessionFactory creation failed", ex);
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex; // Re-throw exception
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            logger.info("SessionFactory closed.");
        }
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    sessionFactory = buildSessionFactory();
                }
            }
        }
        return sessionFactory.openSession();
    }
}
