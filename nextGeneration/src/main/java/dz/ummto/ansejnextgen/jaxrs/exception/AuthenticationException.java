/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

/**
 * The <code>AuthenticationException</code> represents the throwing when errors
 * occur during the authentication process.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {

	public AuthenticationException(String msg) {
		super(msg);
	}

	public AuthenticationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
