/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao.impl;

import dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao;
import dz.ummto.ansejNextGen.jpa.dao.IDao;
import dz.ummto.ansejNextGen.jpa.entities.Address;

/**
 * The <code>AddressDao</code> class represents a JPA
 * DAO implementation. It will have basic implementation of all the methods in
 * the standard {@link IDao} interface
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class AddressDao extends AbstractJpaDao<Long, Address> {
	
	@Override
	public Address update(Address entity) {
		logger.info("-- upDate on AddressDao methode");
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public void remove(final Address entity) {
		logger.info("-- remove on AddressDao methode");
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		entityManager.getTransaction().commit();
	}

}
