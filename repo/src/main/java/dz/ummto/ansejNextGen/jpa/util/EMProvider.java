/*
 * Copyright (C) 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
 * <p>
 * A generic facade that provides easy access to a JPA persistence unit using
 * static methods.
 * </p>
 * <p>
 * This static class is designed so that it can be used with any JPA
 * application.
 * </p>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class EMProvider {

	/**
	 * <p>
	 * Declare the persistence unit for this EMProvider ("ansePersiUnit").
	 * <p>
	 * This is the only setting that might need to be changed between applications.
	 * Otherwise, this class can be dropped into any JPA application.
	 */
	private static final String persitenceUnitName = "ansePersiUnit";

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocalEnityManager;
	private static final Log logger = LogFactory.getLog(EMProvider.class);

	static {
		logger.info("-- EMF instanciation");
		emf = Persistence.createEntityManagerFactory(persitenceUnitName);
		threadLocalEnityManager = new ThreadLocal<EntityManager>();
	}

	/**
	 * <p>
	 * Provide a per-thread EntityManager "singleton" instance.
	 * <p>
	 * This method can be called as many times as needed per thread, and it will
	 * return the same EntityManager instance, until the manager is closed.
	 * 
	 * @return EntityManager singleton for this current thread
	 */
	public static EntityManager getEntityManager() {
		logger.info("-- getEntityManager()");
		logger.info("-- EMProvider threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		EntityManager em = threadLocalEnityManager.get();
		if (em == null) {
			logger.info("-- em == null");
			em = emf.createEntityManager();
			threadLocalEnityManager.set(em);
		} else
			logger.info("-- em != null");
		return em;
	}

	/**
	 * <p>
	 * Close the EntityManager and set the thread's instance to null.
	 */
	public static void closeEntityManager() {
		logger.info("-- closeEntityManager()");
		EntityManager em = threadLocalEnityManager.get();
		if (em != null) {
			em.close();
			threadLocalEnityManager.set(null);
		}
	}

	/**
	 * <p>
	 * Close the EntityManagerFactory.
	 */
	public static void closeEntityManagerFactory() {
		logger.info("-- closeEntityManagerFactory()");
		emf.close();
	}

	/**
	 * <p>
	 * Initiate a transaction for the EntityManager on this thread.
	 * <p>
	 * The Transaction will remain open until commit or closeEntityManager is
	 * called.
	 */
	public static void beginTransaction() {
		logger.info("-- beginTransaction()");
		getEntityManager().getTransaction().begin();
	}

	/**
	 * <p>
	 * Undo an uncommitted transaction, in the event of an error or other problem.
	 */
	public static void rollback() {
		logger.info("-- rollback(");
		getEntityManager().getTransaction().rollback();
	}

	/**
	 * <p>
	 * Submit the changes to the persistence layer.
	 * <p>
	 * Until commit is called, rollback can be used to undo the transaction.
	 */
	public static void commit() {
		logger.info("-- commit()");
		getEntityManager().getTransaction().commit();
	}

	/**
	 * <p>
	 * Create a query for the EntityManager on this thread.
	 */
	public static Query createQuery(String query) {
		logger.info("-- createQuery("+query+")");
		return getEntityManager().createQuery(query);
	}
}
