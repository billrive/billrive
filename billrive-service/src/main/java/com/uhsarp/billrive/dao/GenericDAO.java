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

/**
 *
 * @author Prashanth
 */
 public interface GenericDAO {
     
    List<Bill> getBills(int userId);
    List<Group> getGroups(int userId);
    Group createGroup(int groupId, int userId);
    Group activateFriends(List<Integer> friendIds, int groupId);
    Group deactivateFriends(List<Integer> friendIds, int groupId);
    Friend createFriend(Friend friendObj);
    Friend updateFriendInfo(Friend friendObj);
    void activateFriends(List<Integer> friendIds);
    void deActivateFriends(List<Integer> friendIds);


    Payment createPayment(int userId, Payment paymentObj);

}
