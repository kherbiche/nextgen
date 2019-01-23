/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

/**
 * The <code>DataModel</code> class represents the data model for
 * {@link javax.swing.table.AbstractTableModel}.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
/*
 * {"promoterId":{"lastName":"kh","firstName":"lys","birthDate":"12/01/1990"},
 * "gender":"M","father":"sl","mother":"al","birthCertNum":"12019099",
 * "birthPlace":{"city":"lni","zipCode":15550,"country":"Dz"},
 * "residence":{"id":2,"numAddress":111,"typeAddress":"ROAD",
 * "streetName":"massensen road","embeddedAddress":{"city":"otr","zipCode":15550
 * ,"country":"dz"}, "handler":{},"hibernateLazyInitializer":{}},
 * "email":"sith","phone":6666,"fax":9999,"famiSitu":"Single","anemCard":151699,
 * "educLevel":"OTH","experience":"Without","degree":"Miage"}
 */
public class DataModel {

	private String firstname;
	private String lastname;
	private String birthdate;
	private String gender;
	private String father;
	private String mother;
	private String birthCertNum;
	private String bpcity;
	private String bpzipCode;
	private String bpcountry;
	private String numAddress;
	private String typeAddress;
	private String streetName;
	private String city;
	private String zipCode;
	private String country;
	private String email;
	private String phone;
	private String fax;
	private String famiSitu;
	private String anemCard;
	private String educLevel;
	private String experience;
	private String degree;

	public DataModel() {
	}

	public DataModel(String firstname, String lastname, String birthdate, String father, String mother) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.father = father;
		this.mother = mother;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthCertNum() {
		return birthCertNum;
	}

	public void setBirthCertNum(String birthCertNum) {
		this.birthCertNum = birthCertNum;
	}

	public String getBpcity() {
		return bpcity;
	}

	public void setBpcity(String bpcity) {
		this.bpcity = bpcity;
	}

	public String getBpzipCode() {
		return bpzipCode;
	}

	public void setBpzipCode(String bpzipCode) {
		this.bpzipCode = bpzipCode;
	}

	public String getBpcountry() {
		return bpcountry;
	}

	public void setBpcountry(String bpcountry) {
		this.bpcountry = bpcountry;
	}

	public String getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(String numAddress) {
		this.numAddress = numAddress;
	}

	public String getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(String typeAddress) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFamiSitu() {
		return famiSitu;
	}

	public void setFamiSitu(String famiSitu) {
		this.famiSitu = famiSitu;
	}

	public String getAnemCard() {
		return anemCard;
	}

	public void setAnemCard(String anemCard) {
		this.anemCard = anemCard;
	}

	public String getEducLevel() {
		return educLevel;
	}

	public void setEducLevel(String educLevel) {
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

}
