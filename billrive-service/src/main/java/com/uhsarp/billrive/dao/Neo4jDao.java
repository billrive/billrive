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
//@Repository("neo4jDao")
public class Neo4jDao  {

    public List<Bill> getBills(int userId) {
       
       
        
        
//        List<UserIdAndLiableCost> userIdAndLiableCost =  ArrayList<UserIdAndLiableCost>();
//        List<UserIdAndLiableCost> userIdAndLiableCost1 =  ArrayList<UserIdAndLiableCost>();
//        userIdAndLiableCost.add(new UserIdAndLiableCost( 2, 10,1));
//        userIdAndLiableCost.add(new UserIdAndLiableCost( 3, 20,1));
//        userIdAndLiableCost1.add(new UserIdAndLiableCost( 4, 50,1));
//        userIdAndLiableCost1.add(new UserIdAndLiableCost( 5, 40,1));
//        
//        BillItemEntry simpleBillItemEntry = new BillItemEntry(1, "simple", userIdAndLiableCost, 1);
//        BillItemEntry simpleBillItemEntry1 = new BillItemEntry(1, "simple", userIdAndLiableCost, 1);
//       List<BillItemEntry> billItemEntry =  ArrayList<BillItemEntry>();
//        billItemEntry.add(new BillItemEntry(1, "Canola Oil", userIdAndLiableCost,1));
//        List<BillItemEntry> billItemEntry1 =  ArrayList<BillItemEntry>();
//         billItemEntry1.add(new BillItemEntry(2,"Taco Bell",  userIdAndLiableCost1,1));
//        
//         BillFinances billFinances = new BillFinances(1, 30, simpleBillItemEntry, billItemEntry, 1);
//         BillFinances billFinances1 = new BillFinances(1, 30, simpleBillItemEntry1, billItemEntry1, 1);
////        BillFinances billFinances1 = new BillFinances(2,90,billItemEntry1,1);
////        billFinances1.setBillSimpleTotals(new BillItemEntry(1, "simple","simple", userIdAndLiableCost));
//         List<Bill> rtnval = new ArrayList<Bill>();
//        if(1 == userId)
//        {
//        Bill bill = new Bill("Walmart",new DateTime(2013,2,3,1,1) , 1L, "Walmart at 11th and Bedords", 1L, 1L);
//                rtnval.add(bill);
//        }
//        else if(2==userId)
//        {
//        Bill bill1 = new Bill("Costco", new DateTime(2012,1,4,1,1), 2L, "Lost bill", 2L, 1L);
//                rtnval.add(bill1);
//        }
//        return rtnval;
        return null;
    }
    
     public List<Group> getGroups(int userId) {
         List<Friend> lsFriends = new ArrayList<Friend>();
//         Friend sam = new Friend(10, "sam", "jumbo","sam@gmail.com", true );
//         lsFriends.add(sam);
//         Friend ken = new Friend(12, "ken", "dumbo", "ken@gmail.com", false);
//         lsFriends.add(ken);
         //1, "LasVegas", "spring 2013", 2, lsFriends
         Group g1 = new Group();
         List<Group> rtnval = new ArrayList<Group>();
         rtnval.add(g1);
         return rtnval;
     }
    
    
}