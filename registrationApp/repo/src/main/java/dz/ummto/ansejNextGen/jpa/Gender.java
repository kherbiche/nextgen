/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa;

/**
 * The <code>Gender</code> represents promoter's gender enumeration type
 * 
 * @author L KHERBICHE
 * @see Class#getEnumConstants()
 * @see java.util.EnumSet
 * @see java.util.EnumMap
 * @since 0.0.1-RELEASE
 */

public enum Gender {

	M("MALE"), F("FEMALE");

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	public String gender() {
		return gender;
	}

}
