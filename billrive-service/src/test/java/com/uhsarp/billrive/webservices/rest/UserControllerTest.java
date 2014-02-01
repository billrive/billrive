/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.webservices.rest;


import com.uhsarp.billrive.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 * @author Uhsarp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:billrive-context-test.xml")
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
   private MockMvc mockMvc;
   
   @Autowired
   UserController userController;
    
    @Autowired
    private WebApplicationContext wac;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          this.mockMvc  = webAppContextSetup(this.wac).build();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class UserController.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        Long userId = 6L;
        User expResult = null;
        User result = userController.getUser(userId);
        assertEquals("Bruce", result.getfName());
        
           this.mockMvc.perform(get("/user/6").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"))
          .andExpect(jsonPath("$.fName").value("Bruce"));
//         this.mockMvc.perform(get("/foo").accept("application/json"))
//        .andExpect(status().isOk())
//        .andExpect(content().mimeType("application/json"));
    }

    /**
     * Test of addUser method, of class UserController.
     */
//    @Test
//    public void testAddUser() {
//        System.out.println("addUser");
//        User user_p = null;
//        HttpServletResponse httpResponse_p = null;
//        WebRequest request_p = null;
//        UserController instance = new UserController();
//        User expResult = null;
//        User result = instance.addUser(user_p, httpResponse_p, request_p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUserService method, of class UserController.
//     */
//    @Test
//    public void testGetUserService() {
//        System.out.println("getUserService");
//        UserController instance = new UserController();
//        UserService expResult = null;
//        UserService result = instance.getUserService();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setUserService method, of class UserController.
//     */
//    @Test
//    public void testSetUserService() {
//        System.out.println("setUserService");
//        UserService userService = null;
//        UserController instance = new UserController();
//        instance.setUserService(userService);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
