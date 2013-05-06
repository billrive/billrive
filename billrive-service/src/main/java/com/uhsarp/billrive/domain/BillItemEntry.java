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
   
    
}
