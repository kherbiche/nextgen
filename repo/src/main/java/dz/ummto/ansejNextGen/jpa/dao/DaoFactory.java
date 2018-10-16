/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import dz.ummto.ansejNextGen.jpa.dao.impl.AddressDao;
import dz.ummto.ansejNextGen.jpa.dao.impl.PromoterDao;
import dz.ummto.ansejNextGen.jpa.dao.impl.UserDao;
import dz.ummto.ansejNextGen.jpa.dao.impl.UserRoleDao;
import dz.ummto.ansejNextGen.jpa.entities.Address;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;
import dz.ummto.ansejNextGen.jpa.entities.PromoterId;
import dz.ummto.ansejNextGen.jpa.entities.User;
import dz.ummto.ansejNextGen.jpa.entities.UserRole;

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

	public static IDao<Long, Address> getAddressDao() {
		return new AddressDao();
	}

	public static IDao<String, User> getUserDao() {
		return new UserDao();
	}

	public static IDao<Long, UserRole> getUserRoleDao() {
		return new UserRoleDao();
	}

}
