/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dz.ummto.ansejnextgen.IconEnum;
import dz.ummto.ansejnextgen.common_utils.HintJTextField;
import dz.ummto.ansejnextgen.common_utils.HintPwdField;

/**
 * The <code>Login</code> class represents users login page swing window.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class Login extends JPanel implements ActionListener {

	private JButton btn1, btn2;
	private JTextField jTFieldLogin, jTFieldPwd;

	public Login() {
		Runnable code = new Runnable() {
			public void run() {
				jbInit();
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			code.run();
		} else {
			SwingUtilities.invokeLater(code);
		}
	}

	private void jbInit() {

		this.setLayout(null);

		jTFieldLogin = new HintJTextField("Login");
		jTFieldLogin.setBounds(new Rectangle(180, 23, 140, 19));
		jTFieldLogin.setToolTipText("Login");

		jTFieldPwd = new HintPwdField();
		jTFieldPwd.setBounds(new Rectangle(180, 52, 140, 19));
		jTFieldPwd.setToolTipText("Pass word");

		btn1 = new JButton("Login", new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.LOGIN + ".png"))
				.getImage().getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH)));
		btn1.setBackground(Color.ORANGE);
		btn1.setBounds(new Rectangle(300, 120, 100, 22));
		btn1.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		btn1.setForeground(Color.yellow);
		btn1.addActionListener(this);
		btn2 = new JButton("Cancel", new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.CANCEL + ".png"))
				.getImage().getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH)));
		btn2.setBackground(Color.GRAY);
		btn2.setBounds(new Rectangle(100, 120, 100, 22));
		btn2.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		btn2.setForeground(Color.white);
		btn2.addActionListener(this);

		JPanel jPanLogin = new JPanel();
		jPanLogin.setBorder(BorderFactory.createTitledBorder("Login"));
		jPanLogin.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		jPanLogin.setBackground(SystemColor.inactiveCaptionText);
		jPanLogin.setBounds(new Rectangle(90, 144, 500, 150));
		jPanLogin.setLayout(null);
		jPanLogin.add(jTFieldLogin, null);
		jPanLogin.add(jTFieldPwd, null);
		jPanLogin.add(btn1, null);
		jPanLogin.add(btn2, null);

		this.add(jPanLogin, null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
