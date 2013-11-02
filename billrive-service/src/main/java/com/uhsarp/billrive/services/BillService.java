/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services;

import com.uhsarp.billrive.domain.Bill;
import java.util.List;

/**
 *
 * @author Prashanth Batchu
 */
public interface BillService {

     List<Bill> getBills(Long userId);

     Bill getBillById(Long id);

     Bill addBill(Bill bill_p);

     Bill editBill(Bill bill_p);

     Boolean deleteBill(Long billId_p);
}
