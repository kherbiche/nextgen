/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Address implements Serializable {

	/*
	 * @see <a href=
	 * "https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/"
	 * >link</a>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NUM_ADDRESS", nullable = false, length = 4)
	private int numAddress;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ADDRESS", nullable = false, length = 6)
	private TypeAddress typeAddress;

	@Column(name = "STREET_NAME", nullable = false, length = 50)
	private String streetName;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "CITY"), name = "city"),
			@AttributeOverride(name = "zipCode", column = @Column(name = "ZIP_CODE")),
			@AttributeOverride(name = "country", column = @Column(name = "COUNTRY")) })
	private EmbeddedAddress embeddedAddress;

	public Address() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
