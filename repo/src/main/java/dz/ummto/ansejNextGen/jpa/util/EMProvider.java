/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	private static final String persitenceUnitName = "ansePersiUnit";
	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory(persitenceUnitName);
		// entityManager = emf.createEntityManager();
	}

	protected static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
