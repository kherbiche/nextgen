/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import dz.ummto.ansejNextGen.jpa.dao.impl.AddressDao;
import dz.ummto.ansejNextGen.jpa.dao.impl.PromoterDao;
import dz.ummto.ansejNextGen.jpa.entities.Address;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;
import dz.ummto.ansejNextGen.jpa.entities.PromoterId;

/**
 * The <code>DaoFactory</code> class represents concrete DAO Factory
 * implementation.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class DaoFactory {

	public static IDao<PromoterId, Promoter> getPromoterDao() {
		return new PromoterDao();
	}

	public static IDao<Integer, Address> getAddressDao() {
		return new AddressDao();
	}

}
