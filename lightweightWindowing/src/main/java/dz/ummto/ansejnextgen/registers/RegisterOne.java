/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.util.List;

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
class RegisterOne implements IDelegate {

	private static final Log loggerrr = LogFactory.getLog(RegisterOne.class);

	@Override
	public void register(Object... args) {
		loggerrr.info("--- RegisterOne.register(Object... args)");
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) args[0];
		final WebTarget target = JaxRsClient.getClient().target(IDelegate.getBaseURI());
		Response message = target.path("/rest").path("/savepromoter").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(list, MediaType.APPLICATION_JSON));

		loggerrr.info("--- message.getStatus(): " + message.getStatus());
		loggerrr.info("--- message.getEntity(): " + message.getEntity());
		loggerrr.info("--- message.toString(): " + message.toString());
	}

}
