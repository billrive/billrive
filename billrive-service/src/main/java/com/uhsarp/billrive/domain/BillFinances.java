/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uhsarp
 */
public class BillFinances {
    
    int billPayerId;//2
    List<BillItemEntry> billItemEntry = new ArrayList<BillItemEntry>();//watermelon,napkins
    int billTotal;

    public BillFinances(int billPayerId, int billTotal,List<BillItemEntry> billItemEntry) {
        this.billPayerId = billPayerId;
        this.billTotal = billTotal;
        this.billItemEntry=billItemEntry;
    }

 

    public int getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(int billPayerId) {
        this.billPayerId = billPayerId;
    }

    public List<BillItemEntry> getBillItemEntry() {
        return billItemEntry;
    }

    public void setBillItemEntry(List<BillItemEntry> billItemEntry) {
        this.billItemEntry = billItemEntry;
    }

    public int getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

 
    
}
