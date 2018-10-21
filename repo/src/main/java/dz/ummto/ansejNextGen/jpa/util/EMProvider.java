/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The <code>EMProvider</code> class represents the provider/wrapper of
 * {@link javax.persistence.EntityManager} which is not thread-safe.
 * <p>
 * For best practice and performance don't share the
 * {@link javax.persistence.EntityManager}, the recommendation is to bind the
 * <code>EntityManager</code> to the thread that serves the request, using a
 * ThreadLocal variable. This allows easy access (like accessing a static
 * variable) in all code that runs in this thread.
 * 
 * @see <a href=
 *      "https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html/transactions.html">jbosslink</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/9370819/hibernate-entitymanager-is-it-supposed-to-be-used-as-a-singleton">stacklink</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class EMProvider {

	private static final Log logger = LogFactory.getLog(EMProvider.class);
	private static final String persitenceUnitName = "ansePersiUnit";
	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocalEnityManager;

	static {
		logger.info("-- EMF instanciation");
		emf = Persistence.createEntityManagerFactory(persitenceUnitName);
		threadLocalEnityManager = new ThreadLocal<EntityManager>();
	}

	public static EntityManager getEntityManager() {
		logger.info("-- Entity manager from Thread Local");
		EntityManager em = threadLocalEnityManager.get();
		if (em == null) {
			em = emf.createEntityManager();
			threadLocalEnityManager.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = threadLocalEnityManager.get();
		if (em != null) {
			em.close();
			threadLocalEnityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		emf.close();
	}

	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	public static void commit() {
		getEntityManager().getTransaction().commit();
	}
}
