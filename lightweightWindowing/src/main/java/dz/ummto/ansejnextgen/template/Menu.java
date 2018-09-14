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
 * The <code>Menu</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Menu {

	private JPanel menuJpanel;

	public Menu() {
		jbInit();
	}

	private void jbInit() {

		JLabel jLabMenu = new JLabel("Menu", SwingConstants.CENTER);
		jLabMenu.setBackground(Color.blue);
		jLabMenu.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jLabMenu.setBounds(new Rectangle(0, 0, 135, 19));
		jLabMenu.setOpaque(true);
		
		menuJpanel = new JPanel();
		menuJpanel.setLayout(null);
		menuJpanel.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		menuJpanel.setBackground(SystemColor.inactiveCaptionText);
		menuJpanel.add(jLabMenu, null);
	}

	public JPanel getJPanel() {
		return menuJpanel;
	}
}
