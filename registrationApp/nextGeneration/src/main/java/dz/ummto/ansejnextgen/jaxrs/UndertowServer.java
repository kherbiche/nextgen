/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs;

import io.undertow.servlet.api.ListenerInfo;
import io.undertow.servlet.api.ServletInfo;
import jakarta.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.glassfish.jersey.servlet.ServletContainer;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

//import static io.undertow.servlet.Servlets.listener;
//
/**
 * The <code>UndertowServer</code> class represents the Starter.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

public class UndertowServer {

	private static final Log logger = LogFactory.getLog(UndertowServer.class);

	private static Undertow server;
	private static DeploymentManager deploymentManager;
	private static final int DEFAULT_PORT = 8089;

	public static void startServer(int port) {

		logger.info("-- Starting Undertow ...");

//		// 1. Listener Weld pour démarrer le conteneur CDI dans Undertow
//		ListenerInfo weldListener = Servlets.listener(Listener.class);
//
//		// 2. Servlet Jersey configuré via init-param (permet à Weld de gérer le cycle de vie)
//		ServletInfo jerseyServlet = Servlets.servlet("JerseyServlet", ServletContainer.class)
//				.addInitParam("jakarta.ws.rs.Application", JaxRsApp.class.getName())
//				.addMapping("/*")
//				.setLoadOnStartup(1);

		DeploymentInfo servletBuilder = Servlets.deployment();
		servletBuilder.setClassLoader(UndertowServer.class.getClassLoader());
		servletBuilder.setContextPath("/");
		//servletBuilder.addListeners(Servlets.listener(Listener.class));
		servletBuilder.setResourceManager(new ClassPathResourceManager(UndertowServer.class.getClassLoader()));
		servletBuilder.setDeploymentName("nextGeneration-0.0.1-RELEASE.jar");
		servletBuilder.addServlets(Servlets.servlet("jerseyServlet", ServletContainer.class)
				.setLoadOnStartup(1)
				.addInitParam("jakarta.ws.rs.core.Application", JaxRsApp.class.getName())
				.addInitParam("jersey.config.server.wadl.disableWadl", "true")
				.addInitParam("jersey.config.useVirtualThreads", "false")
				.addMapping("/*")
				.setAsyncSupported(true));

		deploymentManager = Servlets.defaultContainer().addDeployment(servletBuilder);
		deploymentManager.deploy();

		try {
		//PathHandler path = Handlers.path();
		server = Undertow.builder().addHttpListener(port, "0.0.0.0").setHandler(deploymentManager.start()).build();
		server.start();

			//path.addPrefixPath("/", deploymentManager.start());
		} catch (ServletException e) {
			logger.info("-- Undertow DeploymentManager ServletException", e);
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
		System.setProperty("jersey.config.useVirtualThreads", "false");
		startServer(DEFAULT_PORT);
	}

}
