/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import dz.ummto.ansejNextGen.jpa.TypeAddress;

/**
 * The <code>Address</code> class represents the project instigator
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "ADDRESS")
public class Address {

	private int id;
	private String numAdress;
	@Enumerated(EnumType.STRING)
	private TypeAddress typeAddress;
	private String streetName;
	private String city;
	private String zipCode;
	private String country;

	public Address() {
	}

	public Address(int id, String numAdress, TypeAddress typeAddress, String streetName, String city, String zipCode,
			String country) {
		super();
		this.id = id;
		this.numAdress = numAdress;
		this.typeAddress = typeAddress;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumAdress() {
		return numAdress;
	}

	public void setNumAdress(String numAdress) {
		this.numAdress = numAdress;
	}

	public TypeAddress getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
