/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.uhsarp.billrive.domain.Bill;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanth Batchu
 */
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public interface BillDAO extends GenericDAO<Bill,Long> {
    List<Bill> getBillsByGroupId(Long groupId);
    Bill getBillByBillId(Long billId);
}
