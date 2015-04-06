/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.services.impl;

import com.uhsarp.billrive.dao.framework.BalanceDAO;
import com.uhsarp.billrive.domain.Balance;
import com.uhsarp.billrive.domain.SimpleUserIdAndLiableCost;
import com.uhsarp.billrive.services.BalanceService;
import com.uhsarp.billrive.services.GroupService;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pperi
 */
@Service("BalanceService")
public class BalanceServiceImpl implements BalanceService{
    
    @Resource(name = "BalanceDAO")
    BalanceDAO balanceDAO;
    
    @Autowired
    GroupService groupService;
    
    public Balance addBalance(Balance b) {
       return balanceDAO.save(b);
    }
    
    public Balance editBalance(Balance b) {
       return balanceDAO.merge(b);
    }
    
    public boolean deleteBalance(Long balanceId) {
        return balanceDAO.removeById(balanceId);
    }
    public List<Balance> getBalances(Long billPayerId) {
        return balanceDAO.getBalances(billPayerId);
    }
    
    public void updateBalances(Long billPayerId, List<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCostList, OPERATION op) {
        List<Balance> balances = getBalances(billPayerId);
        for(SimpleUserIdAndLiableCost s : simpleUserIdAndLiableCostList){
            Long userId = s.getUserId();
            BigDecimal liableCost = s.getLiableCost();
            BigDecimal liableCostDiff = s.getLiableCostDiff(); //Only used in case of editing bills
            if(userId != billPayerId){
                for(Balance bal : balances) {
                   Long userIdGets = bal.getUserId_gets();
                   Long userIdGives = bal.getUserId_gives();
                   
                   if((userIdGets == userId) || (userIdGives == userId)) {
                        BigDecimal balAmount = bal.getAmount();

                        //Update balance based on the operation on the bill table
                        switch(op)
                        {
                            case OP_ADD_BILL: {
                                 //See if the userId already owes some money to billPayerId
                                 if(userIdGets == billPayerId) {
                                     bal.setAmount(balAmount.add(liableCost));
                                 }
                                 //See if the billPayerId owes money to userId
                                 else {
                                     bal.setAmount(balAmount.subtract(liableCost));
                                 }
                                 break;
                            }
                            case OP_DEL_BILL: {
                                 //See if the userId already owes some money to billPayerId
                                 if(userIdGets == billPayerId) {
                                     bal.setAmount(balAmount.subtract(liableCost));
                                 }
                                 //See if the billPayerId owes money to userId
                                 else {
                                     bal.setAmount(balAmount.add(liableCost));
                                 }
                                 break;
                            }
                            case OP_EDIT_BILL: {
                                //See if the userId already owes some money to billPayerId
                                 if(userIdGets == billPayerId) {
                                     bal.setAmount(balAmount.add(liableCostDiff));
                                 }
                                 //See if the billPayerId owes money to userId
                                 else {
                                     bal.setAmount(balAmount.subtract(liableCostDiff));
                                 }
                                 break;
                            }
                            default:

                        }
                        Balance balResult = editBalance(bal);
                        assert(balResult != null);
                   }
                }
                if(balances.isEmpty() && (op == OPERATION.OP_ADD_BILL)) {
                    Balance bal = new Balance();
                    bal.setUserId_gets(billPayerId);
                    bal.setUserId_gives(userId);
                    bal.setAmount(liableCost);
                    Balance balResult = addBalance(bal);
                    assert(balResult != null);
                }
            }
        }
    }
}
