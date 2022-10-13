package dz.ummto.ansejNextGen.jpa.entities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;
import dz.ummto.ansejNextGen.jpa.Role;
import dz.ummto.ansejNextGen.jpa.TypeAddress;
import dz.ummto.ansejNextGen.jpa.dao.DaoFactory;
import dz.ummto.ansejNextGen.jpa.dao.IDao;

public class ProgTest {

	private static final Log logger = LogFactory.getLog(ProgTest.class);

	public static void main(String[] args) {

		logger.info("-- Main threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());

		EmbeddedAddress embAdd = new EmbeddedAddress("Nanterre", 92000, "Fr");
		Address add = new Address();
		add.setNumAddress(1);
		add.setStreetName("SyphaxStreet");
		add.setTypeAddress(TypeAddress.STREET);
		add.setEmbeddedAddress(embAdd);

		Promoter promo = new Promoter();
		PromoterId proId = new PromoterId("Ali", "kherbiche", "01/01/2018");
		EmbeddedAddress birth = new EmbeddedAddress("LNI", 15000, "Fr");
		promo.setPromoterId(proId);
		promo.setGender(Gender.M);
		promo.setFather("kherbiche");
		promo.setMother("berkiche");
		/* Exception when #BirthCertNum is too long ie 12SLNITODZ15 is unacceptable */
		promo.setBirthCertNum("12SLNITO");
		promo.setBirthPlace(birth);
		promo.setResidence(add);
		promo.setEmail("kerbiche@gmail.com");
		promo.setPhone(0033600000000);
		promo.setAnemCard(1515151515);
		promo.setEducLevel(EducLevel.UNIV);
		promo.setDegree("ingineer");
		promo.setExperience("expert");
		promo.setFamiSitu("celib");

		PromoterId proId2 = new PromoterId("lyes", "kherbiche", "01/01/2018");
		Promoter promo2 = new Promoter();
		promo2.setPromoterId(proId2);

		IDao<PromoterId, Promoter> pDao = DaoFactory.getPromoterDao();
		IDao<Long, Address> addrDao = DaoFactory.getAddressDao();

		pDao.save(promo);
		Promoter found = pDao.findById(proId2);
		if (found != null) {
			logger.info("-- Promoter founded");
			logger.info("-- class: " + found.getClass());
			logger.info(found.getEmail() != null ? found.getEmail() : "email null");
		} else
			logger.info("promoter not found");

		pDao.remove(promo);
		addrDao.remove(add);


		User user = new User();
		user.setUserName("lyess");
		user.setPassWord("pass1$word?");
		user.setEnabled(true);
		UserRole ur1 = new UserRole();
		ur1.setRole(Role.ROLE_COUNSELOR);
		ur1.setUser(user);
		UserRole ur2 = new UserRole();
		ur2.setRole(Role.ROLE_ADMIN);
		ur2.setUser(user);
		user.addUserRole(ur1);
		user.addUserRole(ur2);

		IDao<String, User> uDao = DaoFactory.getUserDao();
		//IDao<Long, UserRole> urDao = DaoFactory.getUserRoleDao();
		uDao.save(user);
		//urDao.save(ur1);
		//urDao.save(ur2);
		logger.info("-- Main thread name: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		
		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		Eligibility e = new Eligibility();
		Promoter p = new Promoter();
		PromoterId pid = new PromoterId();
		pid.setLastName("kh");
		pid.setFirstName("lys");
		pid.setBirthDate("12/01/1990");
		p.setPromoterId(pid);
		e.setPromoter(p);
		e.setDecisionDate("13/10/2022");
		e.setStatus(true);
		e.setComment("comment");
		eDao.save(e);
		logger.info("-- Eligibility saved");
	}

}
