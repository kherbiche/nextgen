/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	private PromoterId promoterId;
	private Gender gender;
	private String father;
	private String mother;
	private String birthCertNum;
	private Address birthPlace;
	private Address residence;
	private String email;
	private int phone;
	private int anemCard;
	private EducLevel educLevel;
	private String degree;

	public Promoter() {
	}

	public Promoter(PromoterId promoterId, Gender gender, String father, String mother, String birthCertNum,
			Address birthPlace, Address residence, String email, int phone, int anemCard, EducLevel educLevel,
			String degree) {
		super();
		this.promoterId = promoterId;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		this.birthCertNum = birthCertNum;
		this.birthPlace = birthPlace;
		this.residence = residence;
		this.email = email;
		this.phone = phone;
		this.anemCard = anemCard;
		this.educLevel = educLevel;
		this.degree = degree;
	}

	public PromoterId getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(PromoterId promoterId) {
		this.promoterId = promoterId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getBirthCertNum() {
		return birthCertNum;
	}

	public void setBirthCertNum(String birthCertNum) {
		this.birthCertNum = birthCertNum;
	}

	public Address getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Address birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Address getResidence() {
		return residence;
	}

	public void setResidence(Address residence) {
		this.residence = residence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAnemCard() {
		return anemCard;
	}

	public void setAnemCard(int anemCard) {
		this.anemCard = anemCard;
	}

	public EducLevel getEducLevel() {
		return educLevel;
	}

	public void setEducLevel(EducLevel educLevel) {
		this.educLevel = educLevel;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
