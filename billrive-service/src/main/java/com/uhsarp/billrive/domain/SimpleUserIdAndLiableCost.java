/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name="simpleuseridandliablecost")
public class SimpleUserIdAndLiableCost  implements GenericObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Long userId;
    private  float liableCost;
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

 
}

