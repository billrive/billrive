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
    
    private  int userId;
    private  float liableCost;
    private int billItemEntryID;

    public UserIdAndLiableCost() {
        
    }
  

    public UserIdAndLiableCost(int userId, int liableCost, int billItemEntryID) {
        this.userId = userId;
        this.liableCost = liableCost;
        this.billItemEntryID = billItemEntryID;
    }
    

    

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getLiableCost() {
        return liableCost;
    }

    public void setLiableCost(int liableCost) {
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

    public int getBillItemEntryID() {
        return billItemEntryID;
    }

    public void setBillItemEntryID(int billItemEntryID) {
        this.billItemEntryID = billItemEntryID;
    }

 
}

