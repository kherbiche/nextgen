/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.resources;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.entities.User;
import dz.ummto.ansejNextGen.jpa.entities.UserRole;
import dz.ummto.ansejnextgen.jaxrs.Authority;
import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationToken;
import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationTokenDetails;
import dz.ummto.ansejnextgen.jaxrs.api.TokenBasedSecurityContext;
import dz.ummto.ansejnextgen.jaxrs.service.AuthenticationTokenService;
import dz.ummto.ansejnextgen.jaxrs.service.CredentialValidator;

/**
 * The <code>AuthenticationRS</code> class represents the JaxRs Resource that
 * does <strong>The User authentication process</strong>.
 * <p>
 * <strong>The User authentication process</strong> include multiple task:
 * authenticate the user and roles.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@RequestScoped
@Path("/rest")
public class AuthenticationRS {

	private static final Log logger = LogFactory.getLog(AuthenticationRS.class);
	@Inject
	private CredentialValidator credentialValidator;
	@Inject
	private AuthenticationTokenService authenticationTokenService;
	@Context
	private SecurityContext securityContext;

	@Path("/auth")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	/* @Consumes(MediaType.APPLICATION_FORM_URLENCODED) */
	public Response processAuthenticateUser(List<Object> list) {

		logger.info("-- /auth");
		logger.info("-- UserName:"+list.get(0).toString());

		User user = credentialValidator.validate(list.get(0).toString(), list.get(1).toString());

		Set<Authority> setAuth = new HashSet<Authority>();
		for (UserRole ur : user.getUserRoles()) {
			setAuth.add(Authority.valueOf(ur.getRole().name()));
		}
		String token = authenticationTokenService.issueToken(user.getUserName(), setAuth);

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setToken(token);

		return Response.ok(authenticationToken).build();
	}

	@SuppressWarnings("unused")
	@Deprecated
	private void authenticate(String username, String password) throws Exception {
		/*
		 * Authenticate against a database, LDAP, file or whatever Throw an Exception if
		 * the credentials are invalid
		 */
		logger.info("-- authenticate()");
	}

	@SuppressWarnings("unused")
	@Deprecated
	private String issueToken(String username) {
		/*
		 * Issue a token (can be a random String persisted to a database or a JWT token)
		 * The issued token must be associated to a user Return the issued token
		 */
		return "";
	}

	/**
	 * Refresh the authentication token for the current user.
	 * 
	 * @return
	 */
	@POST
	@Path("authrefresh")
	@Produces(MediaType.APPLICATION_JSON)
	public Response refresh() {
		AuthenticationTokenDetails authenticationTokenDetails = ((TokenBasedSecurityContext) securityContext)
				.getAuthenticationTokenDetails();
		String token = authenticationTokenService.refreshToken(authenticationTokenDetails);

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setToken(token);
		return Response.ok(authenticationToken).build();
	}
}
