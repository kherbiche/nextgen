/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import dz.ummto.ansejnextgen.jaxrs.api.model.ApiErrorDetails;

/**
 * The <code>AuthenticationTokenRefreshmentExceptionMapper</code> class
 * represents Exception mapper for
 * {@link AuthenticationTokenRefreshmentException}'s.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Provider
public class AuthenticationTokenRefreshmentExceptionMapper
		implements ExceptionMapper<AuthenticationTokenRefreshmentException> {

	@Context
	private UriInfo uriInfo;

	@Override
	public Response toResponse(AuthenticationTokenRefreshmentException exception) {

		Status status = Status.FORBIDDEN;

		ApiErrorDetails errorDetails = new ApiErrorDetails();
		errorDetails.setStatus(status.getStatusCode());
		errorDetails.setTitle(status.getReasonPhrase());
		errorDetails.setMsg("The authentication token cannot be refreshed.");
		errorDetails.setPath(uriInfo.getAbsolutePath().getPath());

		return Response.status(status).entity(errorDetails).type(MediaType.APPLICATION_JSON).build();
	}

}
