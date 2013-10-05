/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;


import com.uhsarp.billrive.web.utils.CustomDateSerializer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import org.joda.time.DateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    private String title;//walmart
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime billDate;
    private Long billPayerId;
    private String notes;
    private Long billCreaterId;
    private Long groupId;
    private BigDecimal  billTotal;
   
//    @OneToOne(cascade=CascadeType.ALL,mappedBy="billId",fetch = FetchType.EAGER)
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private BillSimpleEntry billSimpleEntry;
   
    //@Transient
    @OneToMany(cascade=CascadeType.ALL,mappedBy="billId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BillItemEntry> billItemEntry= new ArrayList();
  
    //Guess we dont need this after mapping oneTOmany
    public Bill() {
    }

//    public Bill(String title, DateTime date, Long billPayerId, String notes, BillFinances billFinances, Long billCreaterId, Long groupId) {
    public Bill(String title, DateTime date, Long billPayerId, String notes,  Long userId, Long groupId) {
        this.title = title;
        this.billDate = date;
        this.billPayerId = billPayerId;
        this.notes = notes;
        
        this.billCreaterId = userId;
        this.groupId = groupId;
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
    /**
     *
     * @return
     */
//    @JsonSerialize(using = CustomDateSerializer.class)
    public DateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(DateTime billDate) {
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

    //	@ManyToOne(fetch=FetchType.EAGER)		//BiDirectional Mapping
    //	@JoinColumn(name="group_id")
    //	public Group getGroup() {
    //		return group;
    //	}
    //
    //	public void setGroup(Group group) {
    //		this.group = group;
    //	}
    //    @ManyToOne(fetch = FetchType.EAGER)		//BiDirectional Mapping
    //    @JoinColumn(name = "group_id")
    //    public Group getGroupBills() {
    //        return groupBills;
    //    }
    //
    //    public void setGroupBills(Group groupBills) {
    //        this.groupBills = groupBills;
    //    }
    //
    //    @ManyToOne(fetch = FetchType.EAGER)		//BiDirectional Mapping
    //    @JoinColumn(name = "user_id")
    //    public User getuserBill() {
    //        return userBill;
    //    }
    //
    //    public void setuserBill(User userBill) {
    //        this.userBill = userBill;
    //    }
    //	@ManyToOne(fetch=FetchType.EAGER)		//BiDirectional Mapping
    //	@JoinColumn(name="billFinance_id")
    //    public BillFinances getBillFinances() {
    //        return billFinances;
    //    }
    //
    //    public void setBillFinances(BillFinances billFinances) {
    //        this.billFinances = billFinances;
    //    }
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
