package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Header {

	private static final Log logger = LogFactory.getLog(Header.class);
	private JPanel headerJpanel;

	public Header() {
		jbInit();
	}

	private void jbInit() {

		logger.info("--- Header jbInit");
		JLabel jLabAnsej2 = new JLabel("ANSEJ", SwingConstants.CENTER);
		jLabAnsej2.setBackground(Color.orange);
		jLabAnsej2.setFont(new java.awt.Font(Font.DIALOG, 1, 16));
		jLabAnsej2.setForeground(Color.blue);
		jLabAnsej2.setOpaque(true);
		jLabAnsej2.setBounds(new Rectangle(0, 2, 93, 27));
		JLabel jLabAnsej1 = new JLabel("ANSEJ", SwingConstants.CENTER);
		jLabAnsej1.setBounds(new Rectangle(611, 2, 93, 27));
		jLabAnsej1.setOpaque(true);
		jLabAnsej1.setForeground(Color.blue);
		jLabAnsej1.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabAnsej1.setBackground(Color.orange);

		JLabel jLabSpace = new JLabel("Accompanying counselor space", SwingConstants.CENTER);
		jLabSpace.setBackground(Color.lightGray);
		jLabSpace.setFont(new java.awt.Font(Font.DIALOG, 3, 17));
		jLabSpace.setOpaque(true);
		jLabSpace.setBounds(new Rectangle(101, 5, 500, 21));
		jLabSpace.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		JLabel jLabContext = new JLabel("Follow-up of promoters", SwingConstants.RIGHT);
		jLabContext.setBackground(Color.orange);
		jLabContext.setFont(new java.awt.Font(Font.SANS_SERIF, 3, 13));
		jLabContext.setOpaque(true);
		jLabContext.setRequestFocusEnabled(true);
		jLabContext.setIconTextGap(4);
		jLabContext.setBounds(new Rectangle(0, 32, 704, 22));
		JLabel jLabStage = new JLabel("Promoter Registration");
		jLabStage.setBackground(Color.white);
		jLabStage.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jLabStage.setOpaque(true);
		jLabStage.setRequestFocusEnabled(true);
		jLabStage.setVerifyInputWhenFocusTarget(true);
		jLabStage.setBounds(new Rectangle(2, 54, 700, 21));

		headerJpanel = new JPanel();
		headerJpanel.setLayout(null);
		headerJpanel.setBackground(SystemColor.inactiveCaptionText);
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
