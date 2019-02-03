/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import dz.ummto.ansejnextgen.gui.promoter.DataModel;
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
			ArrayNode arrynode = message.readEntity(ArrayNode.class); //node runtime class=com.fasterxml.jackson.databind.node.ArrayNode

			try {
				/** Class cls = Class.forName("dz.ummto.ansejnextgen.gui.promoter.DataModel"); */
				Method methods[] = Class.forName("dz.ummto.ansejnextgen.gui.promoter.DataModel").getDeclaredMethods();
				logger.info("-- number of methods= "+methods.length);
				methods = Arrays.stream(methods).filter(x -> x.getName().startsWith("set")).toArray(Method[]:: new);
				logger.info("-- number of methods= "+methods.length);

				List<DataModel> list = new ArrayList<DataModel>();
				for (Iterator<JsonNode> iterator = arrynode.elements(); iterator.hasNext();) {
					JsonNode jsonnode = iterator.next();
					// logger.info("-- jsonnode: "+jsonnode);
					DataModel dm = new DataModel();
					for (Iterator<String> itera = jsonnode.fieldNames(); itera.hasNext();) {
						String field = itera.next();
						for (int i = 0; i < methods.length; i++) {

							String methodname = methods[i].getName();
							/**
							 * @param submethodname
							 * setNumAddress -> setnumAddress -> numAddress
							 */
							String submethodname = methodname.replace(methodname.charAt(3), Character.toLowerCase(methodname.charAt(3))).substring(3);

							if(field.equals(submethodname)) {
								//logger.info("-- methodName: "+methodname+" ** "+field+" == "+submethodname);
								methods[i].invoke(dm, ""+jsonnode.get(field));
								list.add(dm);
							} else
								if (jsonnode.get(field).isContainerNode() && jsonnode.get(field).findParent(submethodname)!= null) {
									//logger.info("-- methodName: "+methodname +" ** "+field+" is ContainerNode: " + jsonnode.get(field));
									//logger.info("-- findParent(): "+jsonnode.get(field).findParent(submethodname).get(submethodname));
									methods[i].invoke(dm, ""+jsonnode.get(field).findParent(submethodname).get(submethodname));
									list.add(dm);
									
								}
						}
					}
				}
				logger.info("-- List<DataModel>.size():"+list.size());
			} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.error("-- error Java Reflect: " + e.getMessage());
			}
			/**
			return IntStream.range(0, node.size()).mapToObj(node::get)
			.map(new Function<JsonNode, DataModel>() {
				@Override
				public DataModel apply(JsonNode t) {
					logger.info("the runtime class: "+t.getClass());
					logger.info("-- t: "+t);
					return null;
				}
			});
			*/
			/**
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
