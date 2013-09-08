/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import javax.persistence.*;

/**
 *
 * @author Prashanth Batchu
 */
@Entity
@Table(name="simpleuseridandliablecost")
public class SimpleUserIdAndLiableCost  implements GenericObject {
    private  Long userId;
    private  float liableCost;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    private Long billSimpleEntryId;

    public SimpleUserIdAndLiableCost() {
        
    }
  

    public SimpleUserIdAndLiableCost(Long userId, Long liableCost, Long billItemEntryID) {
        this.userId = userId;
        this.liableCost = liableCost;
        this.billSimpleEntryId = billItemEntryID;
    }
    

    

	
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getLiableCost() {
        return liableCost;
    }

    public void setLiableCost(Long liableCost) {
        this.liableCost = liableCost;
    }
    
    
    

//	@ManyToOne(fetch=FetchType.LAZY)		//BiDirectional Mapping
//	@JoinColumn(name="billIteamLiableCost")
//	public BillItemEntry getBilliteamEntryLiab() {
//		return billiteamEntryLiab;
//	}
//
//	public void setBilliteamEntryLiab(BillItemEntry billiteamEntryLiab) {
//		this.billiteamEntryLiab = billiteamEntryLiab;
//	}

    public Long getBillItemEntryID() {
        return billSimpleEntryId;
    }

    public void setBillItemEntryID(Long billItemEntryID) {
        this.billSimpleEntryId = billItemEntryID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillSimpleEntryId() {
        return billSimpleEntryId;
    }

    public void setBillSimpleEntryId(Long billSimpleEntryId) {
        this.billSimpleEntryId = billSimpleEntryId;
    }

 
}

