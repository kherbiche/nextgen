package dz.ummto.ansejNextGen.jaxRs.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/rest")
public class ForTest {

	private static final Log loggerr = LogFactory.getLog(ForTest.class);

	@Path("/test")
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newMail(@Suspended final AsyncResponse asyncResponse, String obj) throws IOException {
		loggerr.info("--- URI: /rest/test");
		loggerr.info("--- POST Content: " + obj);
		new Thread(new Runnable() {
			public void run() {
				loggerr.info("--- Processing");
				asyncResponse.resume("TODO");
			}
		}).start();
	}

}
