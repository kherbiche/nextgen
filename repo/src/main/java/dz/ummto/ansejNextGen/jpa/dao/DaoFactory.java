/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */

/**
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
 * The <code>DaoFactory</code> interface represents DAO Factory implementation
 * by java interface allowed by JAVA8
 * 
 * @see <a href=
 *      "https://stackoverflow.com/questions/512877/why-cant-i-define-a-static-method-in-a-java-interface?rq=1">sof</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/21817/why-cant-i-declare-static-methods-in-an-interface">sof</a>
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public interface DaoFactory {
	
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