/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.domain.Friend;
import com.uhsarp.billrive.domain.Payment;
import com.uhsarp.billrive.domain.UserFinances;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sravan
 */
@Repository("oracleDAO")
public class OracleDAO implements GenericDAO{

    public List<Bill> getBills(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> getGroups(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Group createGroup(int groupId, int userId)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    public Group activateFriends(List<Integer> friendIds, int groupId)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    public Group deactivateFriends(List<Integer> friendIds, int groupId)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
     public  Friend createFriend(Friend friendObj)
     {
         throw new UnsupportedOperationException("Not supported yet"); 
     }
     
        public  Friend updateFriendInfo(Friend friendObj)
         {
                      throw new UnsupportedOperationException("Not supported yet"); 

         }
     public void activateFriends(List<Integer> friendIds)
     {
                               throw new UnsupportedOperationException("Not supported yet"); 

     }
     public void deActivateFriends(List<Integer> friendIds)
     {
                               throw new UnsupportedOperationException("Not supported yet"); 

     }

     /**
     *
     * @param userId
     * @param paymentObj
     */
    public Payment createPayment(int userId, Payment paymentObj)
     {
                                        throw new UnsupportedOperationException("Not supported yet"); 

     }




}
