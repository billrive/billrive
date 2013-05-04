/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
 */
public class Bill {
    
    double id;
    String title;
    DateTime date;
    double billPayerId;
    String notes;
    BillFinances billFrinances;
    double groupId;
    
    

    public String getBillId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
