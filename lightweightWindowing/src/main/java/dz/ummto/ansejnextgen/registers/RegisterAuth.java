/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.users.UserCredentials;

/**
 * The <code>RegisterOne</code> class represents
 * 
 * <p>
 * Related class for delegate pattern {@link RegisterLookUp}, {@link Client},
 * {@link RegisterDelegate}, {@link RegisterOne}, {@link IDelegate}
 * 
 * @see <a href=
 *      "link">https://www.geeksforgeeks.org/business-delegate-pattern/</a>
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class RegisterAuth implements IDelegate {

	private static final Log logger = LogFactory.getLog(RegisterAuth.class);

	@Override
	public void register(Object... args) {
		logger.info("--- RegisterAuth.register(Object... args)");
		@SuppressWarnings("unchecked")
		UserCredentials ngu = new UserCredentials(((List<String>) args[0]).get(0), ((List<String>) args[0]).get(1));
		final WebTarget target = JaxRsClient.getClient().target(IDelegate.getBaseURI());
		Response message = target.path("/rest").path("/auth").request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Yugarten ").post(Entity.entity(ngu, MediaType.APPLICATION_JSON));

		logger.info("--- message.getStatus(): " + message.getStatus());
		logger.info("--- message.getEntity(): " + message.getEntity());
		logger.info("--- message.toString(): " + message.toString());
	}

}
