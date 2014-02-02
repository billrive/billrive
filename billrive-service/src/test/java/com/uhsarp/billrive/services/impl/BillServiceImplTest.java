/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.services.impl;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.services.BillService;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Prashanth Batchu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:billrive-context-test.xml")
public class BillServiceImplTest {
    
    @Autowired
    BillService billService;
    
    public BillServiceImplTest() {
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
     * Test of getBills method, of class BillServiceImpl.
     */
//    @Test
//    public void testGetBills() {
//        System.out.println("getBills");
//        Long userId = null;
//        BillServiceImpl instance = new BillServiceImpl();
//        List<Bill> expResult = null;
//        List<Bill> result = instance.getBills(userId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBillById method, of class BillServiceImpl.
//     */
    @Test
    public void testGetBillById() {
        System.out.println("getBillById");
        Long id = 5L;
        Bill result = billService.getBillById(id);
        assertEquals("Travel", result.getTitle());
    }
//
//    /**
//     * Test of addBill method, of class BillServiceImpl.
//     */
//    @Test
//    public void testAddBill() {
//        System.out.println("addBill");
//        Bill bill_p = null;
//        BillServiceImpl instance = new BillServiceImpl();
//        Bill expResult = null;
//        Bill result = instance.addBill(bill_p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editBill method, of class BillServiceImpl.
//     */
//    @Test
//    public void testEditBill() {
//        System.out.println("editBill");
//        Bill bill_p = null;
//        BillServiceImpl instance = new BillServiceImpl();
//        Bill expResult = null;
//        Bill result = instance.editBill(bill_p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteBill method, of class BillServiceImpl.
//     */
//    @Test
//    public void testDeleteBill() {
//        System.out.println("deleteBill");
//        Long billId_p = null;
//        BillServiceImpl instance = new BillServiceImpl();
//        Boolean expResult = null;
//        Boolean result = instance.deleteBill(billId_p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
