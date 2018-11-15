/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
		final WebTarget target = JaxRsClient.getClient().target(IDelegate.getBaseURI());
		Response message = target.path("/rest").path("/auth").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(null, MediaType.APPLICATION_JSON));

		logger.info("--- message.getStatus(): " + message.getStatus());
		logger.info("--- message.getEntity(): " + message.getEntity());
		logger.info("--- message.toString(): " + message.toString());
	}

}
