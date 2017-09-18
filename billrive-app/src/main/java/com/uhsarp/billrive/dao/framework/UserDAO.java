/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import org.springframework.data.repository.CrudRepository;
import com.uhsarp.billrive.domain.User;

/**
 *
 * @author Prashanth Batchu
 */
public interface UserDAO extends CrudRepository<User,Long> {
     public User getUserByUserId(Long userId);
     public User getUserByUserName(String userName);
}
