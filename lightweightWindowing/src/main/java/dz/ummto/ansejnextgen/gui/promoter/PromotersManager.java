/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.ORANGE);
		btnAdd.setBounds(new Rectangle(550, 400, 100, 22));
		btnAdd.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		btnAdd.setForeground(Color.gray);
		btnAdd.addActionListener(new AddRowsAction());

		JButton btnRmv = new JButton("Remove");
		btnRmv.setBackground(Color.GRAY);
		btnRmv.setBounds(new Rectangle(50, 400, 100, 22));
		btnRmv.setFont(new java.awt.Font(Font.DIALOG, 1, 11));
		btnRmv.setForeground(Color.yellow);
		btnRmv.addActionListener(new RemoveRowsAction());

		this.add(btnAdd, null);
		this.add(btnRmv, null);

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
				table.setAutoCreateRowSorter(true);
				table.setFont(new java.awt.Font(Font.DIALOG, 1, 10));
				table.getColumnModel().getColumn(2).setCellRenderer(new GenderCellRenderer());
				table.getColumnModel().getColumn(12).setCellRenderer(new CountryCellRenderer());

				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(2, 14, 696, 150);

				add(sp, null);
			}
		}.execute();

	}

	private class AddRowsAction extends AbstractAction {

		private AddRowsAction() {
			super("Add row");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			logger.info("-- AddRowsAction.actionPerformed()");
			//TODO
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
			 
			for(int i = selection.length - 1; i >= 0; i--){
				tableModel.removeData(selection[i]);
			}
		}
	}
}
