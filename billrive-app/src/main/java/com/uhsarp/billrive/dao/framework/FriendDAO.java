/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import org.springframework.data.repository.CrudRepository;
import com.uhsarp.billrive.domain.Friend;

/**
 *
 * @author Prashanth Batchu
 */
public interface FriendDAO extends CrudRepository<Friend,Long>{
    
}
