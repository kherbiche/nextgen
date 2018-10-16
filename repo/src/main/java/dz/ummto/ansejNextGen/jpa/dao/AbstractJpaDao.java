/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.util.EMProvider;

/**
 * The <code>AbstractJpaDao<K, E></code> Abstract class represents a base JPA
 * DAO implementation. It will have basic implementation of all the methods in
 * the standard {@link IDao} interface
 *
 * @param <K>
 *            is the type to use as the key
 * @param <E>
 *            is the type of the entity
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public abstract class AbstractJpaDao<K, E> implements IDao<K, E> {

	protected static final Log logger = LogFactory.getLog(AbstractJpaDao.class);
	public static final String FIND_ALL = "Entity.findAll";
	protected Class<E> entityClass;
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	// @PostConstruct
	public AbstractJpaDao() {
		logger.info("-- AbstractJpaDao Constructor");
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		entityManager = EMProvider.getEntityManager();
	}

	@Override
	public E save(final E entity) {
		logger.info("-- AbstractJpaDao save() methode");
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public E update(final E entity) {
		logger.info("-- AbstractJpaDao upDate() methode");
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public void remove(final E entity) {
		logger.info("-- AbstractJpaDao remove() methode");
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		entityManager.getTransaction().commit();
	}

	@Override
	public E findById(final K id) {
		return entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return entityManager.createNamedQuery(FIND_ALL).getResultList();
	}
}
