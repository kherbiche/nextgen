/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The <code>EmbeddedAddress</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Embeddable
public class EmbeddedAddress {

	@Column(name = "CITY", nullable = false, length = 50)
	private String city;

	@Column(name = "ZIP_CODE", nullable = false, length = 5)
	private int zipCode;

	@Column(name = "COUNTRY", nullable = false, length = 50)
	private String country;

	public EmbeddedAddress() {
	}

	public EmbeddedAddress(String city, int zipCode, String country) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
