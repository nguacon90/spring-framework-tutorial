package vn.com.nguacon.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateDaoSupport {
	private Session session;
	protected static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Tạo session từ file config hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	private void openSession() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}

	public void save(Object o) {
		openSession();
		session.save(o);
		session.getTransaction().commit();
	}

	public void delete(Object o) {
		openSession();
		session.delete(o);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object get(Class clazz, int id) {
		openSession();
		return  session.get(clazz, id);
	}

	@SuppressWarnings({ "rawtypes"})
	public List findAll(Class clazz) {
		openSession();
		Query query = session.createQuery("from " + clazz.getName());
		return query.getResultList();
	}
}
