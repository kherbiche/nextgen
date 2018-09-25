/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dz.ummto.ansejnextgen.IconEnum;

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

		JLabel jLabMenu = new JLabel("Menu",
				new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.MENU + ".png")).getImage()
						.getScaledInstance(50, 45, Image.SCALE_SMOOTH)),
				SwingConstants.CENTER);
		jLabMenu.setBackground(new Color(214, 42, 252));
		jLabMenu.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jLabMenu.setBounds(new Rectangle(0, 0, 135, 19));
		jLabMenu.setOpaque(true);

		menuJpanel = new JPanel();
		menuJpanel.setLayout(null);
		menuJpanel.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		menuJpanel.setBackground(new Color(224, 217, 168));
		menuJpanel.add(jLabMenu, null);
	}

	public JPanel getJPanel() {
		return menuJpanel;
	}
}
