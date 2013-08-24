/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andromeda
 */
//@Repository("billDao")
public class BillDaoImpl extends GenericDaoImpl<Bill> implements BillDao{

    public Bill getBill(Long id) {
        return this.get(id);
    }
    
}
