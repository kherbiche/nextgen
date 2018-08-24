/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

	/*
	 * @see <a href=
	 *      "https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/">link</a>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	@Column(name = "NUM_ADDRESS", nullable = false, length = 4)
	private int numAddress;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ADDRESS", nullable = false, length = 6)
	private TypeAddress typeAddress;

	@Column(name = "STREET_NAME", nullable = false, length = 50)
	private String streetName;

	@Embedded
	private EmbeddedAddress embeddedAddress;

	public Address() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(int numAddress) {
		this.numAddress = numAddress;
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

	public EmbeddedAddress getEmbeddedAddress() {
		return embeddedAddress;
	}

	public void setEmbeddedAddress(EmbeddedAddress embeddedAddress) {
		this.embeddedAddress = embeddedAddress;
	}

}
