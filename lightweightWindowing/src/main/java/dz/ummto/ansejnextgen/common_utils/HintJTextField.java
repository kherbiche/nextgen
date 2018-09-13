/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.common_utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The <code>HintJTextField</code> class represents custom redefinition of
 * {@link javax.swing.JTextField} Swing component.
 * <p>
 * The class <code>HintJTextField</code> includes @Override methods.
 * <p>
 * This implementation creates an edit field with some text in the background.
 * If the <code>JTextField</code> has focus the title-text disappears and just
 * reappears if the user leaves the <code>JTextField</code>.
 * 
 * @see <a href="https://stackoverflow.com/a/1739037/4740914">sof</a>
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class HintJTextField extends JTextField implements FocusListener {

	private final String hint;
	private boolean showingHint;

	public HintJTextField(final String hint) {
		super(hint, SwingConstants.CENTER);
		this.hint = hint;
		this.showingHint = true;
		this.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 11));
		this.setForeground(Color.gray);
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			this.setForeground(Color.BLACK);
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			this.setForeground(Color.gray);
			showingHint = true;
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}

}
