package com.sig.actions;

import com.sig.format.InvCol;
import com.sig.format.InvRows;
import com.sig.format.InvRowsTbMod;
import com.sig.design.InvDesign;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class InvContentListenar implements ListSelectionListener {

    private InvDesign Design;

    public InvContentListenar(InvDesign Design) {
        this.Design = Design;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = Design.getInvHTbl().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            InvCol ChooseInvoice = Design.getInvoicesArray().get(selectedInvIndex);
            ArrayList<InvRows> ls = ChooseInvoice.getLs();
            InvRowsTbMod rowsTbMod = new InvRowsTbMod(ls);
            Design.setLinesArray(ls);
            Design.getInvLTbl().setModel(rowsTbMod);
            Design.getCustNameLbl().setText(ChooseInvoice.getCustNm());
            Design.getInvNumLbl().setText("" + ChooseInvoice.getNm());
            Design.getInvTotalIbl().setText("" + ChooseInvoice.getInvCount());
            Design.getInvDateLbl().setText(InvDesign.dF.format(ChooseInvoice.getInvDate()));
        }
    }

}
