/*
 * Copyright 2008, 2019 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.promoter;

import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import dz.ummto.ansejnextgen.IconEnum;

/**
 * The <code>GenderCellRenderer</code> represents
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
		manImage = new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.MAN + ".png")).getImage()
				.getScaledInstance(20, 15, Image.SCALE_SMOOTH));
		womanImage = new ImageIcon(new ImageIcon(getClass().getResource("/" + IconEnum.WOMAN + ".png")).getImage()
				.getScaledInstance(20, 15, Image.SCALE_SMOOTH));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		String gender = (String) value;
		setText("");

		if (gender.equals("M")) {
			setIcon(manImage);
		} else
			setIcon(womanImage);

		return this;

	}
}
