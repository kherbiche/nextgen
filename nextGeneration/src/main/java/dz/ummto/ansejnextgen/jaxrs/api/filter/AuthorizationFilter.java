/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.Dependent;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 * The <code>AuthorizationFilter</code> represents Role authorization filter.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Provider
@Dependent
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		if (method.isAnnotationPresent(DenyAll.class)) {
			throw new AccessDeniedException("You do not have permission to access this resource or perfom this action");
		}

		RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
		if (rolesAllowed != null) {
			performAuthorization(rolesAllowed.value(), requestContext);
			return;
		}

		if (method.isAnnotationPresent(PermitAll.class)) {
			return;
		}

		rolesAllowed = resourceInfo.getResourceClass().getAnnotation(RolesAllowed.class);
		if (rolesAllowed != null) {
			performAuthorization(rolesAllowed.value(), requestContext);
		}

		/* @PermitAll on the class. */
		if (resourceInfo.getResourceClass().isAnnotationPresent(PermitAll.class)) {
			/* Do nothing. */
			return;
		}

		/* Authentication is required for non-annotated methods. */
		if (!isAuthenticated(requestContext)) {
			throw new AccessDeniedException("Authentication is required to perform this action.");
		}
	}

	private void performAuthorization(String[] value, ContainerRequestContext requestContext)
			throws AccessDeniedException {

		if (value.length > 0 && !isAuthenticated(requestContext)) {
			throw new AccessDeniedException("Authentication is required to perform this action.");
		}

		for (final String role : value) {
			if (requestContext.getSecurityContext().isUserInRole(role)) {
				return;
			}
		}

		throw new AccessDeniedException("You don't have permissions to perform this action.");
	}

	/**
	 * Check if the user is authenticated.
	 *
	 * @param requestContext
	 * @return
	 */
	private boolean isAuthenticated(final ContainerRequestContext requestContext) {
		return requestContext.getSecurityContext().getUserPrincipal() != null;
	}

}
