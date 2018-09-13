package dz.ummto.ansejnextgen.template;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BaseTemplate {

	private JFrame base;

	public BaseTemplate() {
		jbInit();
	}

	private void jbInit() {

		base = new JFrame();
		base.setSize(704, 550);
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
	}

	public void setHeader(JPanel header) {
		header.setBounds(new Rectangle(0, 2, 704, 70));
		base.getContentPane().add(header, null);
	}

	public JFrame getJFrame() {
		return base;
	}

}
