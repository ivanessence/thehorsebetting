package by.ittc.horsebetting.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateEater {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {

		try {

			return new Configuration().configure("/hibernate.cfg.xml")
					.buildSessionFactory(
							new StandardServiceRegistryBuilder().applySettings(
									new Configuration().configure(
											"/hibernate.cfg.xml")
											.getProperties()).build());
		} catch (Throwable e) {
			System.out.println("Initial Session Factory failed");
			e.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
