/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The <code>Promoter</code> class represents the User Entity
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Entity
@Table(name = "USER")
public class User {

	private String userName;
	private String passWord;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	@SuppressWarnings("unused")
	private User() {
	}

	public User(String userName, String passWord, boolean enabled) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.enabled = enabled;
	}
}
