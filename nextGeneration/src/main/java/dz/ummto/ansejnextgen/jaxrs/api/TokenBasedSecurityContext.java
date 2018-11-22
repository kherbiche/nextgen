/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import dz.ummto.ansejnextgen.jaxrs.Authority;

/**
 * The <code>TokenBasedSecurityContext</code> represents {@link SecurityContext}
 * implementation for token-based authentication
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

public class TokenBasedSecurityContext implements SecurityContext {

	private AuthenticatedUserDetails authenticatedUserDetails;
	private AuthenticationTokenDetails authenticationTokenDetails;
	private final boolean secure;

	public TokenBasedSecurityContext(AuthenticatedUserDetails authenticatedUserDetails,
			AuthenticationTokenDetails authenticationTokenDetails, boolean secure) {
		this.authenticatedUserDetails = authenticatedUserDetails;
		this.authenticationTokenDetails = authenticationTokenDetails;
		this.secure = secure;
	}

	@Override
	public String getAuthenticationScheme() {
		return "Yugerten";
	}

	@Override
	public Principal getUserPrincipal() {
		return authenticatedUserDetails;
	}

	@Override
	public boolean isSecure() {
		return secure;
	}

	@Override
	public boolean isUserInRole(String role) {
		return authenticationTokenDetails.getAuthorities().contains(Authority.valueOf(role));
	}

	public AuthenticationTokenDetails getAuthenticationTokenDetails() {
		return authenticationTokenDetails;
	}
}
