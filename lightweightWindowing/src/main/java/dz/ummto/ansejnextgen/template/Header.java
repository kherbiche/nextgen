/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.IconEnum;

/**
 * The <code>Header</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Header {

	private static final Log loggerrr = LogFactory.getLog(Header.class);
	private JPanel headerJpanel;

	public Header() {
		Runnable code = new Runnable() {
			public void run() {
				jbInit();
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			loggerrr.info("--- Header.jbInit: In the EDT");
			code.run();
		} else {
			loggerrr.info("--- Header.jbInit: Out of EDT");
			SwingUtilities.invokeLater(code);
		}
	}

	private void jbInit() {

		JLabel jLabAnsej2 = new JLabel("ANSEJ",
				new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.RLABEL + ".png")).getImage()
						.getScaledInstance(30, 25, Image.SCALE_SMOOTH)),
				SwingConstants.CENTER);
		jLabAnsej2.setBackground(Color.orange);
		jLabAnsej2.setFont(new java.awt.Font(Font.DIALOG, 1, 16));
		jLabAnsej2.setForeground(Color.blue);
		jLabAnsej2.setOpaque(true);
		jLabAnsej2.setBounds(new Rectangle(0, 2, 93, 27));
		JLabel jLabAnsej1 = new JLabel("ANSEJ",
				new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.RLABEL + ".png")).getImage()
						.getScaledInstance(30, 25, Image.SCALE_SMOOTH)),
				SwingConstants.CENTER);
		jLabAnsej1.setBounds(new Rectangle(751, 2, 93, 27));
		jLabAnsej1.setOpaque(true);
		jLabAnsej1.setForeground(Color.blue);
		jLabAnsej1.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabAnsej1.setBackground(Color.orange);

		JLabel jLabSpace = new JLabel("Accompanying counselor space", SwingConstants.CENTER);
		jLabSpace.setBackground(Color.lightGray);
		jLabSpace.setFont(new java.awt.Font(Font.DIALOG, 3, 17));
		jLabSpace.setOpaque(true);
		jLabSpace.setBounds(new Rectangle(101, 5, 642, 21));
		jLabSpace.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		JLabel jLabContext = new JLabel("Follow-up of promoters", SwingConstants.RIGHT);
		jLabContext.setBackground(Color.orange);
		jLabContext.setFont(new java.awt.Font(Font.SANS_SERIF, 3, 13));
		jLabContext.setOpaque(true);
		jLabContext.setRequestFocusEnabled(true);
		jLabContext.setIconTextGap(4);
		jLabContext.setBounds(new Rectangle(0, 32, 844, 22));
		JLabel jLabStage = new JLabel("Promoter Registration");
		jLabStage.setBackground(Color.LIGHT_GRAY);
		jLabStage.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jLabStage.setOpaque(true);
		jLabStage.setRequestFocusEnabled(true);
		jLabStage.setVerifyInputWhenFocusTarget(true);
		jLabStage.setBounds(new Rectangle(2, 54, 840, 21));

		headerJpanel = new JPanel();
		headerJpanel.setLayout(null);
		headerJpanel.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		headerJpanel.add(jLabAnsej2, null);
		headerJpanel.add(jLabAnsej1, null);
		headerJpanel.add(jLabSpace, null);
		headerJpanel.add(jLabContext, null);
		headerJpanel.add(jLabStage, null);
	}

	public JPanel getJPanel() {
		return headerJpanel;
	}

}
