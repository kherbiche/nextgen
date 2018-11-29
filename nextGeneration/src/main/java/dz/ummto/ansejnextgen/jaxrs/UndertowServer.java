/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs;

import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.servlet.Listener;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import static io.undertow.servlet.Servlets.listener;

import javax.servlet.ServletException;

/**
 * The <code>UndertowServer</code> class represents the Starter.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

public class UndertowServer {

	private static Undertow server;
	private static DeploymentManager deploymentManager;
	private static final int DEFAULT_PORT = 8089;

	public static void startServer(int port) {

		PathHandler path = Handlers.path();
		server = Undertow.builder().addHttpListener(port, "localhost").setHandler(path).build();
		server.start();

		DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(UndertowServer.class.getClassLoader())
				.setContextPath("/").addListeners(listener(Listener.class))
				.setResourceManager(new ClassPathResourceManager(UndertowServer.class.getClassLoader()))
				.addServlets(Servlets.servlet("jerseyServlet", ServletContainer.class).setLoadOnStartup(1)
						.addInitParam("javax.ws.rs.Application", JaxRsApp.class.getName()).addMapping("/*"))
				.setDeploymentName("nextGeneration-0.0.1-RELEASE.jar");

		deploymentManager = Servlets.defaultContainer().addDeployment(servletBuilder);
		deploymentManager.deploy();

		try {
			path.addPrefixPath("/", deploymentManager.start());
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}

	}

	public static void stopServer() {
		if (server == null) {
			throw new IllegalStateException("Server has not been started yet");
		}
		deploymentManager.undeploy();
		server.stop();
	}

	public static void main(String[] args) {
		startServer(DEFAULT_PORT);
	}

}
