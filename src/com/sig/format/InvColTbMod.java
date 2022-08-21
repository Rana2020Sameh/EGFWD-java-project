package com.sig.format;
import com.sig.design.InvDesign;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvColTbMod extends AbstractTableModel {

    private ArrayList<InvCol> invSet;
    private String[] Hed = {"InvNum", "InvDate", "CusNm", "InvQuantity"};
    
    public InvColTbMod(ArrayList<InvCol> invSet) {
        this.invSet = invSet;
    }

    @Override
    public int getRowCount() {
        return invSet.size();
    }

    @Override
    public int getColumnCount() {
        return Hed.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvCol inv = invSet.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getNm();
            case 1: return InvDesign.dF.format(inv.getInvDate());
            case 2: return inv.getCustNm();
            case 3: return inv.getInvCount();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return Hed[column];
    }
}
