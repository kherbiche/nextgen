/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.jaxrs.api.model.UserCredentials;

/**
 * The <code>AuthenticationRS</code> class represents the JaxRs Resource that does
 * <strong>The User authentication process</strong>.
 * <p>
 * <strong>The User authentication process</strong> include multiple task:
 * authenticate the user and roles.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Path("/rest")
public class AuthenticationRS {

	private static final Log logger = LogFactory.getLog(AuthenticationRS.class);

	@Path("/auth")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/* @Consumes(MediaType.APPLICATION_FORM_URLENCODED) */
	public Response processAuthenticateUser(UserCredentials credentials) {
		return Response.ok("").build();
	}

	@SuppressWarnings("unused")
	@Deprecated
	private void authenticate(String username, String password) throws Exception {
		/*
		 * Authenticate against a database, LDAP, file or whatever
		 * Throw an Exception if the credentials are invalid
		 */
		logger.info("-- authenticate()");
	}

	@SuppressWarnings("unused")
	@Deprecated
	private String issueToken(String username) {
		/*
		 * Issue a token (can be a random String persisted to a database or a JWT token)
		 * The issued token must be associated to a user
		 * Return the issued token
		 */
		return "";
	}

	@POST
	@Path("authrefresh")
	@Produces(MediaType.APPLICATION_JSON)
	public Response refresh() {
		/*
		 * TODO
		 */
		return Response.ok("").build();
	}
}
