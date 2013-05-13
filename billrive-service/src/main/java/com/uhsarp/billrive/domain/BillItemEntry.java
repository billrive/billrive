/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;

/**
 *
 * @author uhsarp
 */
public class BillItemEntry {
    
    double itemDescriptionId;
    String itemDescription;
    ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();

    
    
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

    public ArrayList<UserIdAndLiableCost> getUserIdAndLiableCost() {
        return userIdAndLiableCost;
    }

    public void setUserIdAndLiableCost(ArrayList<UserIdAndLiableCost> userIdAndLiableCost) {
        this.userIdAndLiableCost = userIdAndLiableCost;
    }
   
    
    
    
}
