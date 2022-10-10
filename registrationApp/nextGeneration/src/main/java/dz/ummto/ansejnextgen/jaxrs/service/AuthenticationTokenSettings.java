/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import dz.ummto.ansejnextgen.cdiconfiguration.Configurable;

/**
 * The <code>AuthenticationTokenSettings</code> represents the settings for
 * signing and verifying JWT tokens
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Dependent
public class AuthenticationTokenSettings {

	@Inject
	@Configurable("authentication.jwt.secret")
	private String secret;

	@Inject
	@Configurable("authentication.jwt.clockSkew")
	private Long clockSkew;

	@Inject
	@Configurable("authentication.jwt.audience")
	private String audience;

	@Inject
	@Configurable("authentication.jwt.issuer")
	private String issuer;

	@Inject
	@Configurable("authentication.jwt.claimNames.authorities")
	private String authoritiesClaimName = "authorities";

	@Inject
	@Configurable("authentication.jwt.claimNames.refreshCount")
	private String refreshCountClaimName = "refreshCount";

	@Inject
	@Configurable("authentication.jwt.claimNames.refreshLimit")
	private String refreshLimitClaimName = "refreshLimit";

	public String getSecret() {
		return secret;
	}

	public Long getClockSkew() {
		return clockSkew;
	}

	public String getAudience() {
		return audience;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getAuthoritiesClaimName() {
		return authoritiesClaimName;
	}

	public String getRefreshCountClaimName() {
		return refreshCountClaimName;
	}

	public String getRefreshLimitClaimName() {
		return refreshLimitClaimName;
	}

}
