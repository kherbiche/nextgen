/*
 * Copyright 2008, 2022 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	 * curl -X POST localhost:8088/rest/eligibility -H "Content-Type:application/json" -d '{"firstName":"foo","lastName":"bar","birthDate":"01/"}'
	 * 
	 */
	@PostMapping("/eligibility")
	public void makeEligible(@RequestBody Map<String, String> eligibilityMap) {
		logger.info("--- URI: /rest/eligibility");
		logger.info("--- POST Content 0: " + eligibilityMap.get("lastName"));
		logger.info("--- POST Content 1: " + eligibilityMap.get("firstName"));
		logger.info("--- POST Content 1: " + eligibilityMap.get("birthDate"));

		IDao<Long, Eligibility> eDao = DaoFactory.getEligibilityDao();
		try {
			Eligibility e = new Eligibility();
			Promoter p = new Promoter();
			PromoterId pid = new PromoterId();
			
			pid.setLastName("kh");
			pid.setFirstName("lys");
			pid.setBirthDate("12/01/1990");
			
			p.setPromoterId(pid);
			
			e.setPromoter(p);
			e.setDecisionDate(eligibilityMap.get("decisionDate"));
			e.setStatus(eligibilityMap.get("status").equals("true") ? true : false);
			e.setComment(eligibilityMap.get("comment"));
			
			eDao.save(e);
		} finally {
			eDao.closeResource();
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json")
	public String[] test() {
		logger.info("-- uri = /test");
		String[] str = {"ca","marche","bien"};
		return str;
	}
}
