/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.Group;
import java.util.List;

/**
 *
 * @author Prashanth
 */
 public interface GenericDAO {
     
    List<Bill> getBills(int userId);
    List<Group> getGroups(int userId);
}
