/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api;

/**
 * The <code>AuthenticationToken</code> represents the API model for the
 * authentication token.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class AuthenticationToken {

	private String token;

	public AuthenticationToken() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
