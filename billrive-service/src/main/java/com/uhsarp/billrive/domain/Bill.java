/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
 */
public class Bill {
    
    double id;
    String title;
    DateTime date;
    double billPayerId;
    String notes;
    BillFinances billFinances;
    double groupId;

    public Bill(double id, String title, DateTime date, double billPayerId, String notes, BillFinances billFinances, double groupId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.billPayerId = billPayerId;
        this.notes = notes;
        this.billFinances = billFinances;
        this.groupId = groupId;
    }
    
    

//    public String getBillId() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public double getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(double billPayerId) {
        this.billPayerId = billPayerId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BillFinances getBillFinances() {
        return billFinances;
    }

    public void setBillFinances(BillFinances billFinances) {
        this.billFinances = billFinances;
    }

    public double getGroupId() {
        return groupId;
    }

    public void setGroupId(double groupId) {
        this.groupId = groupId;
    }


    
}
