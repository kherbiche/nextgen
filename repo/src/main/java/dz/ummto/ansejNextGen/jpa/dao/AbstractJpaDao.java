/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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

	@SuppressWarnings("unchecked")
	/* @PostConstruct */
	public AbstractJpaDao() {
		logger.info("-- AbstractJpaDao Constructor");
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}

	@Override
	public E save(final E entity) {
		logger.info("-- AbstractJpaDao save() methode");
		logger.info("-- AbstractJpaDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		EMProvider.beginTransaction();
		EMProvider.getEntityManager().persist(entity);
		EMProvider.commit();
		return entity;
	}

	@Override
	public E update(final E entity) {
		logger.info("-- AbstractJpaDao upDate() methode");
		logger.info("-- AbstractJpaDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		EMProvider.beginTransaction();
		EMProvider.getEntityManager().merge(entity);
		EMProvider.commit();
		return entity;
	}

	@Override
	public void remove(final E entity) {
		logger.info("-- AbstractJpaDao remove() methode");
		logger.info("-- AbstractJpaDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		EMProvider.beginTransaction();
		EMProvider.getEntityManager().remove(
				EMProvider.getEntityManager().contains(entity) ? entity : EMProvider.getEntityManager().merge(entity));
		EMProvider.commit();
	}

	@Override
	public E findById(final K id) {
		logger.info("-- AbstractJpaDao findById() methode");
		logger.info("-- AbstractJpaDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		return EMProvider.getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		logger.info("-- AbstractJpaDao findAll() methode");
		logger.info("-- AbstractJpaDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		return EMProvider.getEntityManager().createNamedQuery(FIND_ALL).getResultList();
	}
}
