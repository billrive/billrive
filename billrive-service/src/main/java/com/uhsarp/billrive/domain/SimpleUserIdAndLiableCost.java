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
@Table(name="simpleuseridandliablecost")
//@SecondaryTable(name = "user", pkJoinColumns=@PrimaryKeyJoinColumn(name="id", referencedColumnName="userId"))
public class SimpleUserIdAndLiableCost  implements GenericObject {
    private  Long userId;
    private  BigDecimal  liableCost;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    private Long billSimpleEntryId;
//    @Column(table="user", name="fName")
//    private String fName;
//    @Column(table="user", name="lName")
//    private String lName;
  
        @Basic
@Column(columnDefinition = "BIT", length = 1)
    private boolean isActive;

    public SimpleUserIdAndLiableCost() {
        
    }
  

    public SimpleUserIdAndLiableCost(Long userId, BigDecimal  liableCost, Long billItemEntryID) {
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
 
}

