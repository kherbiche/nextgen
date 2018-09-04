package dz.ummto.ansejNextGen.jpa.entities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;
import dz.ummto.ansejNextGen.jpa.TypeAddress;
import dz.ummto.ansejNextGen.jpa.dao.impl.PromoterDao;

public class ProgTest {
	
	private static final Log logger = LogFactory.getLog(ProgTest.class);

	public static void main(String[] args) {

		EmbeddedAddress embAdd = new EmbeddedAddress("Nanterre",92000,"Fr");
		Address add = new Address();
		add.setNumAddress(1);
		add.setStreetName("SyphaxStreet");
		add.setTypeAddress(TypeAddress.STREET);
		add.setEmbeddedAddress(embAdd);

		Promoter promo = new Promoter();
		PromoterId proId = new PromoterId("Ali", "kherbiche", "01/01/2018");
		EmbeddedAddress birth = new EmbeddedAddress("LNI",15000,"Fr");
		promo.setPromoterId(proId);
		promo.setGender(Gender.M);
		promo.setFather("kherbiche");
		promo.setMother("berkiche");
		/*Exception when #BirthCertNum is too long ie 12SLNITODZ15 is unacceptable*/
		promo.setBirthCertNum("12SLNITO");
		promo.setBirthPlace(birth);
		promo.setResidence(add);
		promo.setEmail("kerbiche@gmail.com");
		promo.setPhone(0033600000000);
		promo.setAnemCard(1515151515);
		promo.setEducLevel(EducLevel.UNIV);
		promo.setDegree("ingineer");
		
		/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ansePersiUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(add);
		entityManager.persist(promo);

		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();
		*/
		PromoterId proId2 = new PromoterId("lyes", "kherbiche", "01/01/2018");
		Promoter promo2 = new Promoter();
		promo2.setPromoterId(proId2);
		PromoterDao pDao = new PromoterDao();
		pDao.remove(promo2);
		Promoter found=pDao.findById(proId2);
		logger.info("found "+found.getEmail());
	}

}
