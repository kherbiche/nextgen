/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import javax.swing.JFrame;

import dz.ummto.ansejnextgen.gui.registration.Inscription;

/**
 * The <code>Renderer</code> class renders views for users.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Renderer {

	private final static BaseTemplate baseTemplate = new BaseTemplate("medium");
	static {
		baseTemplate.setHeader(new Header().getJPanel());
		baseTemplate.setFooter(new Footer().getJPanel());
		baseTemplate.setMenu(new Menu().getJPanel());
	}

	public static JFrame render(String view) {
		switch (view) {
		case "inscription":
			baseTemplate.setBody(new Inscription(null));
			break;
		case "":
			;
			break;
		}
		return baseTemplate.getJFrame();
	}
}
