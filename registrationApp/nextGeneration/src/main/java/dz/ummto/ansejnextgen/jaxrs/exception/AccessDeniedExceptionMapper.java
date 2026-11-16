/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import dz.ummto.ansejnextgen.jaxrs.api.model.ApiErrorDetails;

/**
 * The <code>AccessDeniedExceptionMapper</code> class represents Exception
 * mapper for {@link AccessDeniedException}'s.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Provider
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

	@Context
	private UriInfo uriInfo;

	@Override
	public Response toResponse(AccessDeniedException exception) {

		Status status = Status.FORBIDDEN;
		ApiErrorDetails error = new ApiErrorDetails();
		error.setStatus(status.getStatusCode());
		error.setTitle(status.getReasonPhrase());
		error.setMsg("You do not have enough permissions to perform this action.");
		error.setPath(uriInfo.getAbsolutePath().getPath());

		return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
