/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;

/**
 *
 * @author andromeda
 */
public interface BillDao extends GenericDao<Bill> {
    
    public Bill getBill(Long id);
    
}
