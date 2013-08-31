/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.uhsarp.billrive.domain.User;

/**
 *
 * @author uhsarp
 */
public interface UserDAO extends GenericDAO<User,Long> {
     public User getUserByUserId(Long userId);
}
