/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The <code>RegisterOne</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class RegisterOne {
	
	private static final Log logger = LogFactory.getLog(RegisterOne.class);
	private final String  BASE_URI= "http://localhost:8089";
	
	private URI getBaseURI() {
		return UriBuilder.fromUri(BASE_URI).build();
	}
	
	public void register(List<String> list) {
		final WebTarget target = JaxRsClient.getClient().target(getBaseURI());
		Response message = target.path("/rest").path("/test")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(list, MediaType.APPLICATION_JSON));
		
		logger.info("--- message.getStatus(): "+message.getStatus());
		logger.info("--- message.getEntity(): "+message.getEntity());
		logger.info("--- message.toString(): "+message.toString());
	}
}
