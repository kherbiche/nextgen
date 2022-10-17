/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

import dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao;

/**
 * The <code>Eligibility</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "ELIGIBILITY")
@NamedQueries({ @NamedQuery(name = AbstractJpaDao.FIND_ALL+ "Eligibility", query = "select e from Eligibility e") })
public class Eligibility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;
	/*, insertable = false, updatable = false, nullable = false*/
	/*, cascade = CascadeType.ALL*/
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "FK_LAST_NAME", referencedColumnName="LAST_NAME"),
		@JoinColumn(name = "FK_FIRST_NAME", referencedColumnName="FIRST_NAME"),
		@JoinColumn(name = "FK_BIRTH_DATE", referencedColumnName="BIRTH_DATE")
	})
	private Promoter promoter;
	@Column(name = "DECISION_DATE", length = 10)
	private String decisionDate;
	@Column(name = "STATUS")
	private boolean status;
	@Column(name = "COMMENT")
	private String comment;
	
	/**
	 * Mandatory Empty @constructor for JPA
	 */
	public Eligibility() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Promoter getPromoter() {
		return promoter;
	}
	public void setPromoter(Promoter promoter) {
		this.promoter = promoter;
	}
	
	public String getDecisionDate() {
		return decisionDate;
	}
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
