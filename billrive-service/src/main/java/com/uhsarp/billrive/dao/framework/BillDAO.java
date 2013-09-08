/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.uhsarp.billrive.domain.Bill;
import java.util.List;

/**
 *
 * @author Prashanth Batchu
 */
public interface BillDAO extends GenericDAO<Bill,Long> {
    List<Bill> getBillsByGroupId(Long groupId);
}
