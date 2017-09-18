/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework;

import com.uhsarp.billrive.domain.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author pperi
 */
public interface BalanceDAO extends CrudRepository<Balance, Long>{
    List<Balance> getBalances(Long userId);
}
