/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import dz.ummto.ansejNextGen.jpa.dao.impl.AddressDao;
import dz.ummto.ansejNextGen.jpa.dao.impl.PromoterDao;

/**
 * The <code>DaoFactory</code> class represents concrete DAO Factory
 * implementation.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class DaoFactory {

	public static IDao<?, ?> getPromoterDao() {
		return new PromoterDao();
	}
	
	public static IDao<?, ?> getAddressDao() {
		return new AddressDao();
	}

}
