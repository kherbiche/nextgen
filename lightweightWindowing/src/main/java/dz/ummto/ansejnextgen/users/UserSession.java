/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.users;

import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * The <code>UserSession</code> class represents the user's session.
 * 
 * <p>
 * <code>UserSession</code> encapsulate information about users
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class UserSession {

	private static final String SECRET = "secret";
	private static final String AUDIENCE = "http://example.org";
	private static final Long CLOCKSKEW = 10L;
	private static final String AUTHORITIES = "authorities";

	private static String token;
	private static String username;
	private static List<String> roles;

	private static UserSession instance = null;


	public static synchronized UserSession getInstance(String token) {
		if(instance == null) {
			instance = new UserSession(token);
		}
		return instance;
	}

	private UserSession() {
	}

	private UserSession(String token) {
		UserSession.token = token;
		parseToken(token);
	}

	public static List<String> getRoles() {
		return roles;
	}

	public static String getUsername() {
		return username;
	}

	public static String getToken() {
		return token;
	}

	@SuppressWarnings("unchecked")
	private void parseToken(String token) {

		Claims claims = Jwts.parser()
				.setSigningKey(SECRET)
				.requireAudience(AUDIENCE)
				.setAllowedClockSkewSeconds(CLOCKSKEW)
				.parseClaimsJws(token)
				.getBody();

		username = claims.getSubject();
		roles = (List<String>)claims.getOrDefault(AUTHORITIES, new ArrayList<>());
	}
}