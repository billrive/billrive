/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.services.impl;

import com.uhsarp.billrive.domain.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uhsarp
 */
public class UserServiceImplTest {
    
    public UserServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsers method, of class UserServiceImpl.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Long userId = null;
        UserServiceImpl instance = new UserServiceImpl();
        List<User> expResult = null;
        List<User> result = instance.getUsers(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUserId method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserByUserId() {
        System.out.println("getUserByUserId");
        Long id = null;
        UserServiceImpl instance = new UserServiceImpl();
        User expResult = null;
        User result = instance.getUserByUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserServiceImpl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user_p = null;
        UserServiceImpl instance = new UserServiceImpl();
        User expResult = null;
        User result = instance.addUser(user_p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserServiceImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User bill_p = null;
        UserServiceImpl instance = new UserServiceImpl();
        User expResult = null;
        User result = instance.updateUser(bill_p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String billId_p = "";
        UserServiceImpl instance = new UserServiceImpl();
        instance.deleteUser(billId_p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
