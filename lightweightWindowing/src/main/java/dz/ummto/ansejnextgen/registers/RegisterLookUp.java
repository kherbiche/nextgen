/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

/**
 * The <code>RegisterLookUp</code> class represents service look up for
 * application registers
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
class RegisterLookUp {

	protected IDelegate getRegister(String str) {

		if (str.equalsIgnoreCase("One")) {
			return new RegisterOne();
		}
		return null;
	}
}
