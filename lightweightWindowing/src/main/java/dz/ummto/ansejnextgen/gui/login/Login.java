/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.IconEnum;
import dz.ummto.ansejnextgen.common_utils.HintJTextField;
import dz.ummto.ansejnextgen.common_utils.HintPwdField;
import dz.ummto.ansejnextgen.registers.Client;
import dz.ummto.ansejnextgen.registers.RegisterDelegate;

/**
 * The <code>Login</code> class represents users login page swing window.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class Login extends JPanel implements ActionListener {

	private static final Log logger = LogFactory.getLog(Login.class);

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
		jPanLogin.setBackground(new Color(0, 0, 0, 230));
		jPanLogin.setBounds(new Rectangle(90, 144, 500, 150));
		jPanLogin.setLayout(null);
		// jPanLogin.setOpaque(false);
		jPanLogin.add(jTFieldLogin, null);
		jPanLogin.add(jTFieldPwd, null);
		jPanLogin.add(btn1, null);
		jPanLogin.add(btn2, null);

		/** Check for Empty field to disable/enable button */
		jTFieldPwd.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (((HintPwdField) jTFieldPwd).getPassword().length == 0) {
					btn1.setEnabled(false);
				} else {
					btn1.setEnabled(true);
				}
			}
		});
		jTFieldLogin.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (jTFieldLogin.getText().length() == 0) {
					btn1.setEnabled(false);
				} else {
					btn1.setEnabled(true);
				}
			}
		});
		/** End Checking */

		this.add(jPanLogin, null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton clicked = (JButton) arg0.getSource();
		if (clicked == btn1) {
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					if (SwingUtilities.isEventDispatchThread()) {
						logger.info("-- doInBackground() - in the EDT");
					} else {
						logger.info("-- doInBackground() - !!! EDT");
					}
					RegisterDelegate rd = new RegisterDelegate();
					rd.setRegisterType("Auth");
					Client client = new Client(rd);
					client.doTask(Arrays.asList(jTFieldLogin.getText(), ((HintPwdField) jTFieldPwd).getPassword()));

					return null;
				}

				@Override
				protected void done() {
					/** Erase content of jTFieldPwd in the EDT */
					clearPassword((HintPwdField) jTFieldPwd);
					logger.info("-- done()-jTFieldPwd=" + String.valueOf(((HintPwdField) jTFieldPwd).getPassword()));
					return;
				}
			}.execute();
		}
	}

	private void clearPassword(HintPwdField jpassword) {
		if (SwingUtilities.isEventDispatchThread()) {
			logger.info("-- clearPassword() - in the EDT");
		}
		for (@SuppressWarnings("unused")
		char c : jpassword.getPassword()) {
			c = 'a';
		}
		jpassword.setText("");
	}
}
