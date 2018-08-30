package dz.ummto.ansejNextGen.jaxRs.resources;

import java.io.IOException;
import java.util.List;

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
	public void newMail(@Suspended final AsyncResponse asyncResponse, List<String> obj) throws IOException {
		loggerr.info("--- URI: /rest/test");
		loggerr.info("--- POST Content 0: " + obj.get(0));
		loggerr.info("--- POST Content 1: " + obj.get(1));
		loggerr.info("--- POST Content 2: " + obj.get(2));
		new Thread(new Runnable() {
			public void run() {
				loggerr.info("--- Processing");
				asyncResponse.resume("TODO");
			}
		}).start();
	}

}
