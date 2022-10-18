/*
 * Copyright 2008, 2022 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import dz.ummto.ansejNextGen.jpa.dao.DaoFactory;
import dz.ummto.ansejNextGen.jpa.dao.IDao;
import dz.ummto.ansejNextGen.jpa.entities.Eligibility;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;
import dz.ummto.ansejNextGen.jpa.entities.PromoterId;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@RestController
@RequestMapping(value = "/rest")
public class Home {
	
	private static final Log logger = LogFactory.getLog(Home.class);

	/**
	 * curl -X POST localhost:8088/rest/eligibility -H "Content-Type:application/json" -d '{"firstName":"first1","lastName":"last1","birthDate":"12/12/1989", "status":"true","decisionDate":"14/10/2022", "comment":"noComment"}'
	 * curl -X POST localhost:8088/rest/eligibility -H "Content-Type:application/json" -d '{"firstName":"first2","lastName":"last2","birthDate":"13/12/1988", "status":"true","decisionDate":"14/10/2022", "comment":"noComment"}'
	 * curl -X POST localhost:8088/rest/eligibility -H "Content-Type:application/json" -d '{"firstName":"first3","lastName":"last3","birthDate":"14/12/1978", "status":"true","decisionDate":"14/10/2022", "comment":"noComment"}'
	 */
	@PostMapping("/eligibility")
	public void makeEligible(@RequestBody Map<String, String> eligibilityMap) {
		logger.info("--- URI: POST: /rest/eligibility");
		logger.info("--- POST Content: " + eligibilityMap.get("lastName"));
		logger.info("--- POST Content: " + eligibilityMap.get("firstName"));
		logger.info("--- POST Content: " + eligibilityMap.get("birthDate"));
		logger.info("--- POST Content: " + eligibilityMap.get("decisionDate"));

		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		try {
			Eligibility e = new Eligibility();
			Promoter p = new Promoter();
			PromoterId pid = new PromoterId();
			
			pid.setLastName(eligibilityMap.get("lastName"));
			pid.setFirstName(eligibilityMap.get("firstName"));
			pid.setBirthDate(eligibilityMap.get("birthDate"));
			
			p.setPromoterId(pid);
			
			e.setPromoter(p);
			//e.setPromoter(DaoFactory.getPromoterDao().findById(pid));
			e.setDecisionDate(eligibilityMap.get("decisionDate"));
			e.setStatus(eligibilityMap.get("status").equals("true") ? true : false);
			e.setComment(eligibilityMap.get("comment"));
			
			eDao.save(e);
		} finally {
			eDao.closeResource();
		}
	}

	/**
	 * curl localhost:8088/rest/eligibility/1
	 */
	@GetMapping("/eligibility/{id}")
	public Eligibility getEligibilById(@PathVariable("id") Long id) {
		logger.info("--- URI: GET: /rest/eligibility/" + id);

		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		
		return eDao.findById(id);
	}
	
	/**
	 * curl localhost:8088/rest/eligibility/
	 */
	@GetMapping("/eligibility")
	public List<Eligibility> getAllEligibil() {
		logger.info("--- URI: GET: /rest/eligibility");

		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		
		return eDao.findAll();
	}

	/**
	 * curl "localhost:8088/rest/eligibil?firstName=first2&lastName=last2&birthDate=13/12/1988"
	 */
	@GetMapping("/eligibil")
	public List<Eligibility> getAllEligibil(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("birthDate") String birthDate) {
		logger.info("--- URI: GET: /rest/eligibility?firstName="+firstName+"&lastName="+lastName+"&birthDate="+birthDate);

		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		Eligibility e = new Eligibility();
		try {
			Promoter p = new Promoter();
			PromoterId pid = new PromoterId();
			
			pid.setLastName(lastName);
			pid.setFirstName(firstName);
			pid.setBirthDate(birthDate);
			
			p.setPromoterId(pid);
			
			e.setPromoter(p);
		} finally {
			eDao.closeResource();
		}
		
		return eDao.find(e);
	}

	/**
	 * curl -X PATCH http://localhost:8088/rest/eligibility/1 -H "Content-Type:application/json" -d '{"decisionDate":"18/10/2022","status":"false","comment":"UpDate comment"}'
	 */
	@PatchMapping("/eligibility/{id}")
	public void patchEligibility(@PathVariable("id") Long id, @RequestBody Map<String, String> patchMap) {
		logger.info("--- URI: PATCH: /rest/eligibility/" + id);
		
		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		try {
			Eligibility e = eDao.findById(id);

			if(patchMap.containsKey("decisionDate") && !patchMap.get("decisionDate").trim().isEmpty())
				e.setDecisionDate(patchMap.get("decisionDate"));
			if(patchMap.containsKey("comment") && !patchMap.get("comment").trim().isEmpty())
				e.setComment(patchMap.get("comment"));
			if(patchMap.containsKey("status") && !patchMap.get("status").trim().isEmpty())
				e.setStatus(patchMap.get("status").equals("true") ? true : false);
			
			eDao.update(e);
		} finally {
			eDao.closeResource();
		}
	}
	
	/**
	 * curl -X PUT http://localhost:8088/rest/eligibility?firstName=first2&lastName=last2&birthDate=13/12/1988 -d '{"decisionDate":"18/10/2022","status":"false","comment":"UpDated comment"}'
	 */
	@PutMapping("/eligibility")
	public void upDateEligibility(@RequestBody Map<String, String> putMap, 
					@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("birthDate") String birthDate) {
		logger.info("--- URI: PUT: /rest/eligibility/="+firstName+"&lastName="+lastName+"&birthDate="+birthDate);
		
		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		Eligibility e = new Eligibility();
		try {
			Promoter p = new Promoter();
			PromoterId pid = new PromoterId();
			
			pid.setLastName(lastName);
			pid.setFirstName(firstName);
			pid.setBirthDate(birthDate);
			
			p.setPromoterId(pid);
			
			e.setPromoter(p);
			
			e = eDao.find(e).get(0);

			if(putMap.containsKey("decisionDate") && !putMap.get("decisionDate").trim().isEmpty())
				e.setDecisionDate(putMap.get("decisionDate"));
			if(putMap.containsKey("comment") && !putMap.get("comment").trim().isEmpty())
				e.setComment(putMap.get("comment"));
			if(putMap.containsKey("status") && !putMap.get("status").trim().isEmpty())
				e.setStatus(putMap.get("status").equals("true") ? true : false);
			
			eDao.update(e);
		} finally {
			eDao.closeResource();
		}
	}
	
	/**
	 * curl localhost:8088/rest/test
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json")
	public String[] test() {
		logger.info("-- uri = /test");
		String[] str = {"ca","marche","bien"};
		return str;
	}
}
