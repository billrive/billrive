/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework.impl;

import com.uhsarp.billrive.dao.framework.UserDAO;
import com.uhsarp.billrive.domain.User;
import com.uhsarp.billrive.spring.BillriveConfigTest;
import com.uhsarp.billrive.spring.BillriveJPATest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Prashanth Batchu
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BillriveConfigTest.class,BillriveJPATest.class})
public class UserDAOImplTest {
    
    @Autowired
    UserDAO userDao;
    public UserDAOImplTest() {
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

    //@Ignore
    @Test
    public void testGetUserByUserId() {
        System.out.println("getUserByUserId");
        Long userId = 6L;
        User result = userDao.getUserByUserId(userId);
        assertEquals("Bruce", result.getfName());
        assertEquals("Wayne", result.getlName());

    }
    
}
