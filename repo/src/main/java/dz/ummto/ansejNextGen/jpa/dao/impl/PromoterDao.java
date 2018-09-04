/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao.impl;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao;
import dz.ummto.ansejNextGen.jpa.dao.IDao;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;
import dz.ummto.ansejNextGen.jpa.entities.PromoterId;

/**
 * The <code>PromoterDao</code> class represents a JPA DAO implementation. It
 * will have basic implementation of all the methods in the standard
 * {@link IDao} interface
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@NamedQueries({ @NamedQuery(name = AbstractJpaDao.FIND_ALL, query = "select p from Promoter p") })
public class PromoterDao extends AbstractJpaDao<PromoterId, Promoter> {

	@Override
	public Promoter update(Promoter entity) {
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public void remove(final Promoter promo) {
		logger.info("-- remove on PromoterDao methode");
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(promo) ? promo : entityManager.merge(promo));
		entityManager.getTransaction().commit();
	}

}
