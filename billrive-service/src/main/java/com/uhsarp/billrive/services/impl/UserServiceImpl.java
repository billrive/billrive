/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services.impl;

import com.uhsarp.billrive.dao.framework.UserDAO;
import com.uhsarp.billrive.domain.User;
import com.uhsarp.billrive.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prashanth Batchu
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    public List<User> getUsers(Long userId) {
        
        
        return null;
    }

    public User getUserByUserId(Long id) {
        
        User user = userDAO.getUserByUserId(id);
        return user;
    }

    public User createUser(User bill_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User updateUser(User bill_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteUser(String billId_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
