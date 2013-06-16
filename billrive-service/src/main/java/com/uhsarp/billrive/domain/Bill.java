/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import com.uhsarp.billrive.web.utils.DateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
 */
public class Bill {
    
    int id;
    String title;//walmart
    DateTime date; 
    int billPayerId;
    String notes;
    BillFinances billFinances;
    int groupId;

    public Bill(int id, String title, DateTime date, int billPayerId, String notes, BillFinances billFinances, int groupId) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  @JsonSerialize(using=DateSerializer.class )  
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public int getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(int billPayerId) {
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    
}
