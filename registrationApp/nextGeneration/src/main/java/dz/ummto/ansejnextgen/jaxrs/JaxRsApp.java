/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;

import dz.ummto.ansejnextgen.jaxrs.api.ObjectMapperProvider;
import dz.ummto.ansejnextgen.jaxrs.api.filter.AuthenticationFilter;
import dz.ummto.ansejnextgen.jaxrs.api.filter.AuthorizationFilter;
import dz.ummto.ansejnextgen.jaxrs.api.resources.AuthenticationRS;
import dz.ummto.ansejnextgen.jaxrs.api.resources.PromotersManagerRs;
import dz.ummto.ansejnextgen.jaxrs.api.resources.RegistrationRs;
import dz.ummto.ansejnextgen.jaxrs.exception.AccessDeniedExceptionMapper;
import dz.ummto.ansejnextgen.jaxrs.exception.AuthenticationExceptionMapper;
import dz.ummto.ansejnextgen.jaxrs.exception.AuthenticationTokenRefreshmentExceptionMapper;
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

		register(RegistrationRs.class);
		register(AuthenticationRS.class);
		register(PromotersManagerRs.class);

		register(AuthenticationFilter.class);
		register(AuthorizationFilter.class);

		register(AccessDeniedExceptionMapper.class);
		register(AuthenticationExceptionMapper.class);
		register(AuthenticationTokenRefreshmentExceptionMapper.class);

		register(ObjectMapperProvider.class);
	}

	private void configSwagger() {
		register(ApiListingResource.class);
		BeanConfig beanConf = new BeanConfig();
		beanConf.setVersion("");
		beanConf.setSchemes(new String[] {"http"});
		beanConf.setHost("localhost:8089");
		beanConf.setBasePath("/");
		beanConf.setResourcePackage("dz.ummto.ansejnextgen.jaxrs.api.resources");
		beanConf.setPrettyPrint(true);
		beanConf.setScan(true);
	}

	public JaxRsApp() {
		configSwagger();
		registerEndPoints();
	}

}
