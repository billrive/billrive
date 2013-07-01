/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uhsarp
 */
@Repository("neo4jDAO")
public class Neo4jDAO  {

    public List<Bill> getBills(int userId) {
       
       
        
        
        Set<UserIdAndLiableCost> userIdAndLiableCost =  new HashSet<UserIdAndLiableCost>();
        Set<UserIdAndLiableCost> userIdAndLiableCost1 =  new HashSet<UserIdAndLiableCost>();
        userIdAndLiableCost.add(new UserIdAndLiableCost( 2, 10,1));
        userIdAndLiableCost.add(new UserIdAndLiableCost( 3, 20,1));
        userIdAndLiableCost1.add(new UserIdAndLiableCost( 4, 50,1));
        userIdAndLiableCost1.add(new UserIdAndLiableCost( 5, 40,1));
        
        BillItemEntry simpleBillItemEntry = new BillItemEntry(1, "simple", userIdAndLiableCost, 1);
        BillItemEntry simpleBillItemEntry1 = new BillItemEntry(1, "simple", userIdAndLiableCost, 1);
       Set<BillItemEntry> billItemEntry =  new HashSet<BillItemEntry>();
        billItemEntry.add(new BillItemEntry(1, "Canola Oil", userIdAndLiableCost,1));
        Set<BillItemEntry> billItemEntry1 =  new HashSet<BillItemEntry>();
         billItemEntry1.add(new BillItemEntry(2,"Taco Bell",  userIdAndLiableCost1,1));
        
         BillFinances billFinances = new BillFinances(1, 30, simpleBillItemEntry, billItemEntry, 1);
         BillFinances billFinances1 = new BillFinances(1, 30, simpleBillItemEntry1, billItemEntry1, 1);
//        BillFinances billFinances1 = new BillFinances(2,90,billItemEntry1,1);
//        billFinances1.setBillSimpleTotals(new BillItemEntry(1, "simple","simple", userIdAndLiableCost));
         List<Bill> rtnval = new ArrayList<Bill>();
        if(1 == userId)
        {
        Bill bill = new Bill("Walmart",new DateTime(2013,2,3,1,1) , 1, "Walmart at 11th and Bedords", billFinances, 1, 1);
                rtnval.add(bill);
        }
        else if(2==userId)
        {
        Bill bill1 = new Bill("Costco", new DateTime(2012,1,4,1,1), 2, "Lost bill", billFinances1, 2, 1);
                rtnval.add(bill1);
        }
        return rtnval;
    }
    
     public List<Group> getGroups(int userId) {
         List<Friend> lsFriends = new ArrayList<Friend>();
         Friend sam = new Friend(10, "sam", "jumbo","sam@gmail.com", true );
         lsFriends.add(sam);
         Friend ken = new Friend(12, "ken", "dumbo", "ken@gmail.com", false);
         lsFriends.add(ken);
         
         Group g1 = new Group(1, "LasVegas", "spring 2013", 2, lsFriends );
         List<Group> rtnval = new ArrayList<Group>();
         rtnval.add(g1);
         return rtnval;
     }
    
    
}
