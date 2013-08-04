/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name="billitementry")
public class BillItemEntry  implements GenericObject{
    
	@Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
	private String itemDescription;//napkin
    
        @Transient
	private Set<UserIdAndLiableCost> userIdAndLiableCost = new HashSet<UserIdAndLiableCost>();
        private int billFinancesId;
//	private BillFinances iteamEntryBillFinances;
	
	//should be set not list 
//	ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();//2->3, 3->3, 4->3

    public BillItemEntry(){
    	
    }

    public BillItemEntry(int itemDescriptionId, String itemDescription,  Set<UserIdAndLiableCost> userIdAndLiableCost,int billFinancesId) {
        this.id = itemDescriptionId;
        this.itemDescription = itemDescription;
        this.billFinancesId = billFinancesId;
        this.userIdAndLiableCost = userIdAndLiableCost;
    }

 


	
    public int getItemDescriptionId() {
        return id;
    }

    public void setItemDescriptionId(int itemDescriptionId) {
        this.id = itemDescriptionId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getBillFinancesId() {
        return billFinancesId;
    }

    public void setBillFinancesId(int billFinancesId) {
        this.billFinancesId = billFinancesId;
    }
    
    

//    public ArrayList<UserIdAndLiableCost> getUserIdAndLiableCost() {
//        return userIdAndLiableCost;
//    }
//
//    public void setUserIdAndLiableCost(ArrayList<UserIdAndLiableCost> userIdAndLiableCost) {
//        this.userIdAndLiableCost = userIdAndLiableCost;
//    }
//
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="billiteamEntryLiab")
//	public Set<UserIdAndLiableCost> getIteamEntryUserIdAndLiableCost() {
//		return iteamEntryUserIdAndLiableCost;
//	}
//
//	public void setIteamEntryUserIdAndLiableCost(
//			Set<UserIdAndLiableCost> iteamEntryUserIdAndLiableCost) {
//		this.iteamEntryUserIdAndLiableCost = iteamEntryUserIdAndLiableCost;
//	}

//	@ManyToOne(fetch=FetchType.LAZY)		//BiDirectional Mapping
//	@JoinColumn(name="billFinanceiteamEntry_id")
//	public BillFinances getIteamEntryBillFinances() {
//		return iteamEntryBillFinances;
//	}
//
//	public void setIteamEntryBillFinances(BillFinances iteamEntryBillFinances) {
//		this.iteamEntryBillFinances = iteamEntryBillFinances;
//	}

    public Set<UserIdAndLiableCost> getUserIdAndLiableCost() {
        return userIdAndLiableCost;
    }

    public void setUserIdAndLiableCost(Set<UserIdAndLiableCost> userIdAndLiableCost) {
        this.userIdAndLiableCost = userIdAndLiableCost;
    }
   
    
    
    
}
