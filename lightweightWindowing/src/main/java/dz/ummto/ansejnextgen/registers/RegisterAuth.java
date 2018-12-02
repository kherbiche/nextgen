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
		List list = (List)args[0];
		logger.info("-- UserName:"+list.get(0).toString());
		System.out.println("-- UserName:"+list.get(0).toString());
		logger.info("-- pwd to str:"+list.get(1).toString());
		System.out.println("-- pwd to str:"+list.get(1).toString());
		final WebTarget target = JaxRsClient.getClient().target(IDelegate.getBaseURI());
		Response message = target.path("/rest").path("/auth").request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Yugarten ").post(Entity.entity(list, MediaType.APPLICATION_JSON));

		logger.info("--- message.getStatus(): " + message.getStatus());
		logger.info("--- message.getEntity(): " + message.getEntity());
		logger.info("--- message.toString(): " + message.toString());
	}

}
