/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.services;

import com.uhsarp.billrive.domain.Balance;
import com.uhsarp.billrive.domain.SimpleUserIdAndLiableCost;
import java.util.List;

/**
 *
 * @author pperi
 */
public interface BalanceService {
    
    public enum OPERATION{
       OP_ADD_BILL,
       OP_DEL_BILL,
       OP_EDIT_BILL
    }

    Balance addBalance(Balance b);
    
    Balance editBalance(Balance b);
    
    List<Balance> getBalances(Long billPayerId);
    
    boolean deleteBalance(Long balanceId);

    void updateBalances(Long billPayerId, List<SimpleUserIdAndLiableCost> simpleUserIdAndLiableCostList, OPERATION op);
    
}
