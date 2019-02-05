/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
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

	private final String[] header = {"firstname", "lastname", "gender", "birth", "father", "mother", "birthCertNum", "numAddress", "typeAddress",
			"streetName", "city", "zipCode", "country"};
	private final List<DataModel> data = new ArrayList<DataModel>();

	@SuppressWarnings("unchecked")
	public PromoTableModel() {

		if (SwingUtilities.isEventDispatchThread()) {
			logger.info("-- PromoTableModel() in the EDT");
		} else {
			logger.info("-- PromoTableModel() out of the EDT");
		}

		RegisterDelegate rd = new RegisterDelegate();
		rd.setRegisterType("PromotersManager");

		for(DataModel dm: (ArrayList<DataModel>) new Client(rd).doTask("")) {
			data.add(dm);
		}
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
	public String getColumnName(int columnIndex) {
		return header[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return data.get(rowIndex).getFirstName();
		case 1:
			return data.get(rowIndex).getLastName();
		case 2:
			return data.get(rowIndex).getGender();
		case 3:
			return data.get(rowIndex).getBirthDate();
		case 4:
			return data.get(rowIndex).getFather();
		case 5:
			return data.get(rowIndex).getMother();
		case 6:
			return data.get(rowIndex).getBirthCertNum();
		case 7:
			return data.get(rowIndex).getNumAddress();
		case 8:
			return data.get(rowIndex).getTypeAddress();
		case 9:
			return data.get(rowIndex).getStreetName();
		case 10:
			return data.get(rowIndex).getCity();
		case 11:
			return data.get(rowIndex).getZipCode();
		case 12:
			return data.get(rowIndex).getCountry();
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
