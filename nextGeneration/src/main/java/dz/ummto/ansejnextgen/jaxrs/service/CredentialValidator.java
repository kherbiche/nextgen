/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import dz.ummto.ansejNextGen.jpa.entities.User;
import dz.ummto.ansejnextgen.jaxrs.exception.AuthenticationException;

/**
 * The <code>CredentialValidator</code> represents the mean which validate the
 * UserName and PassWord.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class CredentialValidator {

	private UserService userService;
	private PasswordEncoder passwordEncoder;

	public User validate(String userName, String pwd) {

		User user = userService.findById(userName);

		if (null == user) {
			throw new AuthenticationException("Bad Credential");
		}

		if (!user.isEnabled()) {
			throw new AuthenticationException("The User is disabled");
		}

		if (!passwordEncoder.checkPwd(pwd, user.getPassWord())) {
			throw new AuthenticationException("Bad Credential");
		}

		return user;
	}
}
