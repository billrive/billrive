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
@Table(name = "simpleuseridandliablecost")
public class SimpleUserIdAndLiableCost implements GenericObject {

    private Long userId;
    private BigDecimal liableCost;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long billSimpleEntryId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private UserBare user;
    @Basic
    @Column(columnDefinition = "BIT", length = 1)
    private Boolean isActive;

    public SimpleUserIdAndLiableCost() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getLiableCost() {
        return liableCost;
    }

    public void setLiableCost(BigDecimal liableCost) {
        this.liableCost = liableCost;
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

    public UserBare getUser() {
        return user;
    }

    public void setUser(UserBare user) {
        this.user = user;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
