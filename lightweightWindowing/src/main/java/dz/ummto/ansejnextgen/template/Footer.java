/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The <code>Footer</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Footer {

	private JPanel footerJpanel;

	public Footer() {
		jbInit();
	}

	private void jbInit() {

		JLabel jLabFooter = new JLabel("\u00a9 Ansej 2008-2018", SwingConstants.RIGHT);
		jLabFooter.setBackground(Color.orange);
		jLabFooter.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		jLabFooter.setBounds(new Rectangle(0, 0, 704, 14));
		jLabFooter.setOpaque(true);
		
		footerJpanel = new JPanel();
		footerJpanel.setLayout(null);
		footerJpanel.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		footerJpanel.setBackground(SystemColor.inactiveCaptionText);
		footerJpanel.add(jLabFooter, null);
	}

	public JPanel getJPanel() {
		return footerJpanel;
	}
}
