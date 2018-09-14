/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.start;

import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.registration.Inscription;
import dz.ummto.ansejnextgen.template.BaseTemplate;
import dz.ummto.ansejnextgen.template.Footer;
import dz.ummto.ansejnextgen.template.Header;
import dz.ummto.ansejnextgen.template.Menu;

/**
 * The <code>Launcher</code> class represents the entry of
 * lightweight client.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Launcher {
	
	private static final Log logger = LogFactory.getLog(Launcher.class);
	
	public static void main(String[] args) {
		Runnable code = new Runnable() {
			public void run() {
				Inscription registration = new Inscription(null);
				//registration.setVisible(true);
				BaseTemplate bt = new BaseTemplate();
				Header header = new Header();
				Footer footer = new Footer();
				Menu menu = new Menu();
				bt.setHeader(header.getJPanel());
				bt.setFooter(footer.getJPanel());
				bt.setMenu(menu.getJPanel());
				bt.setBody(registration);
				bt.getJFrame().setVisible(true);;
			}
		};
		if(SwingUtilities.isEventDispatchThread()) {
			logger.info("--- main: In the EDT");
			code.run();
		} else {
			logger.info("--- main:Out of EDT");
			SwingUtilities.invokeLater(code);
		}
	}
}
