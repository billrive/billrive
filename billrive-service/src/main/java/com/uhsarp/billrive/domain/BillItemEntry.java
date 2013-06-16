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
    
    int itemDescriptionId;
    String itemTitle;
    String itemDescription;//napkin
    ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();//2->3, 3->3, 4->3

    public BillItemEntry(int itemDescriptionId, String itemTitle, String itemDescription, ArrayList<UserIdAndLiableCost> userIdAndLiableCost) {
        this.itemDescriptionId = itemDescriptionId;
        this.itemDescription = itemDescription;
        this.userIdAndLiableCost=userIdAndLiableCost;
        this.itemTitle = itemTitle;
    }


    
    
    public int getItemDescriptionId() {
        return itemDescriptionId;
    }

    public void setItemDescriptionId(int itemDescriptionId) {
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
