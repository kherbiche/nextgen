/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao.impl;

import dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao;
import dz.ummto.ansejNextGen.jpa.entities.Eligibility;
import dz.ummto.ansejNextGen.jpa.util.EMProvider;

import java.util.List;

/**
 * The <code>EligibilityDao</code> class represents a JPA DAO implementation. It
 * will have basic implementation of all the methods in the standard
 * {@link IDao} interface
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

public class EligibilityDao extends AbstractJpaDao<Long, Eligibility> {

	@Override
	public List<Eligibility> find(final Eligibility entity) {
		logger.info("-- EligibilityDao find(E entity) methode");
		logger.info("-- EligibilityDao threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		return EMProvider.getEntityManager().createNamedQuery(AbstractJpaDao.FIND + entityClass.getSimpleName())
												.setParameter(1, entity.getPromoter().getPromoterId().getFirstName())
												.setParameter(2, entity.getPromoter().getPromoterId().getLastName())
												.setParameter(3, entity.getPromoter().getPromoterId().getBirthDate())
												.getResultList();
	}
}
