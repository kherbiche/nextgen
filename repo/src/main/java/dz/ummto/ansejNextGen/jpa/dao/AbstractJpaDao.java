/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

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

	public static final String FIND_ALL = "Entity.findAll";
	protected Class<E> entityClass;
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	// @PostConstruct
	public AbstractJpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		entityManager = EMProvider.getEntityManager();
	}

	@Override
	public E save(final E entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public E update(final E entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(final E entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
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
