/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.model;

/**
 * The <code>UserCredentials</code> represents API model for the user
 * credentials.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class UserCredentials {

	private String username;
	private String password;

	/*
	 * @Constructor
	 * Empty Constructor
	 */
	public UserCredentials() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
