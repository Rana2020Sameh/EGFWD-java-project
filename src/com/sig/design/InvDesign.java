package com.sig.design;
import com.sig.actions.InvListin;
import com.sig.actions.InvContentListenar;
import com.sig.format.InvCol;
import com.sig.format.InvColTbMod;
import com.sig.format.InvRows;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public class InvDesign extends javax.swing.JFrame {

    private ListSelectionListener selectionListener;
 public InvDesign() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invHTbl = new javax.swing.JTable();
        createInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custNameLbl = new javax.swing.JLabel();
        invDateLbl = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invTotalIbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLTbl = new javax.swing.JTable();
        createLineButton = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invHTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invHTbl.getSelectionModel().addListSelectionListener(selectionListener);
        jScrollPane1.setViewportView(invHTbl);

        createInvoiceButton.setText("genrateInv");
        createInvoiceButton.addActionListener(actionListener);

        deleteInvoiceButton.setText("CleareInv");
        deleteInvoiceButton.addActionListener(actionListener);

        jLabel1.setText("InvNum");

        jLabel2.setText("InvDate");

        jLabel3.setText("CustName");

        jLabel4.setText("InvTotL");

        invLTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLTbl);

        createLineButton.setText("CreatRow");
        createLineButton.addActionListener(actionListener);

        deleteLineButton.setText("ClearRow");
        deleteLineButton.addActionListener(actionListener);

        jMenu1.setText("File");

        loadMenuItem.setText("Import ");
        loadMenuItem.addActionListener(actionListener);
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Saving");
        saveMenuItem.setActionCommand("Saveing");
        saveMenuItem.addActionListener(actionListener);
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invTotalIbl)
                            .addComponent(invNumLbl)
                            .addComponent(invDateLbl)
                            .addComponent(custNameLbl)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(createInvoiceButton)
                .addGap(67, 67, 67)
                .addComponent(deleteInvoiceButton)
                .addGap(136, 136, 136)
                .addComponent(createLineButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteLineButton)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(custNameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalIbl))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(createLineButton)
                    .addComponent(deleteLineButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvDesign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvDesign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvDesign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvDesign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvDesign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel custNameLbl;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JLabel invDateLbl;
    private javax.swing.JTable invHTbl;
    private javax.swing.JTable invLTbl;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalIbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private InvListin actionListener = new InvListin(this);
    private ArrayList<InvCol> invSet;
    private ArrayList<InvRows> LsSet;
    private InvColTbMod ColTbMod;
    public static SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
    private InvContentListenar ChooserControl = new InvContentListenar(this);

    public ArrayList<InvRows> getLinesArray() {
        return LsSet;
    }

    public void setLinesArray(ArrayList<InvRows> linesArray) {
        this.LsSet = linesArray;
    }
    
    public void setInvoicesArray(ArrayList<InvCol> invoicesArray) {
        this.invSet = invoicesArray;
    }

    public ArrayList<InvCol> getInvoicesArray() {
        return invSet;
    }
    
    public InvCol getInvObject(int code) {
        for (InvCol inv : invSet) {
            if (inv.getNm() == code) {
                return inv;
            }
        }
        return null;
    }

    public InvColTbMod getColTbMod() {
        return ColTbMod;
    }

    public void setColTbMod(InvColTbMod headerTableModel) {
        this.ColTbMod = ColTbMod;
    }

    public JTable getInvHTbl() {
        return invHTbl;
    }

    public JTable getInvLTbl() {
        return invLTbl;
    }

    public JLabel getCustNameLbl() {
        return custNameLbl;
    }

    public JLabel getInvDateLbl() {
        return invDateLbl;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public JLabel getInvTotalIbl() {
        return invTotalIbl;
    }

    public InvListin getActionListener() {
        return actionListener;
    }
    
    
}
