/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.LinkedList;

/**
 *
 * @author Prashanth
 */
 public interface GenericDAO {
     
    LinkedList<Bill> getBills(double userId);
    
}
