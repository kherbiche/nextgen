/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs;

import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.listener;

import java.net.URI;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.undertow.api.UndertowWebArchive;
import org.jboss.weld.environment.servlet.Listener;
import org.junit.Before;

import dz.ummto.ansejnextgen.jaxrs.api.AuthenticationToken;
import io.undertow.servlet.Servlets;

/**
 * The <code>ArquillianTest</code> class represents simple Base Arquillian test
 * class.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public abstract class ArquillianTest {

	protected static final Log logger = LogFactory.getLog(ArquillianTest.class);

	@ArquillianResource
	protected URI uri;

	protected Client client;

	@Deployment(testable = false)
	public static Archive<WebArchive> createDeployment() {

		return ShrinkWrap.create(UndertowWebArchive.class)
				.from(deployment()
						.setClassLoader(Application.class.getClassLoader())
						.setContextPath("/")
						.addListeners(listener(Listener.class))
						.addServlets(Servlets
								.servlet("jerseyServlet", ServletContainer.class)
									.setLoadOnStartup(1)
									.addInitParam("javax.ws.rs.Application", JaxRsApp.class.getName())
									.setAsyncSupported(true)
									.addMapping("/*"))
						.setDeploymentName("nextGeneration-0.0.1-RELEASE.jar"));
	}

	@Before
	public void beforeTest() throws Exception {
		this.client = ClientBuilder.newClient();
	}

	protected String getTokenForAdmin() {

		AuthenticationToken authenticationToken = client.target(uri).path("/rest").path("/auth").request().post(
				Entity.entity(Arrays.asList("lyes", "lyes"), MediaType.APPLICATION_JSON), AuthenticationToken.class);
		return authenticationToken.getToken();
	}

	protected String getTokenForUser() {

		AuthenticationToken authenticationToken = client.target(uri).path("/rest").path("/auth").request().post(
				Entity.entity(Arrays.asList("kher", "kher"), MediaType.APPLICATION_JSON), AuthenticationToken.class);
		return authenticationToken.getToken();
	}

	protected String composeAuthorizationHeader(String authenticationToken) {
		return "Yugarten" + " " + authenticationToken;
	}

}
