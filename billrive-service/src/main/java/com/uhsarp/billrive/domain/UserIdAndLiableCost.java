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
@Table(name="userIdAndLiableCost")
public class UserIdAndLiableCost  implements GenericObject {
    
    private  Long userId;
    private  float liableCost;
    private Long billItemEntryID;

    public UserIdAndLiableCost() {
        
    }
  

    public UserIdAndLiableCost(Long userId, Long liableCost, Long billItemEntryID) {
        this.userId = userId;
        this.liableCost = liableCost;
        this.billItemEntryID = billItemEntryID;
    }
    

    

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
        return billItemEntryID;
    }

    public void setBillItemEntryID(Long billItemEntryID) {
        this.billItemEntryID = billItemEntryID;
    }

 
}

