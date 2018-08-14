/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.registers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * The <code>RegisterOne</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class RegisterOne {
	
	private final String  BASE_URI= "http://localhost:8089";
	
	private URI getBaseURI() {
		return UriBuilder.fromUri(BASE_URI).build();
	}
	
	public void register(List<String> list) {
		final WebTarget target = JaxRsClient.getClient().target(getBaseURI());
		Response message = target.path("/rest").path("/test")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(list.get(0), MediaType.APPLICATION_JSON));
		
		System.out.println("message.getStatus(): "+message.getStatus());
		System.out.println("message.getEntity(): "+message.getEntity());
		System.out.println("message.toString(): "+message.toString());
	}
}
