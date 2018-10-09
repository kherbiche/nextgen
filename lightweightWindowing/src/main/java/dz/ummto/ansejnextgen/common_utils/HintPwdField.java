/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.common_utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

/**
 * The <code>HintPwdField</code> class represents custom redefinition of
 * {@link javax.swing.JPasswordField} Swing component.
 * <p>
 * The class <code>HintPwdField</code> includes @Override methods.
 * <p>
 * This implementation creates an edit password field.
 * If the <code>JPasswordField</code> has focus the echo character disappears and just
 * reappears if the user leaves the <code>JTextField</code>.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class HintPwdField extends JPasswordField implements FocusListener {

	private boolean showing;

	public HintPwdField() {
		super("pass word", SwingConstants.CENTER);
		this.showing = true;
		this.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 11));
		this.setForeground(Color.gray);
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getPassword().length == 0) {
			super.setText("");
			this.setForeground(Color.BLACK);
			showing = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getPassword().length == 0) {
			super.setText("pass word");
			this.setForeground(Color.gray);
			showing = true;
		}
	}

	@Override
	public char[] getPassword() {
		return showing ? new char[] {} : super.getPassword();
	}

}
