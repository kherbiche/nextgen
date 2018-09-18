/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dz.ummto.ansejnextgen.IconEnum;

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

		JLabel jLabFooter = new JLabel("\u00a9 Ansej 2008-2018",
				new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.FRAME + ".png")).getImage()
						.getScaledInstance(30, 20, Image.SCALE_SMOOTH)),
				SwingConstants.RIGHT);
		jLabFooter.setBackground(Color.orange);
		jLabFooter.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		jLabFooter.setBounds(new Rectangle(0, 0, 840, 20));
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
