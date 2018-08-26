package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;
import dz.ummto.ansejNextGen.jpa.TypeAddress;

public class ProgTest {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ansePersiUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		EmbeddedAddress embAdd = new EmbeddedAddress("Nanterre",92000,"Fr");
		Address add = new Address();
		add.setNumAddress(1);
		add.setStreetName("SyphaxStreet");
		add.setTypeAddress(TypeAddress.STREET);
		add.setEmbeddedAddress(embAdd);

		Promoter promo = new Promoter();
		PromoterId proId = new PromoterId("lyes", "kherbiche", "01/01/2018");
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

		entityManager.persist(add);
		entityManager.persist(promo);

		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();
	}

}
