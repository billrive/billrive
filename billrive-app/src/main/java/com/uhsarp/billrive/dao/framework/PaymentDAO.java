/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework;

import org.springframework.data.repository.CrudRepository;
import com.uhsarp.billrive.domain.Payment;

/**
 *
 * @author pperi
 */
public interface PaymentDAO extends CrudRepository<Payment, Long> {
    
}
