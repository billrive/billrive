/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author Prashanth Batchu
 */
@Entity
@Table(name="userIdAndLiableCost")
public class UserIdAndLiableCost  implements GenericObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Long userId;
    private  BigDecimal  liableCost;
    private Long billItemEntryId;
    
    public UserIdAndLiableCost() {
        
    }
  

    public UserIdAndLiableCost(Long userId, BigDecimal  liableCost, Long billItemEntryID) {
        this.userId = userId;
        this.liableCost = liableCost;
        this.billItemEntryId = billItemEntryID;
    }
    

    

	
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal  getLiableCost() {
        return liableCost;
    }

    public void setLiableCost(BigDecimal  liableCost) {
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
        return billItemEntryId;
    }

    public void setBillItemEntryID(Long billItemEntryID) {
        this.billItemEntryId = billItemEntryID;
    }

 
}

