package com.sig.design;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class InvRowDil extends JDialog{
    private JTextField piceNm;
    private JTextField piceQuantity;
    private JTextField PicePr;
    private JLabel PiceNmLable;
    private JLabel piceQuantityLable;
    private JLabel PicePrLable;
    private JButton ConfirmBt;
    private JButton DiscardBt;
    
    public InvRowDil(InvDesign Design) {
        piceNm = new JTextField(20);
        PiceNmLable = new JLabel("Pice Nm");
        
        piceQuantity = new JTextField(20);
        piceQuantityLable = new JLabel("Pice Quantity");
        
        PicePr = new JTextField(20);
        PicePrLable = new JLabel("Pice Fees");
        
        ConfirmBt = new JButton("Confirm");
        DiscardBt = new JButton("Discard");
        
        ConfirmBt.setActionCommand("newRowConfirm");
        DiscardBt.setActionCommand("newRowDiscard");
        
        ConfirmBt.addActionListener(Design.getActionListener());
        DiscardBt.addActionListener(Design.getActionListener());
        setLayout(new GridLayout(4, 2));
        
        add(PiceNmLable);
        add(piceNm);
        add(piceQuantityLable);
        add(piceQuantity);
        add(PicePrLable);
        add(PicePr);
        add(ConfirmBt);
        add(DiscardBt);
        
        pack();
    }

    public JTextField getPiceNm() {
        return piceNm;
    }

    public JTextField getpiceQuantity() {
        return piceQuantity;
    }

    public JTextField getPicePr() {
        return PicePr;
    }
}
