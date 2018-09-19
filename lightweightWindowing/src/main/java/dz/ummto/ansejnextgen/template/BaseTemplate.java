/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import dz.ummto.ansejnextgen.IconEnum;

/**
 * The <code>BaseTemplate</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class BaseTemplate {

	private JFrame base;

	public BaseTemplate() {
		jbInit();
	}

	private void jbInit() {

		base = new JFrame();
		base.setSize(844, 556);
		base.setResizable(false);
		base.setLocationRelativeTo(null);
		base.getContentPane().setLayout(null);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenuFile = new JMenu("File");
		JMenu jMenuHelp = new JMenu("Help");
		JMenuItem jMenuFileExit = new JMenuItem("Exit");
		JMenuItem jMenuHelpAbout = new JMenuItem("About");
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuHelp);
		base.setJMenuBar(jMenuBar);
		base.setIconImage(new ImageIcon(getClass().getResource("/" + IconEnum.FRAME + ".png")).getImage());
	}

	public void setHeader(JPanel header) {
		header.setBounds(new Rectangle(0, 1, 844, 70));
		base.getContentPane().add(header, null);
	}

	public void setFooter(JPanel footer) {
		footer.setBounds(new Rectangle(0, 513, 844, 20));
		base.getContentPane().add(footer, null);
	}

	public void setMenu(JPanel menu) {
		menu.setBounds(new Rectangle(0, 73, 135, 430));
		base.getContentPane().add(menu, null);
	}

	public void setBody(JPanel body) {
		body.setBounds(new Rectangle(140, 73, 704, 438));
		base.getContentPane().add(body, null);
	}

	public JFrame getJFrame() {
		return base;
	}

}
