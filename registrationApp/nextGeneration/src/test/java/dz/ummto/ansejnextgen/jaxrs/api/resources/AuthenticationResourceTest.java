/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.ummto.ansejnextgen.jaxrs.ArquillianTest;
import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationToken;

/**
 * The <code>AuthenticationResourceTest</code> class represents Tests for the
 * {@link AuthenticationRS} resource class.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@RunWith(Arquillian.class)
public class AuthenticationResourceTest extends ArquillianTest {

	@Test
	public void authenticateWithValidCredentials() {

		Response response = client.target(uri).path("/rest").path("/auth").request()
				.post(Entity.entity(Arrays.asList("lyes", "lyes"), MediaType.APPLICATION_JSON));

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

		AuthenticationToken authenticationToken = response.readEntity(AuthenticationToken.class);
		assertNotNull(authenticationToken);
		assertNotNull(authenticationToken.getToken());
	}

	@Test
	public void authenticateWithInvalidCredentials() {

		Response response = client.target(uri).path("/rest").path("/auth").request()
				.post(Entity.entity(Arrays.asList("invalid", "invalid"), MediaType.APPLICATION_JSON));

		assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
	}

}
