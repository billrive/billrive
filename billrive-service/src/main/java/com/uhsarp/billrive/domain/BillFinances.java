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
class BillFinances {
    
    double billPayerId;
    List<BillItemEntry> billItemEntry = new LinkedList<BillItemEntry>();
    double billTotal;
    
    
}
