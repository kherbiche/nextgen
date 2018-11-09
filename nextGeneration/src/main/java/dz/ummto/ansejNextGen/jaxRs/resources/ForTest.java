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

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;
import dz.ummto.ansejNextGen.jpa.TypeAddress;
import dz.ummto.ansejNextGen.jpa.dao.DaoFactory;
import dz.ummto.ansejNextGen.jpa.dao.IDao;
import dz.ummto.ansejNextGen.jpa.entities.Address;
import dz.ummto.ansejNextGen.jpa.entities.EmbeddedAddress;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;
import dz.ummto.ansejNextGen.jpa.entities.PromoterId;

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
		loggerr.info("-- ForTest threadName: " + Thread.currentThread().getName() + " threadId: "
				+ Thread.currentThread().getId());
		new Thread(new Runnable() {
			public void run() {
				IDao<PromoterId, Promoter> pDao = DaoFactory.getPromoterDao();
				try {
					loggerr.info("--- Processing");
					loggerr.info("-- ForTest->Runnable threadName: " + Thread.currentThread().getName() + " threadId: "
							+ Thread.currentThread().getId());
					Promoter promo = new Promoter();
					PromoterId proId = new PromoterId();
					EmbeddedAddress birthAddress = new EmbeddedAddress();
					Address residence = new Address();
					EmbeddedAddress embeddedAddress = new EmbeddedAddress();

					proId.setFirstName(obj.get(0));
					proId.setLastName(obj.get(1));
					proId.setBirthDate(obj.get(2));
					promo.setPromoterId(proId);

					promo.setGender(obj.get(3).equals("Man") ? Gender.M : Gender.F);
					promo.setFather(obj.get(4));
					promo.setMother(obj.get(5));
					promo.setBirthCertNum(obj.get(6));

					birthAddress.setCity(obj.get(7));
					birthAddress.setZipCode(Integer.parseInt(obj.get(8)));
					birthAddress.setCountry(obj.get(9));
					promo.setBirthPlace(birthAddress);

					residence.setNumAddress(Integer.parseInt(obj.get(10)));
					residence.setTypeAddress(TypeAddress.valueOf(obj.get(11)));
					residence.setStreetName(obj.get(12));
					embeddedAddress.setCity(obj.get(13));
					embeddedAddress.setZipCode(Integer.parseInt(obj.get(14)));
					embeddedAddress.setCountry(obj.get(15));
					residence.setEmbeddedAddress(embeddedAddress);
					promo.setResidence(residence);

					promo.setEmail(obj.get(16));
					promo.setPhone(Integer.parseInt(obj.get(17)));
					promo.setFax(Integer.parseInt(obj.get(18)));
					promo.setFamiSitu(obj.get(19));
					promo.setAnemCard(Integer.parseInt(obj.get(20)));
					promo.setEducLevel(EducLevel.OTH); /* impl TODO */
					promo.setExperience(obj.get(22));
					promo.setDegree(obj.get(23));

					pDao.save(promo);
					asyncResponse.resume("TODO");
				} finally {
					pDao.closeResource();
				}
			}
		}).start();
	}

}
