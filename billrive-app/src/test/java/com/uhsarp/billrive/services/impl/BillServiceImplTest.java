/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.services.impl;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.Balance;
import com.uhsarp.billrive.domain.BillSimpleEntry;
import com.uhsarp.billrive.domain.SimpleUserIdAndLiableCost;
import com.uhsarp.billrive.services.BillService;
import com.uhsarp.billrive.services.GroupService;
import com.uhsarp.billrive.spring.BillriveConfigTest;
import com.uhsarp.billrive.spring.BillriveJPATest;

import java.lang.System;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanth Batchu
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BillriveConfigTest.class,BillriveJPATest.class})
public class BillServiceImplTest {
    
    @Autowired
    BillService billService;
    
    @Autowired
    GroupService groupService;
    
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
    //@Ignore
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
//    @Transactional(rollbackFor = Exception.class)
//    public void testAddBill() {
//        System.out.println("addBill");
//        Bill bill_p = new Bill();
//        bill_p.setTitle("TestAddBill");
//        bill_p.setBillPayerId(7L);
//        bill_p.setGroupId(4L);
//        bill_p.setBillCreaterId(6L);
//        bill_p.setBillDate(new Date(System.currentTimeMillis()));
//        BigDecimal billTotal = new BigDecimal(540.00);
//        bill_p.setBillTotal(billTotal);
//        
//        BillSimpleEntry billSimpleEntry_p = new BillSimpleEntry();
//        billSimpleEntry_p.setItemDescription("SimpleTestAddBill");
//        
//        //Set SimpleUserIdandLiableCost collection
//        List<SimpleUserIdAndLiableCost> liableCostList = new ArrayList<SimpleUserIdAndLiableCost>();
//        List<Long> groupUserIds = groupService.getUsersInGroup(4L);
//        BigDecimal userCount = new BigDecimal(groupUserIds.size());
//        for(Long groupUserId : groupUserIds) {
//            BigDecimal liableCost = billTotal.divide(userCount);
//            SimpleUserIdAndLiableCost s = new SimpleUserIdAndLiableCost(groupUserId, liableCost, Boolean.TRUE);
//            liableCostList.add(s);
//        }
//        
//        //Add SimpleUserIdandLiableCost collection in billSimpleEntry
//        billSimpleEntry_p.setSimpleUserIdAndLiableCost(liableCostList);
//        bill_p.setBillSimpleEntry(billSimpleEntry_p);
//        Bill addResult = billService.addBill(bill_p);
//
//        Bill retrieveResult = billService.getBillById(addResult.getId());
//        assertEquals("TestAddBill", retrieveResult.getTitle());       
//    }
//
//    /**
//     * Test of editBill method, of class BillServiceImpl.
//     */
//    @Test
//    @Transactional(rollbackFor = Exception.class)
//    public void testEditBill() {
//        try{
//            System.out.println("editBill");
//            Bill bill_p = billService.getBillById(45L);
//            BigDecimal newTotal = new BigDecimal(560.00);
//            bill_p.setBillTotal(newTotal);
//            
//            BillSimpleEntry billSimpleEntry_p = bill_p.getBillSimpleEntry();
//            List<SimpleUserIdAndLiableCost> theList = billSimpleEntry_p.getSimpleUserIdAndLiableCost();
//            BigDecimal userCount = new BigDecimal(theList.size());
//            BigDecimal newLiableCost = newTotal.divide(userCount);
//            
//            //Update the liable costs
//            for(SimpleUserIdAndLiableCost s : theList) {
//                BigDecimal liableCostDiff = newLiableCost.subtract(s.getLiableCost());
//                s.setLiableCost(newLiableCost);
//                s.setLiableCostDiff(liableCostDiff);
//            }
//            billSimpleEntry_p.setSimpleUserIdAndLiableCost(theList);
//            Bill editResult = billService.editBill(bill_p);
//
//            Bill retrieveResult = billService.getBillById(editResult.getId());
//            assertEquals(newTotal.longValue(), retrieveResult.getBillTotal().longValue());
//        } catch (ConstraintViolationException e) {
//            e.getCause().getMessage();
//        }
//    }
//
//    /**
//     * Test of deleteBill method, of class BillServiceImpl.
//     */
//    @Test
//    @Transactional(rollbackFor = Exception.class)
//    public void testDeleteBill() {
//        System.out.println("deleteBill");
//        Bill bill_p = billService.getBillById(43L);
//        Boolean result = billService.deleteBill(bill_p);
//        assertEquals(true, result);
//    }
    
}
