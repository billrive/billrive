/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.io.Serializable;

import javax.persistence.*;

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
    private int id;
    private String title;//walmart
    private DateTime billDate;
    private int billPayerId;
    private String notes;
//    private Group groupBills;
//    private User userBill;
    private BillFinances billFinances;
    private int userId;
    private int groupId;

    //Guess we dont need this after mapping oneTOmany
    public Bill() {
    }

    public Bill(String title, DateTime date, int billPayerId, String notes, BillFinances billFinances, int userId, int groupId) {
        this.title = title;
        this.billDate = date;
        this.billPayerId = billPayerId;
        this.notes = notes;
        this.billFinances = billFinances;
        this.userId = userId;
        this.groupId = groupId;
    }

    
    

    
    

//    public Bill(String title,int billPayerId, DateTime billDate, 
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public DateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(DateTime billDate) {
        this.billDate = billDate;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
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
    @OneToOne(targetEntity = BillFinances.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "billFinanceId", referencedColumnName = "billPayerId")
    public BillFinances getBillFinances() {
        return billFinances;
    }

    public void setBillFinances(BillFinances billFinances) {
        this.billFinances = billFinances;
    }
}
