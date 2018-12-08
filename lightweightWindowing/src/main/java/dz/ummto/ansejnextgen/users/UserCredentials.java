/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.users;

/**
 * The <code>NextGenUser</code> class represents the application's user.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Deprecated
public class UserCredentials {

	private String userName;
	private String passWord;
	//private boolean enabled;
	//private Set<String> userRole = new HashSet<String>(0);

	@SuppressWarnings("unused")
	private UserCredentials() {}

	public UserCredentials(String userName, String passWord/*, boolean enabled*/) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		//this.enabled = enabled;
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

	/*
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<String> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<String> userRole) {
		this.userRole = userRole;
	}
	*/

}
