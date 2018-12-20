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
