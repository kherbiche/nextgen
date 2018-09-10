/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.start;

import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.registration.Inscription;

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
				registration.setVisible(true);
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
