/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.registers;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * The <code>JaxRsClient</code> class represents the factory of
 * <code>javax.ws.rs.client.Client</code>
 * <p>
 * The class <code>JaxRsClient.client</Code> should be created once for an 
 * application and must be reused when required.
 * @see <a href="link">https://blogs.oracle.com/japod/how-to-use-jersey-client-efficiently</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public final class JaxRsClient {
	private static Client client;
	
	/**
	 * Instantiates <code>javax.ws.rs.client.Client</code>
	 */
	private synchronized static void createClient() {
		if(client==null) {
			client = ClientBuilder.newClient(new ClientConfig().register(JacksonFeature.class));
		}
	}
	
	/**
	 * Returns the unique instance of <code>javax.ws.rs.client.Client</code>
	 * @return <code>javax.ws.rs.client.Client</code>
	 */
	public static Client getClient() {
		createClient();
		return client;	
	}

}
