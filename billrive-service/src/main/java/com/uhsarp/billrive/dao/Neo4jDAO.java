/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uhsarp
 */
@Repository("neo4jDAO")
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
        if(1 == userId)
        {
        Bill bill = new Bill(1,"Walmart", new DateTime(2013,2,3,1,1), userId, "Sample Notes", billFinances, userId);
                rtnval.add(bill);
        }
        else if(2==userId)
        {
        Bill bill1 = new Bill(2,"Costco", new DateTime(2014,2,3,1,1), userId, "Second sample Notes", billFinances1, userId);
                rtnval.add(bill1);
        }
        return rtnval;
    }
    
    
    
    //// GROUPS
     public List<Group> getGroups(int userId) {
         List<Integer> lsFriendIds = new ArrayList<Integer>();
         lsFriendIds.add(101);
         lsFriendIds.add(201);
         Group g1 = new Group(1, "LasVegas", "spring 2013", 2, lsFriendIds );
         List<Group> rtnval = new ArrayList<Group>();
         rtnval.add(g1);
         return rtnval;
     }
    
     public Group createGroup(int groupId, int userId){
        Group groupObj = new Group(groupId, userId); //Check if this group name is already there. Can it be done on front end?
        return groupObj;
     }
     
     public Group activateFriends(List<Integer> friendIds, int groupId)
     {
        List<Integer> lsFriendIds = new ArrayList<Integer>();
        lsFriendIds.add(101); //temp
        lsFriendIds.add(201);//temp
        Group groupObj = new Group(1, "LasVegas", "spring 2013", 2, lsFriendIds);//temp
        return groupObj;
        
         //Get LsMemberIds list for groupId.
         //Add friend ids in the list to list LsMemberIds which is an active users list 
         //for the group
                 
     }
     
     public Group deactivateFriends(List<Integer> friendIds, int groupId)
     {
        List<Integer> lsFriendIds = new ArrayList<Integer>();    //Create a list..Lack of persistency
        lsFriendIds.add(101);
        lsFriendIds.add(201);
        Group groupObj = new Group(1, "LasVegas", "spring 2013", 2, lsFriendIds);
        //get the list of friends..and delete.
        for(int i=0;i<friendIds.size();i++)
        {
           //Call remove from lsFriendIds
           lsFriendIds.remove(friendIds.get(i));
        }
         return groupObj;
         //Remove the list of friendIds from LsMemberIds list.
     }
     
     public void activateGroups(List<Integer> groupIds, int userId)
     {
        List<Integer> lsGroupIds = new ArrayList<Integer>();    //Create a list..Lack of persistency
        lsGroupIds.add(1);
        lsGroupIds.add(2);

        //Set active flag
     }
     public void deactiveGroups(List<Integer> groupIds, int userId)
     {
         //set inactive flag
     }
     
  /////////FRIEND
     
     public Friend createFriend(Friend friendObj)
     {
         Friend friend = new Friend(1, friendObj.getLastName(), friendObj.getFirstName(), friendObj.getEmailId(), friendObj.isUserActive());
         return friend;
     }
     
     public void activateFriends(List<Integer> friendIds)
     {
         //set active flag
     }
     
     public void deActivateFriends(List<Integer> friendIds)
     {
         //set inactive flag
     }
     
     public Friend updateFriendInfo(Friend friendObj)
     {
         return friendObj;
     }
     //activate Friends
     //inactivate Friends
     //Edit friend info
     
      /**
     *
     * @param userId
     * @param paymentObj
     */
    public Payment createPayment(int userId, Payment paymentObj)
      {
          Payment payment = new Payment (userId, paymentObj.getReceiverId(), 
                  paymentObj.getTransactionAmount(),paymentObj.getPaymentDescription(), paymentObj.getTransactionDate());
          return payment;
      }
     
     
}
