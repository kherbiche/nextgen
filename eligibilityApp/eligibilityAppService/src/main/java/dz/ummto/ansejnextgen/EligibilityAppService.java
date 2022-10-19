/*
 * Copyright 2008, 2022 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SpringBootApplication
public class EligibilityAppService {
	
	protected static final Log logger = LogFactory.getLog(EligibilityAppService.class);
	
	public static void main(String[] args){
		SpringApplication.run(EligibilityAppService.class, args);
	}
}
