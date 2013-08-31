/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services;

import com.uhsarp.billrive.domain.User;
import java.util.List;

/**
 *
 * @author uhsarp
 */
public interface UserService {
    
     List<User> getUsers(Long userId);
     User getUserByUserId(Long id);

     User createUser(User bill_p);

     User updateUser(User bill_p);

     void deleteUser(String billId_p);
    
}
