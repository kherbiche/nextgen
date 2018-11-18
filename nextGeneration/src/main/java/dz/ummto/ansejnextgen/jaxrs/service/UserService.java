/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import dz.ummto.ansejNextGen.jpa.dao.DaoFactory;
import dz.ummto.ansejNextGen.jpa.dao.IDao;
import dz.ummto.ansejNextGen.jpa.entities.User;

/**
 * The <code>UserService</code>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class UserService {

	public User findById(String id) {
		IDao<String, User> userDao = DaoFactory.getUserDao();
		return userDao.findById(id);
	}

}
