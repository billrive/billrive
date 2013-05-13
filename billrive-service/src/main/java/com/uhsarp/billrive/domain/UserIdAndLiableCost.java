/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

/**
 *
 * @author uhsarp
 */
public class UserIdAndLiableCost {
    
    private  int userId;
    private  int liableCost;

    public UserIdAndLiableCost(int userId, int liableCost) {
        this.userId = userId;
        this.liableCost = liableCost;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLiableCost() {
        return liableCost;
    }

    public void setLiableCost(int liableCost) {
        this.liableCost = liableCost;
    }

 
}

