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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import org.hibernate.annotations.GenericGenerator;

/**
 * The <code>Eligibility</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "ELIGIBILITY")
public class Eligibility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "FK_LAST_NAME", referencedColumnName="LAST_NAME", insertable = false, updatable = false),
		@JoinColumn(name = "FK_FIRST_NAME", referencedColumnName="FIRST_NAME", insertable = false, updatable = false),
		@JoinColumn(name = "FK_BIRTH_DATE", referencedColumnName="BIRTH_DATE", insertable = false, updatable = false)
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
