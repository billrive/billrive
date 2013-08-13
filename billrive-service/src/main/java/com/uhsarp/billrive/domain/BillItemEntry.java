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
@Entity
@Table(name="billitementry")
public class BillItemEntry  implements GenericObject{
    
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)  
        private Long id;
        @Column(columnDefinition="TEXT")
	private String itemDescription;//napkin
    
        @Transient
	private List<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();
        
//	private BillFinances iteamEntryBillFinances;
	
	//should be set not list 
//	ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();//2->3, 3->3, 4->3

    public BillItemEntry(){
    	
    }

    public BillItemEntry(Long itemDescriptionId, String itemDescription,  List<UserIdAndLiableCost> userIdAndLiableCost) {
        this.id = itemDescriptionId;
        this.itemDescription = itemDescription;
       
        this.userIdAndLiableCost = userIdAndLiableCost;
    }

 


	
    public Long getItemDescriptionId() {
        return id;
    }

    public void setItemDescriptionId(Long itemDescriptionId) {
        this.id = itemDescriptionId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

//    public Long getBillFinancesId() {
//        return billFinancesId;
//    }
//
//    public void setBillFinancesId(Long billFinancesId) {
//        this.billFinancesId = billFinancesId;
//    }
//    
    

//    public ArrayList<UserIdAndLiableCost> getUserIdAndLiableCost() {
//        return userIdAndLiableCost;
//    }
//
//    public void setUserIdAndLiableCost(ArrayList<UserIdAndLiableCost> userIdAndLiableCost) {
//        this.userIdAndLiableCost = userIdAndLiableCost;
//    }
//
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="billiteamEntryLiab")
//	public List<UserIdAndLiableCost> getIteamEntryUserIdAndLiableCost() {
//		return iteamEntryUserIdAndLiableCost;
//	}
//
//	public void setIteamEntryUserIdAndLiableCost(
//			List<UserIdAndLiableCost> iteamEntryUserIdAndLiableCost) {
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

    public List<UserIdAndLiableCost> getUserIdAndLiableCost() {
        return userIdAndLiableCost;
    }

    public void setUserIdAndLiableCost(List<UserIdAndLiableCost> userIdAndLiableCost) {
        this.userIdAndLiableCost = userIdAndLiableCost;
    }
   
    
    
    
}
