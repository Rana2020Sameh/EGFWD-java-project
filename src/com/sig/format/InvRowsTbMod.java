package com.sig.format;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class InvRowsTbMod extends AbstractTableModel {

    private ArrayList<InvRows> lsSet;
    private String[] cLS = {"PiceName", "Price", "Quantity", "Row Fees"};

    public InvRowsTbMod(ArrayList<InvRows> lsSet) {
        this.lsSet = lsSet;
    }

    @Override
    public int getRowCount() {
        return lsSet == null ? 0 : lsSet.size();
    }

    @Override
    public int getColumnCount() {
        return cLS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lsSet == null) {
            return "";
        } else {
            InvRows line = lsSet.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return line.getPice();
                case 1:
                    return line.getFess();
                case 2:
                    return line.getQuantity();
                case 3:
                    return line.getRowsCount();
                default:
                    return "";
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return cLS[column];
    }

}
