/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import dz.ummto.ansejNextGen.jpa.EducLevel;
import dz.ummto.ansejNextGen.jpa.Gender;
import dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao;

/**
 * The <code>Promoter</code> class represents the abstraction of the project
 * instigator
 * 
 * @see <a href=
 *      "https://stackoverflow.com/questions/35082881/unable-to-map-2-address-in-employee-class-in-hibernate">link1</a>
 * @see <a href=
 *      "http://in.relation.to/2015/07/23/advanced-embeddable-mappings/">link2</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "PROMOTER")
@NamedQueries({ @NamedQuery(name = AbstractJpaDao.FIND_ALL, query = "select p from Promoter p") })
public class Promoter {

	@EmbeddedId
	private PromoterId promoterId;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = false, length = 6)
	private Gender gender;

	@Column(name = "FATHER", nullable = false, length = 20)
	private String father;

	@Column(name = "MOTHER", nullable = false, length = 20)
	private String mother;

	@Column(name = "BIRTH_CERT_NUM", nullable = false, length = 10)
	private String birthCertNum;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "BIRTH_CITY"), name = "city"),
			@AttributeOverride(name = "zipCode", column = @Column(name = "BIRTH_ZIP_CODE")),
			@AttributeOverride(name = "country", column = @Column(name = "BIRTH_COUNTRY")) })
	private EmbeddedAddress birthPlace;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "FK_ADDRESS")
	private Address residence;

	@Column(name = "EMAIL", nullable = false, length = 60)
	private String email;

	@Column(name = "PHONE", nullable = false, length = 13)
	private int phone;

	@Column(name = "FAX", nullable = true, length = 13)
	private int fax;

	@Column(name = "FAMILYSITUATION", nullable = false, length = 6)
	private String famiSitu;

	@Column(name = "ANEM_CARD", nullable = false, length = 15)
	private int anemCard;

	@Enumerated(EnumType.STRING)
	@Column(name = "EDUC_LEVEL", nullable = false, length = 19)
	private EducLevel educLevel;

	@Column(name = "EXPERIENCE", nullable = false, length = 30)
	private String experience;

	@Column(name = "DEGREE", nullable = false, length = 50)
	private String degree;

	/**
	 * Mandatory Empty @constructor for JPA
	 */
	public Promoter() {
	}

	/**
	 * Optional @constructor with fields
	 */
	public Promoter(PromoterId promoterId, Gender gender, String father, String mother, String birthCertNum,
			EmbeddedAddress birthPlace, Address residence, String email, int phone, int anemCard, EducLevel educLevel,
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

	public EmbeddedAddress getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(EmbeddedAddress birthPlace) {
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

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getFamiSitu() {
		return famiSitu;
	}

	public void setFamiSitu(String famiSitu) {
		this.famiSitu = famiSitu;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
