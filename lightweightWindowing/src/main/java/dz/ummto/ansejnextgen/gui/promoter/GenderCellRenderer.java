/*
 * Copyright 2008, 2019 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * The <code>CountryCellRenderer</code> represents
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SuppressWarnings("serial")
public class GenderCellRenderer extends DefaultTableCellRenderer {

	private Icon manImage;
	private Icon womanImage;

	protected GenderCellRenderer() {
		super();
		manImage = new ImageIcon("man.png");
		womanImage = new ImageIcon("woman.png");
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		String gender = (String) value;
		setText("");
		
		return this;

	}
}
