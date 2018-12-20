/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import dz.ummto.ansejnextgen.IconEnum;
import dz.ummto.ansejnextgen.gui.login.Login;
import dz.ummto.ansejnextgen.gui.promoter.PromotersManager;
import dz.ummto.ansejnextgen.gui.registration.Inscription;

/**
 * The <code>Renderer</code> class renders views for users.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Renderer {

	private final static BaseTemplate baseTemplate = new BaseTemplate("medium");
	private static Menu menu = new Menu();
	static {
		baseTemplate.setHeader(new Header().getJPanel());
		baseTemplate.setFooter(new Footer().getJPanel());
		baseTemplate.setMenu(menu.getJPanel());
	}

	@SuppressWarnings("serial")
	public static JFrame render(String view) {
		switch (view) {
		case "login":
			baseTemplate.setBody(new Login() {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(new ImageIcon(getClass().getResource("/" + IconEnum.DZAIR + ".png")).getImage(), 0, 0,
							704, 438, this);
				}
			});
			break;
		case "inscription":
			baseTemplate.setBody(new Inscription(null) {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(new ImageIcon(getClass().getResource("/" + IconEnum.DZAIR + ".png")).getImage(), 0, 0,
							704, 438, this);
				}
			});
			break;
		case "manager":
			baseTemplate.setBody(new PromotersManager() {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(new ImageIcon(getClass().getResource("/" + IconEnum.DZAIR + ".png")).getImage(), 0, 0,
							704, 438, this);
				}
			});
			break;
		case "":
			break;
		}
		return baseTemplate.getJFrame();
	}

	public static Menu getMenu() {
		return menu;
	}
}
