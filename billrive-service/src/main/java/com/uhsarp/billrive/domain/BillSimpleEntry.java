/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name="billsimpleentry")
public class BillSimpleEntry  implements GenericObject{
    
	@Id
         @Column(name="billId") 
        private Long billId;
        @Column(columnDefinition="TEXT")
	private String itemDescription;//napkin
    
//        private Long billId;
//        @OneToMany(fetch=FetchType.EAGER,targetEntity = SimpleUserIdAndLiableCost.class, cascade = CascadeType.ALL,mappedBy="billSimpleEntryId")
//        @JoinColumn(name = "billId", referencedColumnName = "billSimpleEntryId")
//        @Transient
         @OneToMany(cascade=CascadeType.ALL,mappedBy="billSimpleEntryId",fetch = FetchType.EAGER)  
        @PrimaryKeyJoinColumn 
	private List<SimpleUserIdAndLiableCost> userIdAndLiableCost = new ArrayList<SimpleUserIdAndLiableCost>();
        
//	private BillFinances iteamEntryBillFinances;
	
	//should be set not list 
//	ArrayList<SimpleUserIdAndLiableCost> userIdAndLiableCost = new ArrayList<SimpleUserIdAndLiableCost>();//2->3, 3->3, 4->3

    public BillSimpleEntry(){
    	
    }

    public BillSimpleEntry(Long itemDescriptionId, String itemDescription,  List<SimpleUserIdAndLiableCost> userIdAndLiableCost) {
        this.billId = itemDescriptionId;
        this.itemDescription = itemDescription;
       
        this.userIdAndLiableCost = userIdAndLiableCost;
    }

 


	
    public Long getItemDescriptionId() {
        return billId;
    }

    public void setItemDescriptionId(Long itemDescriptionId) {
        this.billId = itemDescriptionId;
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
    

//    public ArrayList<SimpleUserIdAndLiableCost> getUserIdAndLiableCost() {
//        return userIdAndLiableCost;
//    }
//
//    public void setUserIdAndLiableCost(ArrayList<SimpleUserIdAndLiableCost> userIdAndLiableCost) {
//        this.userIdAndLiableCost = userIdAndLiableCost;
//    }
//
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="billiteamEntryLiab")
//	public List<SimpleUserIdAndLiableCost> getIteamEntryUserIdAndLiableCost() {
//		return iteamEntryUserIdAndLiableCost;
//	}
//
//	public void setIteamEntryUserIdAndLiableCost(
//			List<SimpleUserIdAndLiableCost> iteamEntryUserIdAndLiableCost) {
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

    public List<SimpleUserIdAndLiableCost> getUserIdAndLiableCost() {
        return userIdAndLiableCost;
    }

    public void setUserIdAndLiableCost(List<SimpleUserIdAndLiableCost> userIdAndLiableCost) {
        this.userIdAndLiableCost = userIdAndLiableCost;
    }

    public Long getId() {
        return billId;
    }

    public void setId(Long id) {
        this.billId = id;
    }

//    public Long getBillId() {
//        return billId;
//    }
//
//    public void setBillId(Long billId) {
//        this.billId = billId;
//    }
//   
    
    
    
}
