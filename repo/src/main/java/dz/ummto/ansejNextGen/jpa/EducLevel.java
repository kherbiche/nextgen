/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa;

/**
 * The <code>EducLevel</code> represents promoter's education level enumeration
 * type
 * 
 * @author L KHERBICHE
 * @see Class#getEnumConstants()
 * @see java.util.EnumSet
 * @see java.util.EnumMap
 * @since 0.0.1-RELEASE
 */

public enum EducLevel {

	UNIV("UNIVERSITY"), VOCATRAIN("VOCATIONAL TRAINING"), OTH("OTHER");

	private String educLevel;

	public String educLevel() {
		return educLevel;
	}

	EducLevel(String educLevel) {
		this.educLevel = educLevel;
	}

}
