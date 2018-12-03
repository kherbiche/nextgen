/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

/**
 * The <code>IDelegate</code> Interface represents delegate pattern interface
 * 
 * <p>
 * Related class for delegate pattern {@link RegisterLookUp}, {@link Client},
 * {@link RegisterDelegate}, {@link RegisterOne}, {@link IDelegate}
 * 
 * @see <a href=
 *      "link">https://www.geeksforgeeks.org/business-delegate-pattern/</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
interface IDelegate {

	final String BASE_URI = "http://localhost:8089";

	static URI getBaseURI() {
		return UriBuilder.fromUri(BASE_URI).build();
	}

	Object register(Object... args);

}
