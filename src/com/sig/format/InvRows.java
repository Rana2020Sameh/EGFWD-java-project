
package com.sig.format;

public class InvRows {
     private InvCol col;
    private String pice;
    private double Fess;
    private int quantity;

    public InvRows() {
    }

    public InvRows(InvCol col, String pice, double Fess, int quantity) {
        this.col = col;
        this.pice = pice;
        this.Fess = Fess;
        this.quantity = quantity;
    }

    public InvRows(String select2, double Fee, int Number, InvCol invoice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public InvCol getCol() {
        return col;
    }

    public void setCol(InvCol col) {
        this.col = col;
    }

    public String getPice() {
        return pice;
    }

    public void setPice(String pice) {
        this.pice = pice;
    }

    public double getFess() {
        return Fess;
    }

    public void setFess(double Fess) {
        this.Fess = Fess;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    
    
    public double getRowsCount() {
        return Fess * quantity;
    }

    @Override
    public String toString() {
        return col.getNm() + "," + pice + "," + Fess + "," + quantity;
    }

    
    
}
