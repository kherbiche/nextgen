/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.IconEnum;
import dz.ummto.ansejnextgen.users.UserSession;

/**
 * The <code>Menu</code> class represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class Menu {

	private static final Log loggerrr = LogFactory.getLog(Menu.class);
	private JPanel menuJpanel;

	public Menu() {
		Runnable code = new Runnable() {
			public void run() {
				jbInit();
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			loggerrr.info("--- Menu.jbInit: In the EDT");
			code.run();
		} else {
			loggerrr.info("--- Menu.jbInit: Out of EDT");
			SwingUtilities.invokeLater(code);
		}
	}

	private void jbInit() {

		JLabel jLabMenu = new JLabel("Menu",
				new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.MENU + ".png")).getImage()
						.getScaledInstance(50, 45, Image.SCALE_SMOOTH)),
				SwingConstants.CENTER);
		jLabMenu.setBackground(new Color(214, 42, 252));
		jLabMenu.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		jLabMenu.setBounds(new Rectangle(0, 0, 135, 19));
		jLabMenu.setOpaque(true);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Action");

		if(UserSession.getRoles()!=null && UserSession.getRoles().contains("ROLE_COUNSELOR")) {
			DefaultMutableTreeNode promoterAction = new DefaultMutableTreeNode("Promoter");
			promoterAction.add(new DefaultMutableTreeNode("New"));
			promoterAction.add(new DefaultMutableTreeNode("UpDate"));

			DefaultMutableTreeNode eligibilityAction = new DefaultMutableTreeNode("Eligibility");
			eligibilityAction.add(new DefaultMutableTreeNode("Assign"));

			root.add(promoterAction);
			root.add(eligibilityAction);
		}
		if(UserSession.getRoles()!=null && UserSession.getRoles().contains("ROLE_ADMIN")) {
			DefaultMutableTreeNode userManagerAction = new DefaultMutableTreeNode("Users Manager");
			userManagerAction.add(new DefaultMutableTreeNode("new"));

			root.add(userManagerAction);
		}

		if(UserSession.getRoles()!=null && !UserSession.getRoles().isEmpty()) {
			DefaultMutableTreeNode profileAction = new DefaultMutableTreeNode("Profile");
			profileAction.add(new DefaultMutableTreeNode("Edit"));
			profileAction.add(new DefaultMutableTreeNode("Change pwd"));

			root.add(profileAction);
		}

		JTree tree = new JTree(root);
		tree.setFont(new java.awt.Font(Font.DIALOG, 1, 13));
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);

		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setOpenIcon(new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.OPEN_FOLD + ".png"))
				.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH)));
		renderer.setClosedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.CLOSE_FOLD + ".png"))
				.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH)));
		renderer.setLeafIcon(new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.LEAF + ".png"))
				.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));

		tree.setCellRenderer(renderer);

		JScrollPane sp = new JScrollPane(tree);
		sp.setBounds(2, 25, 130, 150);

		menuJpanel = new JPanel();
		menuJpanel.setLayout(null);
		menuJpanel.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		menuJpanel.setBackground(new Color(224, 217, 168));
		menuJpanel.add(jLabMenu, null);
		menuJpanel.add(sp, null);
	}

	public JPanel getJPanel() {
		return menuJpanel;
	}
}
