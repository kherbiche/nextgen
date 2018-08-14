/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jaxRs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
/**
 * The <code>JettyServer</code> class represents 
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class JettyServer {
	
	private static final int DEFAULT_PORT = 8089;
	private int serverPort;
	
	
	
	public JettyServer(int serverPort) throws Exception {
		this.serverPort = serverPort;
		Server server = configureServer();	        
        server.start();
        server.join();
	}	

	
	private Server configureServer() {
		
		ResourceConfig resourceConfig = new JaxRsApp();
		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder sh = new ServletHolder(servletContainer);                
		Server server = new Server(serverPort);		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        context.addServlet(sh, "/*");
		server.setHandler(context);
		return server;
	}
	
	
	public static void main(String[] args) throws Exception {
		int serverPort = DEFAULT_PORT;
		if(args.length >= 1) {
			try {
				serverPort = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		new JettyServer(serverPort);	
}

}
