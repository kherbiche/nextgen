/*
 * Copyright 2008, 2022 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@RestController
@RequestMapping(value = "/rest")
public class Home{
	
	private static final Log logger = LogFactory.getLog(Home.class);
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json")
	public String[] test() {
		logger.info("-- uri = /test");
		String[] str = {"ca","marche","bien"};
		return str;
	}
}
