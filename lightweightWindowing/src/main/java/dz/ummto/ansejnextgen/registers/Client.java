/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

/**
 * The <code>Client</code> class encapsulate the RegisterDelegate
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
public class Client {

	private RegisterDelegate registerDelegate;

	public Client(RegisterDelegate registerDelegate) {
		this.registerDelegate = registerDelegate;
	}

	public Object doTask(Object... args) {
		return this.registerDelegate.doTask(args);
	}

}
