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
		logger.setLevel(Level.WARNING);
	}

	private static SessionFactory sessionFactory = null;

	private static SessionFactory buildSessionFactory() {

		/**
		 * configures settings from hibernate.cfg.xml
		 */
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			/**
			 * The registry would be destroyed by the SessionFactory, but we had
			 * trouble building the SessionFactory so destroy it manually.
			 */
			StandardServiceRegistryBuilder.destroy(registry);
			throw ex;
		}

	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

	public static Session getSession() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory.openSession();
	}

}
