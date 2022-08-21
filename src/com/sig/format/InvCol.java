
package com.sig.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvCol {
        private Date invDate;
       private String custNm;
       private int Nm;
      private ArrayList<InvRows> ls;
      private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public InvCol() {
    }

    public InvCol(int Nm, String custNm, Date invDate) {
        this.Nm = Nm;
        this.custNm = custNm;
        this.invDate = invDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getNm() {
        return Nm;
    }

    public void setNm(int Nm) {
        this.Nm = Nm;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public ArrayList<InvRows> getLs() {
        if (ls == null) {
            ls = new ArrayList<>();
        }
        return ls;
    }

    public void setLs(ArrayList<InvRows> ls) {
        this.ls = ls;
    }
    
    public double getInvCount() {
        double count = 0.0;
        
        for (int i = 0; i < getLs().size(); i++) {
            count += getLs().get(i).getRowsCount();
        }
        
        return count;
    }

    @Override
    public String toString() {
        return Nm + "," + df.format(invDate) + "," + custNm;
    }
    
}
