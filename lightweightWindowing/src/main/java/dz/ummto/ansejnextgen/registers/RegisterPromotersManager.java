/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The <code>RegisterPromotersManager</code> class represents Jax-Rs client to manage promoters.
 * 
 * <p>
 * Related class for delegate pattern {@link RegisterLookUp}, {@link Client},
 * {@link RegisterDelegate}, {@link RegisterOne}, {@link IDelegate}
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/business-delegate-pattern/">link</a>
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.gui.promoter.DataModel;
import dz.ummto.ansejnextgen.users.UserSession;

public class RegisterPromotersManager implements IDelegate {

	private static final Log logger = LogFactory.getLog(RegisterPromotersManager.class);

	@Override
	public Object register(Object... args) {

		logger.info("-- RegisterPromotersManager.register(Object... args)");
		final WebTarget target = JaxRsClient.getClient().target(IDelegate.getBaseURI());
		Response message = target.path("/rest").path("/allpromoters")
				.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Yugarten "+ " " +UserSession.getToken())
				.get();

		if(message.getStatus() == Response.Status.OK.getStatusCode()) {
			logger.info("-- message.readEntity(JsonNode.class)"+message.readEntity(new GenericType<List<DataModel>>() {}));
		}
		
		return message.getStatus();
	}

}
