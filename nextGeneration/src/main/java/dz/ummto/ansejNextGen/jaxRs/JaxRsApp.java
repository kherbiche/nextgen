/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jaxRs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;

import dz.ummto.ansejNextGen.jaxRs.resources.ForTest;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

/**
 * The <code>JaxRsApp</code> class represents simple 
 * JAX-RSx2. {@link ResourceConfig} 
 * @see also {@link Application}
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@ApplicationPath("/")
public class JaxRsApp extends ResourceConfig {
	
	
	private void registerEndPoints() {
		register(WadlResource.class);
		register(JacksonFeature.class);
		register(ForTest.class);
	}
	
	private void configSwagger() {
		register(ApiListingResource.class);
		BeanConfig beanConf = new BeanConfig();
		beanConf.setVersion("");
		beanConf.setSchemes(new String[] {"http"});
		beanConf.setHost("localhost:8089");
		beanConf.setBasePath("/");
		beanConf.setResourcePackage("dz.ummto.ansejNextGen.jaxRs.resources");
		beanConf.setPrettyPrint(true);
		beanConf.setScan(true);
	}
	
	public JaxRsApp() {
		configSwagger();
		registerEndPoints();
	}

}
