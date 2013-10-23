/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name = "balance")
public class Balance implements GenericObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private Long groupId;
    private Long userId_gets;
    private Long userId_gives;
    private BigDecimal  amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId_gets() {
        return userId_gets;
    }

    public void setUserId_gets(Long userId_gets) {
        this.userId_gets = userId_gets;
    }

    public Long getUserId_gives() {
        return userId_gives;
    }

    public void setUserId_gives(Long userId_gives) {
        this.userId_gives = userId_gives;
    }

    public BigDecimal  getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal  amount) {
        this.amount = amount;
    }
    
    
    
}
