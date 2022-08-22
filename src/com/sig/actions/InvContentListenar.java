
package com.sig.controller;

import com.sig.model.InvoiceHeader;
import com.sig.model.InvoiceLine;
import com.sig.model.InvoiceLineTableModel;
import com.sig.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelectionListener implements ListSelectionListener {

    private InvoiceFrame frame;

    public TableSelectionListener(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getInvHTbl().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            InvoiceHeader selectedInv = frame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<InvoiceLine> lines = selectedInv.getLines();
            InvoiceLineTableModel lineTableModel = new InvoiceLineTableModel(lines);
            frame.setLinesArray(lines);
            frame.getInvLTbl().setModel(lineTableModel);
            frame.getCustNameLbl().setText(selectedInv.getCustomer());
            frame.getInvNumLbl().setText("" + selectedInv.getNum());
            frame.getInvTotalIbl().setText("" + selectedInv.getInvoiceTotal());
            frame.getInvDateLbl().setText(InvoiceFrame.dateFormat.format(selectedInv.getInvDate()));
        }
    }

}
