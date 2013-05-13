/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("neo4jDAO")
public class Neo4jDAO implements GenericDAO {

    public List<Bill> getBills(int userId) {
       
       
        
        
        ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();
        ArrayList<UserIdAndLiableCost> userIdAndLiableCost1 = new ArrayList<UserIdAndLiableCost>();
        userIdAndLiableCost.add(new UserIdAndLiableCost( 2, 10));
        userIdAndLiableCost.add(new UserIdAndLiableCost( 3, 20));
        userIdAndLiableCost1.add(new UserIdAndLiableCost( 4, 50));
        userIdAndLiableCost1.add(new UserIdAndLiableCost( 5, 40));
        
        
        List<BillItemEntry> billItemEntry = new ArrayList<BillItemEntry>();
        billItemEntry.add(new BillItemEntry(1, "Canola Oil", userIdAndLiableCost));
        List<BillItemEntry> billItemEntry1 = new ArrayList<BillItemEntry>();
         billItemEntry.add(new BillItemEntry(2, "Taco Bell", userIdAndLiableCost1));
        
         BillFinances billFinances = new BillFinances(1,30,billItemEntry);
        BillFinances billFinances1 = new BillFinances(2,90,billItemEntry1);
         List<Bill> rtnval = new ArrayList<Bill>();
        
        Bill bill = new Bill(1,"Walmart", new DateTime(2013,2,3,1,1), userId, "Sample Notes", billFinances, userId);
        Bill bill1 = new Bill(2,"Costco", new DateTime(2014,2,3,1,1), userId, "Second sample Notes", billFinances1, userId);
        
        rtnval.add(bill);
        rtnval.add(bill1);
        return rtnval;
    }
    
}
