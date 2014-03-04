/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.uhsarp.billrive.domain.Balance;
import java.util.List;

/**
 *
 * @author pperi
 */
public interface BalanceDAO extends GenericDAO<Balance, Long>{
    List<Balance> getBalances(Long userId);
}
