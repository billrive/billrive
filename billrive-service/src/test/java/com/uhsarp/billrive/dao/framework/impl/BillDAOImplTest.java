/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework.impl;

import com.uhsarp.billrive.dao.framework.BillDAO;
import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.spring.BillriveConfigTest;
import com.uhsarp.billrive.spring.BillriveJPATest;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Prashanth Batchu
 */
////@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BillriveConfigTest.class,BillriveJPATest.class})
public class BillDAOImplTest {
    
    @Autowired
    BillDAO billDAO;
    public BillDAOImplTest() {
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

 
    @Test
    public void testGetBillsByGroupId() {
        System.out.println("getBillsByGroupId");
        Long groupId = 4L;
        List<Bill> result = billDAO.getBillsByGroupId(groupId);
        assertEquals(2, result.size());
        assertEquals("Travel", result.get(0).getTitle());
       
    }
    @Test
    public void testGetBillByBillId() {
        System.out.println("getBillByBillId");
        Long billId = 5L;
        Bill result = billDAO.getBillByBillId(billId);
        assertEquals("Travel", result.getTitle());
       
    }
    
       
    /**
     * Test of save method, of class BillDAOImpl.
     */
//    @Test
//    public void testSave_Bill() {
//        System.out.println("save");
//        Bill bill = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        Bill expResult = null;
//        Bill result = instance.save(bill);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save method, of class BillDAOImpl.
//     */
//    @Test
//    public void testSave_BillArr() {
//        System.out.println("save");
//        Bill[] ts = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        Bill[] expResult = null;
//        Bill[] result = instance.save(ts);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class BillDAOImpl.
//     */
//    @Test
//    public void testRemove_Bill() {
//        System.out.println("remove");
//        Bill t = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.remove(t);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class BillDAOImpl.
//     */
//    @Test
//    public void testRemove_BillArr() {
//        System.out.println("remove");
//        Bill[] ts = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        instance.remove(ts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeById method, of class BillDAOImpl.
//     */
//    @Test
//    public void testRemoveById() {
//        System.out.println("removeById");
//        Long billId = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.removeById(billId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeByIds method, of class BillDAOImpl.
//     */
//    @Test
//    public void testRemoveByIds() {
//        System.out.println("removeByIds");
//        Long[] ids = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        instance.removeByIds(ids);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class BillDAOImpl.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        BillDAOImpl instance = new BillDAOImpl();
//        List<Bill> expResult = null;
//        List<Bill> result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of search method, of class BillDAOImpl.
//     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        ISearch is = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        List expResult = null;
//        List result = instance.search(is);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchUnique method, of class BillDAOImpl.
//     */
//    @Test
//    public void testSearchUnique() {
//        System.out.println("searchUnique");
//        ISearch is = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        Object expResult = null;
//        Object result = instance.searchUnique(is);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class BillDAOImpl.
//     */
//    @Test
//    public void testCount() {
//        System.out.println("count");
//        ISearch is = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        int expResult = 0;
//        int result = instance.count(is);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchAndCount method, of class BillDAOImpl.
//     */
//    @Test
//    public void testSearchAndCount() {
//        System.out.println("searchAndCount");
//        ISearch is = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        SearchResult expResult = null;
//        SearchResult result = instance.searchAndCount(is);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isAttached method, of class BillDAOImpl.
//     */
//    @Test
//    public void testIsAttached() {
//        System.out.println("isAttached");
//        Bill t = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.isAttached(t);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of refresh method, of class BillDAOImpl.
//     */
//    @Test
//    public void testRefresh() {
//        System.out.println("refresh");
//        Bill[] ts = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        instance.refresh(ts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of flush method, of class BillDAOImpl.
//     */
//    @Test
//    public void testFlush() {
//        System.out.println("flush");
//        BillDAOImpl instance = new BillDAOImpl();
//        instance.flush();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFilterFromExample method, of class BillDAOImpl.
//     */
//    @Test
//    public void testGetFilterFromExample_Bill() {
//        System.out.println("getFilterFromExample");
//        Bill t = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        Filter expResult = null;
//        Filter result = instance.getFilterFromExample(t);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFilterFromExample method, of class BillDAOImpl.
//     */
//    @Test
//    public void testGetFilterFromExample_Bill_ExampleOptions() {
//        System.out.println("getFilterFromExample");
//        Bill t = null;
//        ExampleOptions eo = null;
//        BillDAOImpl instance = new BillDAOImpl();
//        Filter expResult = null;
//        Filter result = instance.getFilterFromExample(t, eo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBillsByGroupId method, of class BillDAOImpl.
//     */
    
}
