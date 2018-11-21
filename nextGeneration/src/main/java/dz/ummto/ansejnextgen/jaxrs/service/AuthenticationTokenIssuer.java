/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationTokenDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The <code>AuthenticationTokenIssuer</code> represents component which
 * provides operations for issuing JWT tokens.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Dependent
public class AuthenticationTokenIssuer {

	@Inject
	private AuthenticationTokenSettings settings;

	/**
	 * Issue a JWT token
	 * 
	 * @param authenticationTokenDetails
	 * @return
	 */
	public String issueToken(AuthenticationTokenDetails authenticationTokenDetails) {

		return Jwts.builder().setId(authenticationTokenDetails.getId()).setAudience(settings.getAudience())
				.setSubject(authenticationTokenDetails.getUsername())
				.setIssuedAt(Date.from(authenticationTokenDetails.getIssuedDate().toInstant()))
				.setExpiration(Date.from(authenticationTokenDetails.getExpirationDate().toInstant()))
				.claim(settings.getAuthoritiesClaimName(), authenticationTokenDetails.getAuthorities())
				.claim(settings.getRefreshCountClaimName(), authenticationTokenDetails.getRefreshCount())
				.claim(settings.getRefreshLimitClaimName(), authenticationTokenDetails.getRefreshLimit())
				.signWith(SignatureAlgorithm.HS256, settings.getSecret()).compact();
	}
}
