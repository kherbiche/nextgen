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
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class AuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private static final Log logger = LogFactory.getLog(AuthenticationFilter.class);
	/**
	 * @see {@link dz.ummto.ansejnextgen.jaxrs.api.TokenBasedSecurityContext#getAuthenticationScheme()}.
	 */
	private static final String SCHEME = "Yugarten";

	@Inject
	private UserService userService;
	@Inject
	private AuthenticationTokenService authenticationTokenService;

	/**
	 *  Method for ContainerRequestFilter
	 **/
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// If it's a preflight request, we abort the request with
        // a 200 status, and the CORS headers are added in the
        // response filter method below.
        if (isPreflightRequest(requestContext)) {
			logger.info("-- filter() Method for ContainerRequestFilter. it is a PreflightRequest.");
            requestContext.abortWith(Response.ok().build());
            return;
        }
		
		String header = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		logger.info("-- filter() Method for ContainerRequestFilter. header="+header);
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

	/**
     * A preflight request is an OPTIONS request
     * with an Origin header.
     */
    private boolean isPreflightRequest(ContainerRequestContext request) {
		return request.getHeaderString("Origin") != null && request.getMethod().equalsIgnoreCase("OPTIONS");
    }
    
    /**
	 *  Method for ContainerResponseFilter
	 **/
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

		logger.info("-- filter() Method for ContainerResponseFilter.");
		// if there is no Origin header, then it is not a
        // cross origin request. We don't do anything.
        if (requestContext.getHeaderString("Origin") == null) {
            return;
        }

        // If it is a preflight request, then we add all
        // the CORS headers here.
        if (isPreflightRequest(requestContext)) {
            responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
            responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            responseContext.getHeaders().add("Access-Control-Allow-Headers",
                // Whatever other non-standard/safe headers (see list above) 
                // you want the client to be able to send to the server,
                // put it in this list. And remove the ones you don't want.
                "X-Requested-With, Authorization, " +
                "Accept-Version, Content-MD5, CSRF-Token, Content-Type, " +
                "accept, origin, Access-Control-Allow-Headers");
        }

        // Cross origin requests can be either simple requests
        // or preflight request. We need to add this header
        // to both type of requests. Only preflight requests
        // need the previously added headers.
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
	}

}
