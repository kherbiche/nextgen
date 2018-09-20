/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registers;

/**
 * The <code>RegisterDelegate</code> class encapsulate the service look up for
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
public class RegisterDelegate {

	private RegisterLookUp lookUp = new RegisterLookUp();
	private IDelegate delegate;
	private String registerType;

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	protected void doTask(Object... args) {
		delegate = lookUp.getRegister(registerType);
		delegate.register(args);
	}
}
