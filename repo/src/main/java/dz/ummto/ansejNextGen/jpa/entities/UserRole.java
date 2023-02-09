/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dz.ummto.ansejNextGen.jpa.Role;

/**
 * The <code>UserRole</code> class represents the Roles of User Entity
 * 
 * @see <a href=
 *      "https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/">Best
 *      Way to map OneToMany</a>
 * @see <a href=
 *      "https://www.thoughts-on-java.org/best-practices-many-one-one-many-associations-mappings/">Best
 *      Practices for Many-To-One and One-To-Many Association Mappings</a>
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Entity
@Table(name = "USERROLE")
@Cacheable(true)
public class UserRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private Role role;

	/**
	 * Mandatory Empty @constructor for JPA
	 */
	public UserRole() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserRole))
			return false;
		return id != null && id.equals(((UserRole) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}
}
