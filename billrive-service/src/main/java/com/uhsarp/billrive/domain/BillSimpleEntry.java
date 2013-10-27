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
 * @author Prashanth Batchu
 */
@Entity
@Table(name="billsimpleentry")
public class BillSimpleEntry  implements GenericObject{
    
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)  
        private Long id;
        @Column(columnDefinition="TEXT")
	private String itemDescription;//napkin
    
//        private Long id;
//        @OneToMany(fetch=FetchType.EAGER,targetEntity = SimpleUserIdAndLiableCost.class, cascade = CascadeType.ALL,mappedBy="billSimpleEntryId")
//        @JoinColumn(name = "id", referencedColumnName = "billSimpleEntryId")
//        @Transient
         @OneToMany(cascade=CascadeType.ALL,mappedBy="billSimpleEntryId",fetch = FetchType.EAGER)
	private List<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCost = new ArrayList<SimpleUserIdAndLiableCost>();
        
//	private BillFinances iteamEntryBillFinances;
	
	//should be set not list 
//	ArrayList<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCost = new ArrayList<SimpleUserIdAndLiableCost>();//2->3, 3->3, 4->3

    public BillSimpleEntry(){
    	
    }

    public BillSimpleEntry(Long itemDescriptionId, String itemDescription,  List<SimpleUserIdAndLiableCost> userIdAndLiableCost) {
        this.id = itemDescriptionId;
        this.itemDescription = itemDescription;
       
        this.simpleUserIdAndLiableCost = userIdAndLiableCost;
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
    

//    public ArrayList<SimpleUserIdAndLiableCost> getUserIdAndLiableCost() {
//        return simpleUserIdAndLiableCost;
//    }
//
//    public void setUserIdAndLiableCost(ArrayList<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCost) {
//        this.simpleUserIdAndLiableCost = simpleUserIdAndLiableCost;
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

    //    public Long getBillId() {
    //        return id;
    //    }
    //
    //    public void setBillId(Long id) {
    //        this.id = id;
    //    }
    //   
//    public Long getBillId() {
//        return id;
//    }
//
//    public void setBillId(Long id) {
//        this.id = id;
//    }

    public List<SimpleUserIdAndLiableCost> getSimpleUserIdAndLiableCost() {
        return simpleUserIdAndLiableCost;
    }

    public void setSimpleUserIdAndLiableCost(List<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCost) {
        this.simpleUserIdAndLiableCost = simpleUserIdAndLiableCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
