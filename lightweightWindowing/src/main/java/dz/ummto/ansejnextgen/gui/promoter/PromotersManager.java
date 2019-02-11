/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.TableRowSorter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.IconEnum;

/**
 * The <code>AllPromoters</code> class represents .
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class PromotersManager extends JPanel {

	private static final Log logger = LogFactory.getLog(PromotersManager.class);

	private PromoTableModel tableModel;
	private JTable table;
	private TableRowSorter<PromoTableModel> sorter;

	public PromotersManager() {
		Runnable code = new Runnable() {
			public void run() {
				jbInit();
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			code.run();
		} else {
			SwingUtilities.invokeLater(code);
		}
	}

	private void jbInit() {

		this.setLayout(null);

		JButton btnEnDis = new JButton("Edit", new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.EDIT + ".png"))
				.getImage().getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH)));
		btnEnDis.setBackground(Color.RED);
		btnEnDis.setBounds(new Rectangle(550, 410, 100, 22));
		btnEnDis.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		btnEnDis.setForeground(Color.gray);
		btnEnDis.setIconTextGap(0);
		btnEnDis.addActionListener(new DisEnableAction());

		JButton btnRmv = new JButton("Remove", new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.DELETE + ".png"))
				.getImage().getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH)));
		btnRmv.setBackground(Color.GRAY);
		btnRmv.setBounds(new Rectangle(50, 410, 100, 22));
		btnRmv.setFont(new java.awt.Font(Font.DIALOG, 1, 9));
		btnRmv.setForeground(Color.white);
		btnRmv.setIconTextGap(1);
		btnRmv.addActionListener(new RemoveRowsAction());

		JButton btnFilter = new JButton("Filter", new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.FILTER + ".png"))
				.getImage().getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH)));
		btnFilter.setBackground(Color.YELLOW);
		btnFilter.setBounds(new Rectangle(300, 410, 100, 22));
		btnFilter.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
		btnFilter.setForeground(Color.blue);
		btnFilter.addActionListener(new FilterAction());

		this.add(btnEnDis, null);
		this.add(btnRmv, null);
		this.add(btnFilter, null);

		/* TODO this must be run on SwingWorker */
		new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				tableModel = new PromoTableModel();
				return null;
			}

			@Override
			protected void done() {

				table = new JTable(tableModel);
				//table.setAutoCreateRowSorter(true);
				table.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
				table.getColumnModel().getColumn(2).setCellRenderer(new GenderCellRenderer());
				table.getColumnModel().getColumn(12).setCellRenderer(new CountryCellRenderer());

				sorter = new TableRowSorter<PromoTableModel>(tableModel);
				table.setRowSorter(sorter);

				table.setEnabled(false);

				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(2, 14, 696, 150);

				add(sp, null);
			}
		}.execute();

	}

	private class DisEnableAction extends AbstractAction {

		private DisEnableAction() {
			super("Enable or Disable JTable");
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			if (table.isEnabled()) {

				table.setEnabled(false);
				btn.setText("Edit");
				btn.setBackground(Color.red);
				btn.setIcon( new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.EDIT + ".png"))
				.getImage().getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH)));

			} else {

				table.setEnabled(true);
				btn.setText("Freeze");
				btn.setBackground(Color.ORANGE);
				btn.setIcon( new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.FREEZE + ".png"))
				.getImage().getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH)));
			}
		}
	}

	private class RemoveRowsAction extends AbstractAction {

		private RemoveRowsAction() {
			super("Delete row");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			logger.info("-- RemoveRowsAction.actionPerformed()");
			int[] selection = table.getSelectedRows();
			int[] modelIndexes = new int[selection.length];
			
			for (int i = 0; i < selection.length; i++) {
				modelIndexes[i] = table.getRowSorter().convertRowIndexToModel(selection[i]);
			}
			Arrays.sort(modelIndexes);

			for(int i = modelIndexes.length - 1; i >= 0; i--){
				tableModel.removeData(modelIndexes[i]);
			}
		}
	}

	private class FilterAction extends AbstractAction {

		private FilterAction() {
			super("Filter");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String regex = JOptionPane.showInputDialog("Filter:");
			sorter.setRowFilter(RowFilter.regexFilter(regex, 0));
		}
	}
}
