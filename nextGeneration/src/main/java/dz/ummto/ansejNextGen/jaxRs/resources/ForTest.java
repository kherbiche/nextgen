package dz.ummto.ansejNextGen.jaxRs.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class ForTest {
	
	@Path("/test")
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newMail(@Suspended final AsyncResponse asyncResponse, String obj) throws IOException {
		System.out.println("=== URI: /rest/test");
		System.out.println("=== POST Content: "+obj);
		new Thread(new Runnable() {
			public void run() {
				System.out.println("mail was sent");
                asyncResponse.resume("mail was sent");
			}
		}).start();
	}


}
