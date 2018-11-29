/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import dz.ummto.ansejNextGen.jpa.entities.User;
import dz.ummto.ansejNextGen.jpa.entities.UserRole;
import dz.ummto.ansejnextgen.jaxrs.Authority;
import dz.ummto.ansejnextgen.jaxrs.api.AuthenticatedUserDetails;
import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationTokenDetails;
import dz.ummto.ansejnextgen.jaxrs.api.TokenBasedSecurityContext;
import dz.ummto.ansejnextgen.jaxrs.service.AuthenticationTokenService;
import dz.ummto.ansejnextgen.jaxrs.service.UserService;

/**
 * The <code>AuthenticationFilter</code> represents JWT authentication filter.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Provider
@Dependent
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	/**
	 * @see {@link dz.ummto.ansejnextgen.jaxrs.api.TokenBasedSecurityContext#getAuthenticationScheme()}.
	 */
	private static final String SCHEME = "Yugarten";

	@Inject
	private UserService userService;
	@Inject
	private AuthenticationTokenService authenticationTokenService;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String header = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (header != null && header.startsWith(SCHEME + " ")) {
			String authenticationToken = header.substring(9);
			handleTokenBasedAuthentication(authenticationToken, requestContext);
			return;
		}
		/* Other authentication schemes (such as Basic) could be supported. */
	}

	private void handleTokenBasedAuthentication(String authenticationToken, ContainerRequestContext requestContext) {

		AuthenticationTokenDetails authToDet = authenticationTokenService.parseToken(authenticationToken);
		User user = userService.findById(authToDet.getUsername());
		Set<Authority> setAuth = new HashSet<Authority>();
		for (UserRole ur : user.getUserRoles()) {
			setAuth.add(Authority.valueOf(ur.getRole().name()));
		}

		AuthenticatedUserDetails authUserDet = new AuthenticatedUserDetails(user.getUserName(), setAuth);
		boolean secure = requestContext.getSecurityContext().isSecure();
		SecurityContext secContext = new TokenBasedSecurityContext(authUserDet, authToDet, secure);
		requestContext.setSecurityContext(secContext);
	}

}
