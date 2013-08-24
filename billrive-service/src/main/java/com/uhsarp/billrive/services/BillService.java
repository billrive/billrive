/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services;

import com.uhsarp.billrive.dao.BillDao;
import com.uhsarp.billrive.dao.GenericDao;
import com.uhsarp.billrive.dao.MySqlDao;
import com.uhsarp.billrive.domain.Bill;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("billService")
public class BillService {

    @Resource(name="genericDao")
    GenericDao genericDao;
    
    @Resource(name="billDao")
    BillDao billDao;
    
    @Autowired
    MySqlDao mySqlDao;
    public List<Bill> getBills(int userId) {
//        mySqlDao.saveBill();
        //List<Bill> rtnval = mySqlDao.getBills();
//        rtnval=genericDAO.getBills(userId);
        //test
        List<Bill> bills = new ArrayList<Bill>();
        bills.add(billDao.getBill(2l));
        bills.add(billDao.getBill(4l));
        
        return bills;
    }

    public Bill getBillById(Long id) {
        return (Bill) genericDao.get(id);
    }

    public Bill createBill(Bill bill_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill updateBill(Bill bill_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteBill(String billId_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
