/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import javax.inject.Inject;

import dz.ummto.ansejnextgen.cdiconfiguration.Configurable;

/**
 * The <code>AuthenticationTokenService</code>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class AuthenticationTokenService {

	@Inject
	@Configurable("authentication.jwt.validFor")
	private Long validFor;

	@Inject
	@Configurable("authentication.jwt.refreshLimit")
	private Integer refreshLimit;

	@Inject
	private AuthenticationTokenIssuer tokenIssuer;

	@Inject
	private AuthenticationTokenParser tokenParser;

}
