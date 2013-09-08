/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author Prashanth Batchu
 */
@Entity
@Table(name="\"payment\"")
public class Payment  implements GenericObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    
    private long payerId;
    private long receiverId;
    private long paidAmount;
    private long groupId;
    @Column(columnDefinition="TEXT")
    private String notes;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime payDate;

    public long getPayerId() {
        return payerId;
    }

    public void setPayerId(long payerId) {
        this.payerId = payerId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(DateTime payDate) {
        this.payDate = payDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    
    
            
    
}
