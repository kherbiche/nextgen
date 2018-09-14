/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.common_utils.HintJTextField;

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

	private JMenuItem jMenuFileExit, jMenuHelpAbout;
	private JTextField jTFieldFirstName, jTFieldLastName, jTFieldDBirth, jTFieldFather, jTFieldMother, jTFieldBirthCity, jTFieldBirthZipCode, jTFieldBirthCountry, jTFieldNumAddrss, jTFieldStreetName, jTFieldCity, jTFieldZipCode, jTFieldCountry, jTFieldTel, jTFieldFax,
			jTFieldEmail, jTFieldSpecialty, jTFieldAnemCard;
	private JComboBox<String> jComboGender, jComboTypeAddr, jComboFami, jComBoxDegree, jComBoxExperience;
	private JRadioButton jRadioButton1, jRadioBHandic;
	private JButton jButton1, jButton2;

	public Inscription(JFrame t) {
		jbInit();
	}

	private void jbInit() {

		if(SwingUtilities.isEventDispatchThread()) {
			logger.info("--- jbInit: In the EDT");
		} else {
			logger.info("--- jbInit: Out of EDT");
		}
		setTitle("Registration");
		this.setSize(704, 550);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenuFile = new JMenu("File");
		JMenu jMenuHelp = new JMenu("Help");
		jMenuFileExit = new JMenuItem("Exit");
		jMenuFileExit.addActionListener(this);
		jMenuHelpAbout = new JMenuItem("About");
		jMenuHelpAbout.addActionListener(this);
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuHelp);

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

		JLabel jLabGender = new JLabel("Gender:");
		jLabGender.setBounds(new Rectangle(10, 23, 51, 19));
		jLabGender.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		jLabGender.setForeground(Color.GRAY);
		String[] optionsGender = {"Man", "Woman"};
		jComboGender = new JComboBox<String>(optionsGender);
		jComboGender.setBackground(SystemColor.controlLtHighlight);
		jComboGender.setBounds(new Rectangle(62, 23, 100, 19));

		jTFieldFirstName = new HintJTextField("First Name");
		jTFieldFirstName.setBounds(new Rectangle(286, 23, 140, 19));
		jTFieldFirstName.setToolTipText("First Name");

		jTFieldLastName = new HintJTextField("Last Name");
		jTFieldLastName.setBounds(new Rectangle(550, 23, 140, 19));
		jTFieldLastName.setToolTipText("Last Name");

		jTFieldDBirth = new HintJTextField("Born on:dd/mm/yyyy");
		jTFieldDBirth.setBounds(new Rectangle(62, 47, 132, 19));
		jTFieldDBirth.setToolTipText("Birth Date");

		jTFieldFather = new HintJTextField("Father");
		jTFieldFather.setBounds(new Rectangle(286, 47, 140, 19));
		jTFieldFather.setToolTipText("Father Name");

		jTFieldMother = new HintJTextField("Mother");
		jTFieldMother.setBounds(new Rectangle(550, 47, 140, 19));
		jTFieldMother.setToolTipText("Mother Name");


		jTFieldBirthCity = new HintJTextField("Birth City");
		jTFieldBirthCity.setToolTipText("BirthCity");
		jTFieldBirthCity.setBounds(new Rectangle(10, 23, 140, 19));

		jTFieldBirthZipCode = new HintJTextField("Zip Code");
		jTFieldBirthZipCode.setToolTipText("Birth City Zip Code");
		jTFieldBirthZipCode.setBounds(new Rectangle(10, 47, 140, 19));
		
		jTFieldBirthCountry = new HintJTextField("Birth country");
		jTFieldBirthCountry.setToolTipText("Birth country");
		jTFieldBirthCountry.setBounds(new Rectangle(10, 71, 140, 19));

		JPanel jPanCoordinateLeft = new JPanel();
		jPanCoordinateLeft.setLayout(null);
		jPanCoordinateLeft.setBorder(BorderFactory.createTitledBorder("Birth"));
		jPanCoordinateLeft.setBackground(SystemColor.inactiveCaptionText);
		jPanCoordinateLeft.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		jPanCoordinateLeft.setBounds(new Rectangle(5, 12, 160, 105));
		jPanCoordinateLeft.add(jTFieldBirthCity, null);
		jPanCoordinateLeft.add(jTFieldBirthZipCode, null);
		jPanCoordinateLeft.add(jTFieldBirthCountry, null);

		jTFieldNumAddrss = new HintJTextField("N°");
		jTFieldNumAddrss.setToolTipText("Address number");
		jTFieldNumAddrss.setBounds(new Rectangle(10, 23, 140, 19));

		String[] optionsTypeAddr = {"AVENUE", "STREET", "PATH", "ROAD", "PLACE"};
		jComboTypeAddr = new JComboBox<String>(optionsTypeAddr);
		jComboTypeAddr.setBackground(SystemColor.controlLtHighlight);
		jComboTypeAddr.setBounds(new Rectangle(10, 47, 140, 19));

		jTFieldStreetName = new HintJTextField("Street Name");
		jTFieldStreetName.setBounds(new Rectangle(10, 71, 140, 19));
		jTFieldStreetName.setToolTipText("Street Name");

		jTFieldCity = new HintJTextField("City");
		jTFieldCity.setBounds(new Rectangle(375, 23, 140, 19));
		jTFieldCity.setToolTipText("Residence City");

		jTFieldZipCode = new HintJTextField("Zip Code");
		jTFieldZipCode.setToolTipText("Residence Zip Code");
		jTFieldZipCode.setBounds(new Rectangle(375, 47, 140, 19));
		
		jTFieldCountry = new HintJTextField("Country");
		jTFieldCountry.setToolTipText("Residence country");
		jTFieldCountry.setBounds(new Rectangle(375, 71, 140, 19));

		JPanel jPanCoordinateRight = new JPanel();
		jPanCoordinateRight.setLayout(null);
		jPanCoordinateRight.setBorder(BorderFactory.createTitledBorder("Residence"));
		jPanCoordinateRight.setBackground(SystemColor.inactiveCaptionText);
		jPanCoordinateRight.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		jPanCoordinateRight.setBounds(new Rectangle(170, 12, 525, 105));
		jPanCoordinateRight.add(jTFieldNumAddrss, null);
		jPanCoordinateRight.add(jComboTypeAddr, null);
		jPanCoordinateRight.add(jTFieldStreetName, null);
		jPanCoordinateRight.add(jTFieldCity, null);
		jPanCoordinateRight.add(jTFieldZipCode, null);
		jPanCoordinateRight.add(jTFieldCountry, null);

		jTFieldTel = new HintJTextField("Phone");
		jTFieldTel.setBounds(new Rectangle(286, 127, 140, 19));
		jTFieldTel.setToolTipText("Phone num");

		jTFieldFax = new HintJTextField("Fax");
		jTFieldFax.setBounds(new Rectangle(550, 127, 140, 19));
		jTFieldFax.setToolTipText("Fax num");

		jTFieldEmail = new HintJTextField("@email");
		jTFieldEmail.setBounds(new Rectangle(62, 127, 140, 19));
		jTFieldEmail.setToolTipText("Email Address");


		JLabel jLabFami = new JLabel("Family situation:", SwingConstants.LEFT);
		jLabFami.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		jLabFami.setBounds(new Rectangle(10, 23, 110, 19));
		jLabFami.setForeground(Color.GRAY);
		String[] optionsFam = {"Single", "Married"};
		jComboFami = new JComboBox<String>(optionsFam);
		jComboFami.setBackground(SystemColor.controlLtHighlight);
		jComboFami.setBounds(new Rectangle(125, 23, 140, 19));

		JLabel jLabEducLevel = new JLabel("Education level:");
		jLabEducLevel.setBounds(new Rectangle(435, 23, 110, 19));
		jLabEducLevel.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		jLabEducLevel.setForeground(Color.GRAY);
		String[] optionsDegree = {"Intermediary", "Secondary school", "Bac", "Bac+1", "Bac+2", "Bac+3", "Bac+4", "Bac+5(or more)"};
		jComBoxDegree = new JComboBox<String>(optionsDegree);
		jComBoxDegree.setBackground(SystemColor.controlLtHighlight);
		jComBoxDegree.setBounds(new Rectangle(550, 23, 140, 19));

		JLabel jLabExperience = new JLabel("Professional experience:");
		jLabExperience.setBounds(new Rectangle(10, 47, 110, 19));
		jLabExperience.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		jLabExperience.setForeground(Color.GRAY);
		String[] optionsExperience = {"Without", "Experience < 3 years", "Experience 3 years(or more)"};
		jComBoxExperience = new JComboBox<String>(optionsExperience);
		jComBoxExperience.setBackground(SystemColor.controlLtHighlight);
		jComBoxExperience.setBounds(new Rectangle(125, 47, 140, 19));

		jTFieldSpecialty = new HintJTextField("Specialty or degree");
		jTFieldSpecialty.setBounds(new Rectangle(550, 47, 140, 19));
		jTFieldSpecialty.setToolTipText("Specialty or degree");

		JLabel jLabHandic = new JLabel("Handicapped:");
		jLabHandic.setBounds(new Rectangle(10, 71, 110, 19));
		jLabHandic.setBackground(SystemColor.inactiveCaption);
		jLabHandic.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		jLabHandic.setForeground(Color.GRAY);
		jRadioButton1 = new JRadioButton("Yes");
		jRadioButton1.setBackground(SystemColor.textInactiveText);
		jRadioButton1.setBounds(new Rectangle(125, 71, 60, 15));
		jRadioBHandic = new JRadioButton("No");
		jRadioBHandic.setBounds(new Rectangle(205, 71, 60, 15));
		jRadioBHandic.setBackground(SystemColor.textInactiveText);

		jTFieldAnemCard = new HintJTextField("ANEM card N°");
		jTFieldAnemCard.setBounds(new Rectangle(550, 71, 140, 19));
		jTFieldAnemCard.setToolTipText("Anem card number");


		jButton1 = new JButton("Ok");
		jButton1.setBackground(Color.green);
		jButton1.setBounds(new Rectangle(389, 454, 140, 22));
		jButton1.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jButton1.setForeground(Color.yellow);
		jButton1.addActionListener(this);
		jButton2 = new JButton("Cancel");
		jButton2.setBackground(Color.blue);
		jButton2.setBounds(new Rectangle(180, 454, 140, 22));
		jButton2.setFont(new java.awt.Font("Dialog", 1, 13));
		jButton2.setForeground(Color.white);
		jButton2.addActionListener(this);


		JPanel jPanIdentiPromoter = new JPanel();
		jPanIdentiPromoter.setBorder(BorderFactory.createTitledBorder("Identification du promoteur"));
		jPanIdentiPromoter.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		jPanIdentiPromoter.setBackground(SystemColor.inactiveCaptionText);
		jPanIdentiPromoter.setBounds(new Rectangle(2, 75, 700, 89));
		jPanIdentiPromoter.setLayout(null);
		jPanIdentiPromoter.add(jTFieldFirstName, null);
		jPanIdentiPromoter.add(jTFieldLastName, null);
		jPanIdentiPromoter.add(jTFieldDBirth, null);
		jPanIdentiPromoter.add(jLabGender, null);
		jPanIdentiPromoter.add(jComboGender, null);
		jPanIdentiPromoter.add(jTFieldFather, null);
		jPanIdentiPromoter.add(jTFieldMother, null);

		JPanel jPanCoordinate = new JPanel();
		jPanCoordinate.setBorder(BorderFactory.createTitledBorder("Promoter coordinate"));
		jPanCoordinate.setFont(new java.awt.Font(Font.DIALOG, 1, 14));
		jPanCoordinate.setBackground(SystemColor.inactiveCaptionText);
		jPanCoordinate.setBounds(new Rectangle(2, 169, 700, 160));
		jPanCoordinate.setLayout(null);
		jPanCoordinate.add(jPanCoordinateLeft, null);
		jPanCoordinate.add(jPanCoordinateRight, null);
		jPanCoordinate.add(jTFieldTel, null);
		jPanCoordinate.add(jTFieldFax, null);
		jPanCoordinate.add(jTFieldEmail, null);

		JPanel jPanPromoProfil = new JPanel();
		jPanPromoProfil.setBorder(BorderFactory.createTitledBorder("Promoter profile"));
		jPanPromoProfil.setBackground(SystemColor.inactiveCaptionText);
		jPanPromoProfil.setBounds(new Rectangle(2, 334, 700, 113));
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
		//jPanPromoProfil.add(jButton1, null);
		//jPanPromoProfil.add(jButton2, null);
		jPanPromoProfil.add(jTFieldSpecialty, null);
		jPanPromoProfil.add(jTFieldAnemCard, null);

		this.setJMenuBar(jMenuBar);
		this.getContentPane().add(jLabAnsej2, null);
		this.getContentPane().add(jLabAnsej1, null);
		this.getContentPane().add(jLabSpace, null);
		this.getContentPane().add(jLabContext, null);
		this.getContentPane().add(jLabStage, null);
		this.getContentPane().add(jPanIdentiPromoter, null);
		this.getContentPane().add(jPanCoordinate, null);
		this.getContentPane().add(jPanPromoProfil, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);

	}

	public void actionPerformed(ActionEvent arg0) {
		Object ob = arg0.getSource();
		if (ob.equals(jMenuFileExit)) {
			System.exit(0);
		} else {
			if (ob.equals(jMenuHelpAbout)) {
				JOptionPane.showConfirmDialog(null, "Déscription de la page  ", "Juste un test",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JButton boutonCliqué = (JButton) arg0.getSource();
				if (boutonCliqué == jButton2) {
					dispose();
				} else {
					if (boutonCliqué == jButton1) {
						// this.registre1.SaisirttInfo(liste, this);
						dispose();
						//t.show();

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
		return jTFieldNumAddrss.getText();
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

}
