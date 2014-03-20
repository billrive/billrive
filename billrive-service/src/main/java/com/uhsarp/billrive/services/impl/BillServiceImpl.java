/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services.impl;

//import com.uhsarp.billrive.dao.GenericDao;
//import com.uhsarp.billrive.dao.MySqlDao;
import com.uhsarp.billrive.dao.framework.BillDAO;
import com.uhsarp.billrive.dao.framework.GroupDAO;
import com.uhsarp.billrive.dao.framework.UserDAO;
import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.User;
import com.uhsarp.billrive.services.BalanceService;
import com.uhsarp.billrive.services.BillService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanth Batchu
 */
@Service("billService")
public class BillServiceImpl implements BillService {
    
//    @Resource(name="genericDao")
//    GenericDao genericDao;
    
//    @Resource(name="billDao")
//    BillDao billDao;
    
    @Resource(name="billDAO")
    BillDAO billDAO;
    
    @Resource(name="groupDAO")
    GroupDAO groupDAO;
    
    @Resource(name="userDAO")
    UserDAO userDAO;
    
    @Autowired
    BalanceService balanceService;
//    @Autowired
//    MySqlDao mySqlDao;
    public List<Bill> getBills(Long userId) {
         User user = (User) userDAO.getUserByUserId(userId);
        
//       Group group = (Group) groupDAO.findGroupByGroupId(userId);
//        mySqlDao.saveBill();
        //List<Bill> rtnval = mySqlDao.getBills();
//        rtnval=genericDAO.getBills(userId);
        //test
        
//        groupDAO.findGroupId(userId);
//       List<Bill> bills = billDAO.getBillsByGroupId(userId);
//        List<Bill> bills = new ArrayList<Bill>();
//        bills.add(billDao.getBill(2l));
//        bills.add(billDao.getBill(4l));
        
        return null;
    }

    public Bill getBillById(Long id) {
      return  billDAO.getBillByBillId(id);
//         null;//(Bill) genericDao.get(id);
    }
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
    public Bill addBill(Bill bill_p) {
        balanceService.updateBalances
            (
            bill_p.getBillPayerId(),
            bill_p.getBillSimpleEntry().getSimpleUserIdAndLiableCost(), 
            BalanceService.OPERATION.OP_ADD_BILL
            );
        return billDAO.save(bill_p);
    }

    public Bill editBill(Bill bill_p) {
        balanceService.updateBalances
            (
            bill_p.getBillPayerId(),
            bill_p.getBillSimpleEntry().getSimpleUserIdAndLiableCost(), 
            BalanceService.OPERATION.OP_EDIT_BILL
            );
        return  billDAO.merge(bill_p);
    }

    public Boolean deleteBill(Bill bill_p) {
        balanceService.updateBalances
            (
            bill_p.getBillPayerId(),
            bill_p.getBillSimpleEntry().getSimpleUserIdAndLiableCost(), 
            BalanceService.OPERATION.OP_DEL_BILL
            );
        Boolean deleted= billDAO.removeById(bill_p.getId());
        if(deleted)
            return true;
        else
            return false;
    }


    
}
