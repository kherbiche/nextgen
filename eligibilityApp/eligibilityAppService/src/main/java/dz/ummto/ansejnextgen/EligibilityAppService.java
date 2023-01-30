/*
 * Copyright 2008, 2022 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SpringBootApplication
public class EligibilityAppService extends SpringBootServletInitializer {
	
	protected static final Log logger = LogFactory.getLog(EligibilityAppService.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder sab) {
		return sab.sources(EligibilityAppService.class);
	}
	
	public static void main(String[] args){
		SpringApplication.run(EligibilityAppService.class, args);
	}
}
