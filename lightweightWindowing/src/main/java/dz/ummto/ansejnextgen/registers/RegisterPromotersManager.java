/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.users.UserSession;

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
			logger.info("-- message.readEntity(JsonNode.class)"+message.readEntity(JsonArray.class));
			/**
			 * 
			return Arrays.asList(message.readEntity(Object[].class)).stream()
					.map(new Function<Object, String>() {
						@Override
						public String apply(Object t) {
							if(t instanceof List) {
								
							} else {
								logger.info("-- t: " +t.toString());
								logger.info("-- the runtime class t.getClass(): " +t.getClass()); // class java.util.LinkedHashMap
								Set<String> keys = ((LinkedHashMap<String, Object>) t).keySet();
								for(String key: keys) {
									logger.info("-- the key: "+ key);
									logger.info("-- the runtime class element: "+((LinkedHashMap<String, Object>) t).get(key).getClass());
									logger.info("-- element: "+((LinkedHashMap<String, Object>) t).get(key));
								}
							}
							return null;
						}
					})
					.collect(Collectors.toList());
			*/
			/**
			return message.readEntity(new GenericType<List<Object>>() {}).stream()
			.map(new Function<Object, String>() {
				@Override
				public String apply(Object t) {
					logger.info("-- the runtime class t.getClass(): " +t.getClass()); // class java.util.LinkedHashMap
					return "";
				}
			})
			.collect(Collectors.toList());
			*/
		}

		return message.getStatus();
	}

}
