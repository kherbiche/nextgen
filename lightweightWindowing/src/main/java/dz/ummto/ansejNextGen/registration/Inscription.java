/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.registration;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The <code>Inscription</code> class represents registration promoters swing
 * window. All promoters must pass by this window class.
 * <p>
 * The class <code>Inscription</code> includes methods for send first
 * information about promoters to the system. The class <code>Inscription</code>
 * use SwingUtilities for handling events on the EDT.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class Inscription extends JFrame implements ActionListener {

	private static final Log logger = LogFactory.getLog(Inscription.class);

	private JFrame t;

	private JMenuBar jMenuBar;
	private JMenu jMenuFile, jMenuHelp;
	private JMenuItem jMenuFileExit, jMenuHelpAbout;
	private JLabel jLabAnsej1, jLabAnsej2, jLabSpace, jLabContext, jLabStage, jLabAddresse, jLabDBirth, jLabLastName,
			jLabCity, jLabelFirstName, jLabTel, jLabFax, jLabEmail, jLabFami, jLabHandic, jLabEducLevel, jLabSpecialty,
			jLabExperience;
	private JPanel jPanIdentiPromoter, jPanCoordinate, jPanPromoProfil;
	private JTextField jTFieldFirstName, jTFieldLastName, jTFieldDBirth, jTFieldCity, jTFieldTel, jTFieldFax,
			jTFieldEmail, jTFieldSpecialty;
	private JTextArea jTextArea = new JTextArea();
	private JComboBox<String> jComboFami, jComBoxDegree, jComBoxExperience;
	private JRadioButton jRadioButton1, jRadioBHandic;
	private ButtonGroup buttonGroup;
	private JButton jButton1, jButton2;

	public Inscription(JFrame t) throws HeadlessException {
		try {
			this.t = t;
			jbInit();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	private void jbInit() throws Exception {

		setTitle("Registration");
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//this.getContentPane().setLayout(null);

		jMenuBar = new JMenuBar();
		jMenuFile = new JMenu("File");
		jMenuHelp = new JMenu("Help");
		jMenuFileExit = new JMenuItem("Exit");
		jMenuFileExit.addActionListener(this);
		jMenuHelpAbout = new JMenuItem("About");
		jMenuHelpAbout.addActionListener(this);
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuHelp);

		jLabAnsej2 = new JLabel("ANSEJ");
		jLabAnsej2.setBackground(Color.orange);
		jLabAnsej2.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabAnsej2.setForeground(Color.blue);
		jLabAnsej2.setOpaque(true);
		jLabAnsej2.setBounds(new Rectangle(-1, 0, 93, 27));
		jLabAnsej1 = new JLabel("ANSEJ");
		jLabAnsej1.setBounds(new Rectangle(607, 0, 93, 27));
		jLabAnsej1.setOpaque(true);
		jLabAnsej1.setForeground(Color.blue);
		jLabAnsej1.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabAnsej1.setBackground(Color.orange);

		jLabSpace = new JLabel("Accompanying counselor space");
		jLabSpace.setBackground(Color.lightGray);
		jLabSpace.setFont(new java.awt.Font("Dialog", 3, 18));
		jLabSpace.setOpaque(true);
		jLabSpace.setBounds(new Rectangle(92, 0, 514, 27));
		jLabContext = new JLabel("Follow-up of promoters");
		jLabContext.setBackground(Color.orange);
		jLabContext.setFont(new java.awt.Font("SansSerif", 3, 13));
		jLabContext.setOpaque(true);
		jLabContext.setRequestFocusEnabled(true);
		jLabContext.setIconTextGap(4);
		jLabContext.setBounds(new Rectangle(-5, 42, 703, 22));
		jLabStage = new JLabel("Promoter Registration");
		jLabStage.setBackground(Color.white);
		jLabStage.setFont(new java.awt.Font("Dialog", 1, 13));
		jLabStage.setOpaque(true);
		jLabStage.setRequestFocusEnabled(true);
		jLabStage.setVerifyInputWhenFocusTarget(true);
		jLabStage.setBounds(new Rectangle(0, 64, 700, 21));

		jLabelFirstName = new JLabel("First Name:");
		jLabelFirstName.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabelFirstName.setBounds(new Rectangle(5, 26, 54, 18));
		jTFieldFirstName = new JTextField();
		jTFieldFirstName.setBackground(SystemColor.activeCaptionText);
		jTFieldFirstName.setBounds(new Rectangle(62, 23, 132, 17));
		jTFieldFirstName.enable(false);

		jLabLastName = new JLabel("Last Name:");
		jLabLastName.setBounds(new Rectangle(209, 25, 66, 18));
		jLabLastName.setFont(new java.awt.Font("Dialog", 1, 11));
		jTFieldLastName = new JTextField();
		jTFieldLastName.setBounds(new Rectangle(282, 22, 132, 18));
		jTFieldLastName.enable(false);

		jLabDBirth = new JLabel("Birth Date:");
		jLabDBirth.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabDBirth.setBounds(new Rectangle(429, 24, 114, 18));
		jTFieldDBirth = new JTextField();
		jTFieldDBirth.setBounds(new Rectangle(555, 22, 132, 19));
		jTFieldDBirth.enable(false);

		jLabAddresse = new JLabel("Address:");
		jLabAddresse.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabAddresse.setBounds(new Rectangle(12, 25, 63, 18));
		jTextArea = new JTextArea();
		jTextArea.setToolTipText("Ansej Ansej");
		jTextArea.setBounds(new Rectangle(100, 23, 210, 43));

		jLabCity = new JLabel("City:");
		jLabCity.setBounds(new Rectangle(341, 23, 84, 18));
		jLabCity.setFont(new java.awt.Font("Dialog", 1, 11));
		jTFieldCity = new JTextField();
		jTFieldCity.setBounds(new Rectangle(454, 23, 152, 19));

		jLabTel = new JLabel("Telephone:");
		jLabTel.setBounds(new Rectangle(16, 91, 77, 18));
		jLabTel.setFont(new java.awt.Font("Dialog", 1, 11));
		jTFieldTel = new JTextField("");
		jTFieldTel.setBounds(new Rectangle(107, 89, 141, 19));

		jLabFax = new JLabel("Fax:");
		jLabFax.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabFax.setBounds(new Rectangle(279, 91, 62, 18));
		jTFieldFax = new JTextField();
		jTFieldFax.setBounds(new Rectangle(348, 87, 141, 19));

		jLabEmail = new JLabel("Email:");
		jLabEmail.setBounds(new Rectangle(500, 89, 57, 18));
		jLabEmail.setFont(new java.awt.Font("Dialog", 1, 11));
		jTFieldEmail = new JTextField("@");
		jTFieldEmail.setBounds(new Rectangle(551, 86, 141, 19));

		jLabFami = new JLabel("Family situation:");
		jLabFami.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabFami.setBounds(new Rectangle(9, 30, 124, 19));
		jComboFami = new JComboBox<String>();
		jComboFami.setBackground(SystemColor.inactiveCaptionText);
		jComboFami.setBounds(new Rectangle(138, 31, 130, 18));
		jComboFami.addItem("Single");
		jComboFami.addItem("Married");

		jRadioButton1 = new JRadioButton("Oui");
		jRadioButton1.setBackground(SystemColor.textInactiveText);
		jRadioButton1.setBounds(new Rectangle(393, 32, 58, 15));

		jLabHandic = new JLabel("Handicapped:");
		jLabHandic.setBounds(new Rectangle(291, 30, 95, 19));
		jLabHandic.setBackground(SystemColor.inactiveCaption);
		jLabHandic.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabHandic.setOpaque(false);
		jRadioBHandic = new JRadioButton("No");
		jRadioBHandic.setBounds(new Rectangle(480, 32, 59, 15));
		jRadioBHandic.setBackground(SystemColor.textInactiveText);

		jLabEducLevel = new JLabel("Education level");
		jLabEducLevel.setBounds(new Rectangle(25, 86, 114, 19));
		jLabEducLevel.setFont(new java.awt.Font("Dialog", 1, 11));
		jComBoxDegree = new JComboBox<String>();
		jComBoxDegree.setBackground(SystemColor.inactiveCaptionText);
		jComBoxDegree.setBounds(new Rectangle(137, 82, 130, 18));
		jComBoxDegree.addItem("Intermediary");
		jComBoxDegree.addItem("Secondary school");
		jComBoxDegree.addItem("Bac");
		jComBoxDegree.addItem("Bac+1");
		jComBoxDegree.addItem("Bac+2");
		jComBoxDegree.addItem("Bac+3");
		jComBoxDegree.addItem("Bac+4");
		jComBoxDegree.addItem("Bac+5(or more)");

		jLabSpecialty = new JLabel("Specialty:");
		jLabSpecialty.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabSpecialty.setBounds(new Rectangle(34, 128, 98, 19));
		jTFieldSpecialty = new JTextField();
		jTFieldSpecialty.setBounds(new Rectangle(138, 126, 185, 19));

		jLabExperience = new JLabel("Professional experience:");
		jLabExperience.setBounds(new Rectangle(279, 80, 173, 19));
		jLabExperience.setFont(new java.awt.Font("Dialog", 1, 11));
		jComBoxExperience = new JComboBox<String>();
		jComBoxExperience.setBackground(SystemColor.inactiveCaptionText);
		jComBoxExperience.setBounds(new Rectangle(478, 81, 163, 18));
		jComBoxExperience.addItem("without");
		jComBoxExperience.addItem("Experience < 3 years ");
		jComBoxExperience.addItem("Experience 3 years(or more)");

		jButton1 = new JButton("Ok");
		jButton1.setBackground(Color.green);
		jButton1.setBounds(new Rectangle(389, 154, 144, 22));
		jButton1.setFont(new java.awt.Font("Dialog", 1, 13));
		jButton1.setForeground(Color.yellow);
		jButton1.addActionListener(this);
		jButton2 = new JButton("Cancel");
		jButton2.setBackground(Color.blue);
		jButton2.setBounds(new Rectangle(180, 154, 144, 22));
		jButton2.setFont(new java.awt.Font("Dialog", 1, 13));
		jButton2.setForeground(Color.white);
		jButton2.addActionListener(this);

		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioBHandic);

		jPanIdentiPromoter = new JPanel();
		jPanIdentiPromoter.setBorder(BorderFactory.createTitledBorder("Identification du promoteur"));
		jPanIdentiPromoter.setFont(new java.awt.Font("Dialog", 1, 14));
		jPanIdentiPromoter.setBackground(SystemColor.inactiveCaptionText);
		jPanIdentiPromoter.setBounds(new Rectangle(0, 84, 701, 55));
		jPanIdentiPromoter.setLayout(null);
		jPanIdentiPromoter.add(jTFieldFirstName, null);
		jPanIdentiPromoter.add(jLabLastName, null);
		jPanIdentiPromoter.add(jTFieldLastName, null);
		jPanIdentiPromoter.add(jLabDBirth, null);
		jPanIdentiPromoter.add(jTFieldDBirth, null);
		jPanIdentiPromoter.add(jLabelFirstName, null);

		jPanCoordinate = new JPanel();
		jPanCoordinate.setBorder(BorderFactory.createTitledBorder("Promoter coordinate"));
		jPanCoordinate.setBackground(SystemColor.inactiveCaptionText);
		jPanCoordinate.setBounds(new Rectangle(-1, 138, 702, 122));
		jPanCoordinate.setLayout(null);
		jPanCoordinate.add(jTextArea, null);
		jPanCoordinate.add(jLabAddresse, null);
		jPanCoordinate.add(jLabCity, null);
		jPanCoordinate.add(jTFieldCity, null);
		jPanCoordinate.add(jLabTel, null);
		jPanCoordinate.add(jTFieldTel, null);
		jPanCoordinate.add(jLabFax, null);
		jPanCoordinate.add(jTFieldFax, null);
		jPanCoordinate.add(jLabEmail, null);
		jPanCoordinate.add(jTFieldEmail, null);

		jPanPromoProfil = new JPanel();
		jPanPromoProfil.setBorder(BorderFactory.createTitledBorder("Promoter profile"));
		jPanPromoProfil.setBackground(SystemColor.inactiveCaptionText);
		jPanPromoProfil.setBounds(new Rectangle(-3, 260, 703, 241));
		jPanPromoProfil.setLayout(null);
		jPanPromoProfil.add(jLabFami, null);
		jPanPromoProfil.add(jComboFami, null);
		jPanPromoProfil.add(jLabHandic, null);
		jPanPromoProfil.add(jRadioButton1, null);
		jPanPromoProfil.add(jRadioBHandic, null);
		jPanPromoProfil.add(jLabEducLevel, null);
		jPanPromoProfil.add(jComBoxDegree, null);
		jPanPromoProfil.add(jLabExperience, null);
		jPanPromoProfil.add(jComBoxExperience, null);
		jPanPromoProfil.add(jButton1, null);
		jPanPromoProfil.add(jButton2, null);
		jPanPromoProfil.add(jTFieldSpecialty, null);
		jPanPromoProfil.add(jLabSpecialty, null);

		this.setJMenuBar(jMenuBar);
		this.getContentPane().add(jLabAnsej2, null);
		this.getContentPane().add(jLabAnsej1, null);
		this.getContentPane().add(jLabSpace, null);
		this.getContentPane().add(jLabContext, null);
		this.getContentPane().add(jLabStage, null);
		this.getContentPane().add(jPanIdentiPromoter, null);
		this.getContentPane().add(jPanCoordinate, null);
		this.getContentPane().add(jPanPromoProfil, null);
	}

	public void actionPerformed(ActionEvent arg0) {
		Object ob = arg0.getSource();
		if (ob.equals(jMenuFileExit)) {

			System.exit(0);
			;
		} else {
			if (ob.equals(jMenuHelpAbout)) {
				JOptionPane.showConfirmDialog(null, "Déscription de la page  ", "Juste un test",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JButton boutonCliqué = (JButton) arg0.getSource();
				if (boutonCliqué == jButton2) {
					dispose();
					t.show();
				} else {
					if (boutonCliqué == jButton1) {
						System.out.println("j'essaye de creer le vecteur");
						Vector liste = new Vector();
						System.out.println("le vecteur a ete creer");
						liste.addElement(this.getnom());
						liste.addElement(this.getprenom());
						liste.addElement(this.getdn());
						liste.addElement(this.getadresse());
						liste.addElement(this.getcommune());
						liste.addElement(this.gettelephone());
						liste.addElement(this.getfaxe());
						liste.addElement(this.getemail());
						liste.addElement(this.gets_familiale());
						liste.addElement(this.gethandicape());
						liste.addElement(this.getn_etude());
						liste.addElement(this.gete_professionel());
						liste.addElement(this.getspecialite());

						System.out.println(liste.elementAt(1) + "oui la");
						// this.registre1.SaisirttInfo(liste, this);
						dispose();
						t.show();

					}

				}
			}
		}
	}

	public Object getnom() {
		return jTFieldFirstName.getText();
	}

	Object getprenom() {
		return jTFieldLastName.getText();
	}

	public Object getdn() {
		return jTFieldDBirth.getText();
	}

	public Object getadresse() {
		return jTextArea.getText();
	}

	public Object getcommune() {
		return jTFieldCity.getText();
	}

	public Object gettelephone() {
		return jTFieldTel.getText();
	}

	public Object getfaxe() {
		return jTFieldFax.getText();
	}

	public Object getemail() {
		return jTFieldEmail.getText();
	}

	public Object gets_familiale() {
		return jComboFami.getSelectedItem();
	}

	public Object gethandicape() {
		return "Non";
	}

	public Object getn_etude() {
		return jComBoxDegree.getSelectedItem();
	}

	public Object gete_professionel() {
		return jComBoxExperience.getSelectedItem();
	}

	public Object getspecialite() {
		return jTFieldSpecialty.getText();
	}

	public void update() {
		dispose();
		JOptionPane.showConfirmDialog(null, "Inscription reussie  ", "Juste un test", JOptionPane.PLAIN_MESSAGE);
	}

	public void update1() {
	}

	public void update2() {
	}

	public void update4(int i, String j) {
	}

	public void update(JFrame f) {
	}

}
