/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
//@Entity
//@Table(name="billfinances")
public class BillFinances  implements GenericObject{
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
	private int billPayerId;//2
	@Transient
	private List<BillItemEntry> billIteamEntry = new ArrayList<BillItemEntry>();
      
        private BillItemEntry simpleBillItemEntry;
//	private List<Bill> billFinanceBills = new ArrayList<Bill>();
//    private User billFinanceOfUser;

	
	//It should be set as they are unique
    private int billTotal;
    private int billId;

    public BillFinances(){
    	
    }

    public BillFinances(int billPayerId, int billTotal, BillItemEntry simpleBillItemEntry, List<BillItemEntry> billIteamEntry, int billId) {
        this.simpleBillItemEntry = simpleBillItemEntry;
        this.billIteamEntry=billIteamEntry;
        this.billTotal = billTotal;
        this.billId = billId;
        this.billPayerId = billPayerId;
    }
  

        public BillFinances(int billPayerId, int billTotal, BillItemEntry simpleBillItemEntry, int billId) {
        this.simpleBillItemEntry = simpleBillItemEntry;
        
        this.billTotal = billTotal;
        this.billId = billId;
        this.billPayerId = billPayerId;
    }
    

//	public BillFinances(int billPayerId, int billTotal, 
//			List<BillItemEntry> billIteamEntry, int billId) {
//		super();
//		this.billPayerId = billPayerId;
//		this.billIteamEntry = billIteamEntry;
////		this.billFinanceBills = billFinanceBills;
////		this.billFinanceOfUser = billFinanceOfUser;
//		this.billTotal = billTotal;
//	}



    public int getBillPayerId() {
        return billPayerId;
    }

    public void setBillPayerId(int billPayerId) {
        this.billPayerId = billPayerId;
    }

   
    public int getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="iteamEntryBillFinances")
	public List<BillItemEntry> getBillIteamEntry() {
		return billIteamEntry;
	}

	public void setBillIteamEntry(List<BillItemEntry> billIteamEntry) {
		this.billIteamEntry = billIteamEntry;
	}

    //    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="billFinancesBills")
    //	public List<Bill> getBillFinanceBills() {
    //		return billFinanceBills;
    //	}
    //
    //	public void setBillFinanceBills(List<Bill> billFinanceBills) {
    //		this.billFinanceBills = billFinanceBills;
    //	}
    //	@ManyToOne(fetch=FetchType.LAZY)		//BiDirectional Mapping
    //	@JoinColumn(name="userBillFinance_id")
    //	public User getBillFinanceOfUser() {
    //		return billFinanceOfUser;
    //	}
    //
    //	public void setBillFinanceOfUser(User billFinanceOfUser) {
    //		this.billFinanceOfUser = billFinanceOfUser;
    //	}
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }





}
