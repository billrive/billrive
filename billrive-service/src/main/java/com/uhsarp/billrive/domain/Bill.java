/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Prashanth Batchu
 */
@Entity
@Table(name = "bill")
public class Bill implements GenericObject {

    /**
     *
     */
    private static final long serialVersionUID = -5660869020353250221L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private String title;//walmart

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date billDate;
    private Long billPayerId;
    private String notes;
    private Long billCreaterId;
    private Long groupId;
    private BigDecimal  billTotal;
    
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name="billSimpleEntryId")
    private BillSimpleEntry billSimpleEntry;
   
    @OneToMany(cascade=CascadeType.ALL,mappedBy="billId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BillItemEntry> billItemEntry= new ArrayList();
  

    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @DateFormat(iso =  DateFormat.ISO.DATE_TIME )
    //@JsonSerialize(using = CustomDateSerializer.class)
    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Long getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(Long billPayerId) {
        this.billPayerId = billPayerId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getUserId() {
        return billCreaterId;
    }

    public void setUserId(Long userId) {
        this.billCreaterId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public BillSimpleEntry getBillSimpleEntry() {
        return billSimpleEntry;
    }

    public void setBillSimpleEntry(BillSimpleEntry billSimpleEntry) {
        this.billSimpleEntry = billSimpleEntry;
    }

    public List<BillItemEntry> getBillItemEntry() {
        return billItemEntry;
    }

    public void setBillItemEntry(List<BillItemEntry> billItemEntry) {
        this.billItemEntry = billItemEntry;
    }

    public Long getBillCreaterId() {
        return billCreaterId;
    }

    public void setBillCreaterId(Long billCreaterId) {
        this.billCreaterId = billCreaterId;
    }

    public BigDecimal  getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(BigDecimal  billTotal) {
        this.billTotal = billTotal;
    }
 
}
