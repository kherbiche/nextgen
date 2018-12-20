/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

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

	private final String[] header = {};
	private final List<DataModel> data = new ArrayList<DataModel>();

	public PromoTableModel() {
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
