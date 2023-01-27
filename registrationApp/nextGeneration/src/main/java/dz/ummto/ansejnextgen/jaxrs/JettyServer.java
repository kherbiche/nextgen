/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs;
/**
 * The <code>JettyServer</code> class represents 
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Deprecated
public class JettyServer {
/*
	private static final Log loggerr = LogFactory.getLog(JettyServer.class);
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

		ServletContainer jerseyServletContainer = new ServletContainer(resourceConfig);

		ServletHolder jettyServlet = new ServletHolder(jerseyServletContainer);
		jettyServlet.setAsyncSupported(true);
	
		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		context.addServlet(jettyServlet, "/*");
		context.addEventListener(new Listener());

		Server server = new Server(serverPort);	
		server.setHandler(context);
		return server;
	}
	
	
	public static void main(String[] args) throws Exception {
		int serverPort = DEFAULT_PORT;
		if(args.length >= 1) {
			try {
				serverPort = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				loggerr.fatal(e.getMessage());
			}
		}
		new JettyServer(serverPort);	
	}
*/
}
