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
 * "residence":{"id":2,"numAddress":111,"typeAddress":"ROAD","streetName":"massensen road","embeddedAddress":{"city":"otr","zipCode":15550,"country":"dz"},
 * "handler":{},"hibernateLazyInitializer":{}},
 * "email":"sith","phone":6666,"fax":9999,"famiSitu":"Single","anemCard":151699,
 * "educLevel":"OTH","experience":"Without","degree":"Miage"}
 */
public class DataModel {

	private String firstname;
	private String lastname;
	private String birthdate;
	private String father;
	private String mother;

	public DataModel(String firstname, String lastname, String birthdate, String father, String mother) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.father = father;
		this.mother = mother;
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
