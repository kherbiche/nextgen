/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationTokenDetails;

/**
 * The <code>AuthenticationTokenParser</code>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Dependent
public class AuthenticationTokenParser {

	@Inject
	private AuthenticationTokenSettings settings;

	/**
	 * Parse a JWT token.
	 * 
	 * @param token
	 * @return
	 */
	public AuthenticationTokenDetails parseToken(String token) {
		return null;
	}
}
