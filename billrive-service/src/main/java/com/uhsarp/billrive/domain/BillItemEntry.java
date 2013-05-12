/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uhsarp
 */
class BillItemEntry {
    
    double itemDescriptionId;
    String itemDescription;
    List<UserIdAndLiableCost> userIdAndLiableCost = new LinkedList<UserIdAndLiableCost>();

    public BillItemEntry(double itemDescriptionId, String itemDescription) {
        this.itemDescriptionId = itemDescriptionId;
        this.itemDescription = itemDescription;
    }

    
    
    public double getItemDescriptionId() {
        return itemDescriptionId;
    }

    public void setItemDescriptionId(double itemDescriptionId) {
        this.itemDescriptionId = itemDescriptionId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public List<UserIdAndLiableCost> getUserIdAndLiableCost() {
        return userIdAndLiableCost;
    }

    public void setUserIdAndLiableCost(List<UserIdAndLiableCost> userIdAndLiableCost) {
        this.userIdAndLiableCost = userIdAndLiableCost;
    }
   
    
    
    
}
