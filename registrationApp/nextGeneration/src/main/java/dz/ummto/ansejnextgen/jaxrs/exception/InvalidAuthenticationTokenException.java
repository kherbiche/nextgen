/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.exception;

/**
 * The <code>InvalidAuthenticationTokenException</code> Thrown if an
 * authentication token is invalid.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class InvalidAuthenticationTokenException extends RuntimeException {

	public InvalidAuthenticationTokenException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
