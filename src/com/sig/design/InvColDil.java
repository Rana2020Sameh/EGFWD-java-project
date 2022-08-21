
package com.sig.design;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvColDil extends JDialog {
    private JTextField cNm;
    private JTextField invoiceD;
    private JLabel cNmLable;
    private JLabel invoiceDLable;
    private JButton ConfirmBt;
    private JButton DiscardBt;

    public InvColDil(InvDesign Design) {
        cNmLable = new JLabel("Client Nm:");
        cNm = new JTextField(20);
        invoiceDLable = new JLabel("InvD:");
        invoiceD = new JTextField(20);
        ConfirmBt = new JButton("Confirm");
        DiscardBt = new JButton("discard");
        
        ConfirmBt.setActionCommand("New inv Confirm");
        DiscardBt.setActionCommand("New inv Discard");
        
        ConfirmBt.addActionListener(Design.getActionListener());
        DiscardBt.addActionListener(Design.getActionListener());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDLable);
        add(invoiceD);
        add(cNmLable);
        add(cNm);
        add(ConfirmBt);
        add(DiscardBt);
        
        pack();
        
    }

    public JTextField getCNm() {
        return cNm;
    }

    public JTextField getInvoiceD() {
        return invoiceD;
    }
    
}
