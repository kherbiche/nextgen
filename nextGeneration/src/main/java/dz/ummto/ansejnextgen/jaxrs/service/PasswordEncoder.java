/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import org.mindrot.jbcrypt.BCrypt;

/**
 * The <code>PasswordEncoder</code> represents BCrypt password encoder
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class PasswordEncoder {

	/**
	 * Hashes a password by BCrypt
	 * 
	 * @param pwd
	 * @return
	 */
	public String hashPwd(String pwd) {

		String salt = BCrypt.gensalt();
		return BCrypt.hashpw(pwd, salt);
	}

	public boolean checkPwd(String plainTextPwd, String hashedPwd) {

		if (null == hashedPwd || !hashedPwd.startsWith("$2a$")) {
			throw new RuntimeException("Hashed password is invalid");
		}

		return BCrypt.checkpw(plainTextPwd, hashedPwd);
	}
}
