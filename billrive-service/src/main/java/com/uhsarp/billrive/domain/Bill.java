/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;


import javax.persistence.*;
import org.hibernate.annotations.Type;

import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
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
    @Column
//    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime billDate;
    private Long billPayerId;
    private String notes;
//    private Group groupBills;
//    private User userBill;
    
//    @OneToOne(targetEntity = BillFinances.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "billFinanceId", referencedColumnName = "billPayerId")
//    private BillFinances billFinances;
    private Long userId;
    private Long groupId;

    //Guess we dont need this after mapping oneTOmany
    public Bill() {
    }

//    public Bill(String title, DateTime date, Long billPayerId, String notes, BillFinances billFinances, Long userId, Long groupId) {
    public Bill(String title, DateTime date, Long billPayerId, String notes,  Long userId, Long groupId) {
        this.title = title;
        this.billDate = date;
        this.billPayerId = billPayerId;
        this.notes = notes;
        
        this.userId = userId;
        this.groupId = groupId;
    }

    
    

    
    

//    public Bill(String title,Long billPayerId, DateTime billDate, 
//            String notes, Group group, User userBill,
//            BillFinances billFinancesBills) {
//        super();
//        this.id = id;
//        this.title = title;
//        this.billDate = billDate;
//        this.billPayerId = billPayerId;
//        this.notes = notes;
//        this.groupBills = group;
////        this.userBill = userBill;
//        this.billFinances = billFinancesBills;
//    }

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
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
