/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

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
