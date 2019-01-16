/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejnextgen.registers.Client;
import dz.ummto.ansejnextgen.registers.RegisterDelegate;

/**
 * The <code>PromoTableModel</code> class extends
 * {@link javax.swing.table.AbstractTableModel} used by <b>JTable</b> in
 * {@link dz.ummto.ansejnextgen.gui.promoter.PromotersManager}
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@SuppressWarnings("serial")
public class PromoTableModel extends AbstractTableModel {

	private static final Log logger = LogFactory.getLog(PromoTableModel.class);

	private final String[] header = {"firstname", "lastname", "birth", "father", "mother"};
	private final List<DataModel> data = new ArrayList<DataModel>();

	public PromoTableModel() {
		data.add(new DataModel("first1", "last1", "12/12/1990", "fa", "mo"));
		data.add(new DataModel("first2", "last2", "12/12/1990", "fa", "mo"));
		data.add(new DataModel("first3", "last3", "12/12/1990", "fa", "mo"));
		
		if (SwingUtilities.isEventDispatchThread()) {
			logger.info("-- PromoTableModel() in the EDT");
		} else {
			logger.info("-- PromoTableModel() out of the EDT");
		}
		new SwingWorker<Integer, Void>() {

			@Override
			protected Integer doInBackground() throws Exception {
				RegisterDelegate rd = new RegisterDelegate();
				rd.setRegisterType("PromotersManager");
				return (Integer) new Client(rd).doTask("");
			}

			@Override
			protected void done() {
				try {
					logger.info("-- Swing Worker get()=" + get().intValue());
				} catch (Exception e) {
					logger.info("-- error"+ e.getMessage());
				}
			}
		}.execute();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			return data.get(rowIndex).getFirstname();
		case 1:
			return data.get(rowIndex).getLastname();
		case 2:
			return data.get(rowIndex).getBirthdate();
		case 3:
			return data.get(rowIndex).getFather();
		case 4:
			return data.get(rowIndex).getMother();
		default:
			return null;
		}
	}

	public void addData(DataModel item) {
		data.add(item);
		fireTableRowsInserted(data.size() - 1, data.size() - 1);
	}

	public void removeData(int rowIndex) {
		data.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
