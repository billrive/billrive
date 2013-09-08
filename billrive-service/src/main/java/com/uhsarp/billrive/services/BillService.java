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

     Bill createBill(Bill bill_p);

     Bill updateBill(Bill bill_p);

     void deleteBill(String billId_p);
}
