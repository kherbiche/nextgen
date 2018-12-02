/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.entities.User;
import dz.ummto.ansejnextgen.jaxrs.exception.AuthenticationException;

/**
 * The <code>CredentialValidator</code> represents the mean which validate the
 * UserName and PassWord.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@ApplicationScoped
public class CredentialValidator {

	private static final Log logger = LogFactory.getLog(CredentialValidator.class);
	@Inject
	private UserService userService;
	@Inject
	private PasswordEncoder passwordEncoder;

	public User validate(String userName, String pwd) {

		logger.info("-- validate(String userName, String pwd), userName="+userName+" pwd="+pwd);
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
