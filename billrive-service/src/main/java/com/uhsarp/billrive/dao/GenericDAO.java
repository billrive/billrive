/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashanth
 */
 public interface GenericDAO {
     
    List<Bill> getBills(double userId);
    
}
