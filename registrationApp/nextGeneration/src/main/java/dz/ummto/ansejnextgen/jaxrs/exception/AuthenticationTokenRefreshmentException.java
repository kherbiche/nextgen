/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

/**
 * The <code>AuthenticationTokenRefreshmentException</code> Thrown if an
 * authentication token cannot be refreshed.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class AuthenticationTokenRefreshmentException extends RuntimeException {

	public AuthenticationTokenRefreshmentException(String msg) {
		super(msg);
	}

	public AuthenticationTokenRefreshmentException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
