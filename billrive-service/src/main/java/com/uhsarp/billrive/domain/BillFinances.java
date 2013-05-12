/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uhsarp
 */
class BillFinances {
    
    double billPayerId;
    List<BillItemEntry> billItemEntry = new LinkedList<BillItemEntry>();
    double billTotal;

    public BillFinances(double billPayerId, double billTotal) {
        this.billPayerId = billPayerId;
        this.billTotal = billTotal;
    }

    public double getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(double billPayerId) {
        this.billPayerId = billPayerId;
    }

    public List<BillItemEntry> getBillItemEntry() {
        return billItemEntry;
    }

    public void setBillItemEntry(List<BillItemEntry> billItemEntry) {
        this.billItemEntry = billItemEntry;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

 
    
}
