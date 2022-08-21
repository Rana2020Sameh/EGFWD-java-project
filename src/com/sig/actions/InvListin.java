package com.sig.actions;
import com.sig.format.InvCol;
import com.sig.format.InvColTbMod;
import com.sig.format.InvRows;
import com.sig.format.InvRowsTbMod;
import com.sig.design.InvDesign;
import com.sig.design.InvColDil;
import com.sig.design.InvRowDil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class InvListin implements ActionListener {

    private InvDesign Design;
    private InvColDil ColDil;
    private InvRowDil RowDil;

    public InvListin(InvDesign Design) {
        this.Design = Design;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Saveing":
                Saveing();
                break;

            case "Import":
                Import();
                break;

            case "genrateInv":
                genrateInv();
                break;

            case "CleareInv":
                CleareInv();
                break;

            case "CreatRow":
                CreatRow();
                break;

            case "ClearRow":
                ClearRow();
                break;

            case "newInvoiceOK":
                newInvoiceDialogOK();
                break;

            case "newInvoiceCancel":
                newInvoiceDialogCancel();
                break;

            case "newLineCancel":
                newLineDialogCancel();
                break;

            case "newLineOK":
                newLineDialogOK();
                break;
        }
    }

    private void Import() {
        JFileChooser selectFile = new JFileChooser();
        try {
            int Outtpoot = selectFile.showOpenDialog(Design);
            if (Outtpoot == JFileChooser.APPROVE_OPTION) {
                File colFile = selectFile.getSelectedFile();
                Path colPath = Paths.get(colFile.getAbsolutePath());
                List<String> colLines = Files.readAllLines(colPath);
                ArrayList<InvCol> invoicecolumns = new ArrayList<>();
                for (String ColumnsLine : colLines) {
                    String[] atrb = ColumnsLine.split(",");
                    String select1 = atrb[0];
                    String select2 = atrb[1];
                    String select3 = atrb[2];
                    int Lebel = Integer.parseInt(select1);
                    Date invoiceDate = InvDesign.dF.parse(select2);
                    InvCol Coll = new InvCol(Lebel, select3, invoiceDate);
                    invoicecolumns.add(Coll);
                }
                Design.setInvoicesArray(invoicecolumns);

                Outtpoot = selectFile.showOpenDialog(Design);
                if (Outtpoot == JFileChooser.APPROVE_OPTION) {
                    File RowFile = selectFile.getSelectedFile();
                    Path rowPath = Paths.get(RowFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(rowPath);
                    ArrayList<InvRows> invoiceLines = new ArrayList<>();
                    for (String lineLine : lineLines) {
                        String[] atrb = lineLine.split(",");
                        String select1 = atrb[0];    
                        String select2 = atrb[1];    
                        String select3 = atrb[2];   
                        String select4 = atrb[3];   
                        int invoiceleble = Integer.parseInt(select1);
                        double Fee = Double.parseDouble(select3);
                        int Number = Integer.parseInt(select4);
                        InvCol invoice = Design.getInvObject(invoiceleble);
                        InvRows ls = new InvRows(select2, Fee, Number, invoice);
                        invoice.getLs().add(ls);
                    }
                }
                InvColTbMod colTbMo = new InvColTbMod(invoicecolumns);
                Design.setColTbMod(colTbMo);
                Design.getInvHTbl().setModel(colTbMo);
                System.out.println("files read");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Design, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(Design, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void genrateInv() {
        ColDil = new InvColDil(Design);
        ColDil.setVisible(true);
    }

    private void CleareInv() {
        int selectedInvoiceIndex = Design.getInvHTbl().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            Design.getInvoicesArray().remove(selectedInvoiceIndex);
            Design.getColTbMod().fireTableDataChanged();

            Design.getInvLTbl().setModel(new InvRowsTbMod(null));
            Design.setLinesArray(null);
            Design.getCustNameLbl().setText("");
            Design.getInvNumLbl().setText("");
            Design.getInvTotalIbl().setText("");
            Design.getInvDateLbl().setText("");
        }
    }

    private void CreatRow() {
        RowDil = new InvRowDil(Design);
        RowDil.setVisible(true);
    }

    private void ClearRow() {
        int selectedLineIndex = Design.getInvLTbl().getSelectedRow();
        int selectedInvoiceIndex = Design.getInvHTbl().getSelectedRow();
        if (selectedLineIndex != -1) {
            Design.getLinesArray().remove(selectedLineIndex);
            InvRowsTbMod lineTableModel = (InvRowsTbMod) Design.getInvLTbl().getModel();
            lineTableModel.fireTableDataChanged();
            Design.getInvTotalIbl().setText("" + Design.getInvoicesArray().get(selectedInvoiceIndex).getInvCount());
            Design.getColTbMod().fireTableDataChanged();
            Design.getInvHTbl().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

    private void Saveing() {
        ArrayList<InvCol> invoicesArray = Design.getInvoicesArray();
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showSaveDialog(Design);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (InvCol invoice : invoicesArray) {
                    headers += invoice.toString();
                    headers += "\n";
                    for (InvRows line : invoice.getLs()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
           
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fc.showSaveDialog(Design);
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                hfw.write(headers);
                lfw.write(lines);
                hfw.close();
                lfw.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Design, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newInvoiceDialogCancel() {
        ColDil.setVisible(false);
        ColDil.dispose();
        ColDil = null;
    }

    private void newInvoiceDialogOK() {
        ColDil.setVisible(false);

        String custName = ColDil.getCNm().getText();
        String str = ColDil.getInvoiceD().getText();
        Date d = new Date();
        try {
            d = InvDesign.dF.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(Design, "Cannot parse date, resetting to today.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }

        int invNum = 0;
        for (InvCol inv : Design.getInvoicesArray()) {
            if (inv.getNm() > invNum) {
                invNum = inv.getNm();
            }
        }
        invNum++;
        InvCol newInv = new InvCol(invNum, custName, d);
        Design.getInvoicesArray().add(newInv);
        Design.getColTbMod().fireTableDataChanged();
        ColDil.dispose();
        ColDil = null;
    }

    private void newLineDialogCancel() {
        RowDil.setVisible(false);
        RowDil.dispose();
        RowDil = null;
    }

    private void newLineDialogOK() {
        RowDil.setVisible(false);

        String name = RowDil.getPiceNm().getText();
        String select1 = RowDil.getpiceQuantity().getText();
        String select2 = RowDil.getPicePr().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(select1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Design, "Unable To conver number", "Wrong Number Design", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(select2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Design, "Unable To conver price", "Wrong Number Design", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = Design.getInvHTbl().getSelectedRow();
        if (selectedInvHeader != -1) {
            InvCol invHeader = Design.getInvoicesArray().get(selectedInvHeader);
            InvRows line = new InvRows(name, price, count, invHeader);
            //invHeader.getLines().add(line);
            Design.getLinesArray().add(line);
            InvRowsTbMod lineTableModel = (InvRowsTbMod) Design.getInvLTbl().getModel();
            lineTableModel.fireTableDataChanged();
            Design.getColTbMod().fireTableDataChanged();
        }
        Design.getInvHTbl().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        RowDil.dispose();
        RowDil = null;
    }

}
