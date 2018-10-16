/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The <code>User</code> class represents the User Entity
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
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USERNAME", unique = true)
	private String userName;
	@Column(name = "PASSWORD", nullable = false)
	private String passWord;
	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	/**
	 * @constructor must be empty for JPA use
	 */
	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * 
	 * @param userRole
	 *            <p>
	 *            This parent entity, User, features two utility methods (e.g.
	 *            addUserRole and removeUserRole) which are used to synchronize both
	 *            sides of the bidirectional association. You should always provide
	 *            these methods whenever you are working with a bidirectional
	 *            association as, otherwise, you risk <a href=
	 *            "https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/">very
	 *            subtle state propagation issues</a>
	 * 
	 */
	public void addUserRole(UserRole userRole) {
		userRoles.add(userRole);
		userRole.setUser(this);
	}

	/**
	 * 
	 * @param userRole
	 *            <p>
	 *            Another helper method
	 */
	public void removeUserRole(UserRole userRole) {
		userRoles.remove(userRole);
		userRole.setUser(null);
	}
}
