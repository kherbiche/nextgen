/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.IconEnum;

/**
 * The <code>BaseTemplate</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class BaseTemplate {

	private static final Log loggerrr = LogFactory.getLog(BaseTemplate.class);
	private static final Map<String, int[]> DIMENSION;
	private JFrame base;
	private JMenuItem jMenuFileExit;
	private JMenuItem jMenuHelpAbout;
	static {
		Map<String, int[]> aMap = new HashMap<String, int[]>();
		aMap.put("small", new int[] { 1, 2 });
		aMap.put("medium", new int[] { 844, 556 });
		aMap.put("large", new int[] { 1, 2 });
		DIMENSION = Collections.unmodifiableMap(aMap);
	}

	public BaseTemplate(String dim) {
		Runnable code = new Runnable() {
			public void run() {
				jbInit(DIMENSION.containsKey(dim) ? DIMENSION.get(dim) : new int[] { 844, 556 });
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			loggerrr.info("--- BaseTemplate.jbInit: In the EDT");
			code.run();
		} else {
			loggerrr.info("--- BaseTemplate.jbInit: Out of EDT");
			SwingUtilities.invokeLater(code);
		}
	}

	private void jbInit(int[] dim) {

		base = new JFrame();
		// base.setSize(844, 556);
		// base.setMinimumSize(new Dimension(844, 556));
		base.setMinimumSize(new Dimension(dim[0], dim[1]));
		base.setResizable(false);
		base.setLocationRelativeTo(null);
		base.setBackground(new Color(219, 219, 219));
		base.getContentPane().setLayout(null);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenuFile = new JMenu("File");
		JMenu jMenuHelp = new JMenu("Help");
		jMenuFileExit = new JMenuItem("Exit");
		jMenuHelpAbout = new JMenuItem("About");
		jMenuFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jMenuHelpAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Page Description ", "Just Test", JOptionPane.PLAIN_MESSAGE);
			}
		});
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuHelp);
		base.setJMenuBar(jMenuBar);
		base.setIconImage(new ImageIcon(getClass().getResource("/" + IconEnum.FRAME + ".png")).getImage());
	}

	public void setHeader(JPanel header) {
		header.setBounds(new Rectangle(0, 1, 844, 70));
		base.getContentPane().add(header, null);
	}

	public void setFooter(JPanel footer) {
		footer.setBounds(new Rectangle(0, 513, 844, 20));
		base.getContentPane().add(footer, null);
	}

	public void setMenu(JPanel menu) {
		menu.setBounds(new Rectangle(0, 73, 135, 430));
		base.getContentPane().add(menu, null);
	}

	public void setBody(JPanel body) {
		body.setBounds(new Rectangle(140, 73, 704, 438));
		base.getContentPane().add(body, null);
	}

	public JFrame getJFrame() {
		return base;
	}
}
