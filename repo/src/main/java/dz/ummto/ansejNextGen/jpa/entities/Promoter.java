/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;

/**
 * The <code>Promoter</code> class represents the abstraction of the project
 * instigator
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "PROMOTER")
public class Promoter {

	private String lastName;
	private String firstName;
	private Gender gender;
	private String father;
	private String mother;
	private String birthDate;
	private String birthCertNum;
	private Address birthPlace;
	private Address residence;
	private String email;
	private int phone;
	private int anemCard;
	private EducLevel educLevel;
	private String degree;

}
