/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.registration;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The <code>Registration</code> class represents registration promoters swing
 * window. All promoters must pass by this window class.
 * <p>
 * The class <code>Registration</code> includes methods for send first
 * information about promoters to the system.
 * The class <code>Registration</code> use SwingUtilities for handling events 
 * on the EDT.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class Registration extends JFrame implements ActionListener {

	private static final Log logger = LogFactory.getLog(Registration.class);
	private JFrame g;
	private JMenuBar jMenuBar1;
	private JMenu jMenuFile, jMenuHelp;
	private JMenuItem jMenuFileExit, jMenuHelpAbout;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11;
	private JTextField jTextField1, jTextField2;
	private JButton jButton1, jButton2;
	private JComboBox<String> jComboBox1, jComboBox2, jComboBox3;

	/**
	 * Initializes the components of <code>Registration</code> window.
	 * <p>
	 * <b>Note:</b> this method must be run in the EDT
	 */
	private void jbInit() /* throws Exception */ {
		if(SwingUtilities.isEventDispatchThread()) {
			logger.info("--- jbInit: In the EDT");
		} else {
			logger.info("--- jbInit: Out of EDT");
		}
		jMenuFileExit = new JMenuItem();
		jMenuHelpAbout = new JMenuItem();
		jMenuFileExit.setText("Quitter");
		jMenuHelpAbout.setText("A propos");
		jMenuFileExit.addActionListener(this);
		jMenuHelpAbout.addActionListener(this);

		jMenuFile = new JMenu();
		jMenuFile.setText("Fichier");
		jMenuFile.add(jMenuFileExit);
		jMenuHelp = new JMenu();
		jMenuHelp.setText("Aide");
		jMenuHelp.add(jMenuHelpAbout);

		jMenuBar1 = new JMenuBar();
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);

		jLabel1 = new JLabel();
		jLabel1.setBackground(Color.orange);
		jLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabel1.setForeground(Color.blue);
		jLabel1.setOpaque(true);
		jLabel1.setText("     ANSEJ");
		jLabel1.setBounds(new Rectangle(-1, 0, 93, 27));
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(607, 0, 93, 27));
		jLabel2.setText("     ANSEJ");
		jLabel2.setOpaque(true);
		jLabel2.setForeground(Color.blue);
		jLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
		jLabel2.setBackground(Color.orange);
		jLabel3 = new JLabel();
		jLabel3.setBackground(Color.lightGray);
		jLabel3.setFont(new java.awt.Font("Dialog", 3, 18));
		jLabel3.setOpaque(true);
		jLabel3.setText("                 Espace  Conseiller accompagnateur");
		jLabel3.setBounds(new Rectangle(92, 0, 514, 27));
		jLabel5 = new JLabel();
		jLabel5.setBackground(Color.orange);
		jLabel5.setFont(new java.awt.Font("SansSerif", 3, 13));
		jLabel5.setOpaque(true);
		jLabel5.setRequestFocusEnabled(true);
		jLabel5.setIconTextGap(4);
		jLabel5.setText("                Suivie des Promoteurs ");
		jLabel5.setBounds(new Rectangle(-5, 42, 703, 22));
		jLabel4 = new JLabel();
		jLabel4.setBackground(Color.white);
		jLabel4.setFont(new java.awt.Font("Dialog", 1, 13));
		jLabel4.setOpaque(true);
		jLabel4.setRequestFocusEnabled(true);
		jLabel4.setVerifyInputWhenFocusTarget(true);
		jLabel4.setText("                      Inscription d\'un nouveau Promoteur ( Etape " + "1 )");
		jLabel4.setBounds(new Rectangle(0, 64, 700, 21));
		jLabel6 = new JLabel();
		jLabel6.setBackground(Color.white);
		jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabel6.setText("     Nom du Promoteur");
		jLabel6.setBounds(new Rectangle(87, 127, 124, 26));
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(81, 178, 141, 23));
		jLabel7.setText("              Prenom");
		jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabel7.setToolTipText("");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(35, 229, 161, 26));
		jLabel8.setText("       Date de Naissance : ");
		jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
		jLabel9 = new JLabel();
		jLabel9.setText("Jour:");
		jLabel9.setBounds(new Rectangle(191, 234, 41, 21));
		jLabel10 = new JLabel();
		jLabel10.setText("Mois:");
		jLabel10.setBounds(new Rectangle(300, 234, 39, 18));
		jLabel11 = new JLabel();
		jLabel11.setText("Année:");
		jLabel11.setBounds(new Rectangle(403, 233, 44, 18));

		jTextField1 = new JTextField();
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(273, 127, 160, 22));
		jTextField2 = new JTextField();
		jTextField2.setBounds(new Rectangle(273, 178, 160, 22));
		jTextField2.setText("");

		jButton1 = new JButton();
		jButton1.setBackground(Color.orange);
		jButton1.setBounds(new Rectangle(389, 321, 97, 26));
		jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
		jButton1.setText("  Suivant");
		jButton1.addActionListener(this);
		jButton2 = new JButton();
		jButton2.setText(" Annuler");
		jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
		jButton2.setBounds(new Rectangle(190, 322, 91, 26));
		jButton2.setBackground(Color.orange);
		jButton2.addActionListener(this);

		jComboBox1 = new JComboBox<String>();
		jComboBox1.setBounds(new Rectangle(244, 234, 44, 21));
		jComboBox2 = new JComboBox<String>();
		jComboBox2.setBounds(new Rectangle(343, 233, 45, 20));
		jComboBox3 = new JComboBox<String>();
		jComboBox3.setBounds(new Rectangle(459, 234, 78, 19));
		int i = 1;
		for (i = 1; i <= 31; i++) {
			jComboBox1.addItem(String.valueOf(i));
		}
		for (i = 1; i <= 12; i++) {
			jComboBox2.addItem(String.valueOf(i));
		}
		for (i = 1960; i <= 1999; i++) {
			jComboBox3.addItem(String.valueOf(i));
		}

		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jLabel8, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(jComboBox2, null);
		this.getContentPane().add(jLabel11, null);
		this.getContentPane().add(jLabel10, null);
		this.getContentPane().add(jComboBox3, null);
		this.getContentPane().add(jComboBox1, null);
		this.getContentPane().add(jLabel9, null);
		this.getContentPane().add(jTextField2, null);

		this.setJMenuBar(jMenuBar1);
		this.setJMenuBar(jMenuBar1);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);

	}

	private String getFName() {
		return jTextField1.getText();
	}

	private String getSName() {
		return jTextField2.getText();
	}

	private String getDateBir() {
		String st1 = String.valueOf(jComboBox1.getSelectedItem());
		String st2 = String.valueOf(jComboBox2.getSelectedItem());
		String st3 = String.valueOf(jComboBox3.getSelectedItem());
		String st4 = st1 + "/" + st2 + "/" + st3;
		logger.info("--- st4: "+st4);
		return st4;
	}

	/** @Constructor */
	public Registration() {
		jbInit();
	}

	/**
	 * Invoked when an action occurs.
	 */
	public void actionPerformed(ActionEvent arg) {
		if(SwingUtilities.isEventDispatchThread()) {
			logger.info("--- actionPerformed: In the EDT");
		} else {
			logger.fatal("--- actionPerformed: Out of EDT");
		}
		// this.registre1=A.getRegistre1();
		Object ob = arg.getSource();
		if (ob.equals(jMenuFileExit)) {

			System.exit(0);
		} else {
			if (ob.equals(jMenuHelpAbout)) {
				JOptionPane.showConfirmDialog(null, "Déscription de la page  ", "Juste un test",
						JOptionPane.PLAIN_MESSAGE);
			}

			else {
				JButton boutonCliqué = (JButton) arg.getSource();
				if (boutonCliqué == jButton1) {
					logger.info("--- <"+getFName()+">---<"+getSName()+">---<"+getDateBir()+">");
					
					//RegisterOne rOne = new RegisterOne();
					//rOne.register(Arrays.asList(getFName(),getSName(),getDateBir()));
				} else if (boutonCliqué == jButton2) {
					dispose();
					g.setVisible(true);
					//g.show();
				}
			}
		}

	}

}
