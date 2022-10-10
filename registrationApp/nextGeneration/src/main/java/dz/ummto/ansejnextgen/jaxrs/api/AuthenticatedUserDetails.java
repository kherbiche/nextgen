/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api;

import java.security.Principal;
import java.util.Set;

import dz.ummto.ansejnextgen.jaxrs.Authority;

/**
 * The <code>AuthenticatedUserDetails</code> represents the implementation of
 * {@link Principal} with a set of {@link Authority}
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

public final class AuthenticatedUserDetails implements Principal {

	private final String userName;
	private final Set<Authority> authorities;

	public AuthenticatedUserDetails(String username, Set<Authority> authorities) {
		this.userName = username;
		this.authorities = authorities;
	}

	@Override
	public String getName() {
		return userName;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

}
