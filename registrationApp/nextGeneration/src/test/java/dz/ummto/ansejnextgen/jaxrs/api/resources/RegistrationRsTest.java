/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.resources;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.databind.JsonNode;

import dz.ummto.ansejnextgen.jaxrs.ArquillianTest;

/**
 * The <code>RegistrationRsTest</code> class represents Tests for the
 * {@link RegistrationRs} resource class.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@RunWith(Arquillian.class)
public class RegistrationRsTest extends ArquillianTest {

	@Test
	public void processPromoter() throws InterruptedException, ExecutionException {

		List<String> list = Arrays.asList("firstname", "lastname", "12/12/1989","MALE",
				"fathername", "mothername", "15991989", "lni", "15550", "dz", "15", "STREET", "tala",
				"otr", "15550", "dz", "ans.to@ans.au", "0666666666", "09999999", "single", "15998912",
				"Bac+5(or more)", "Experience 3 years(or more)", "computerscience");
		
		String header = composeAuthorizationHeader(getTokenForUser());
		Future<Response> futureResponse = client.target(uri).path("/rest").path("/savepromoter").request()
				.header(HttpHeaders.AUTHORIZATION, header)
				.async()
				.post(Entity.entity(list, MediaType.APPLICATION_JSON));
		
		Response response = futureResponse.get();
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		assertEquals(response.readEntity(JsonNode.class).get("father").asText(), "fathername");
	}
}
