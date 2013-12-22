/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.services.BillService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Uhsarp
 */
public class BillControllerTest {
    
    public BillControllerTest() {
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
     * Test of getBills method, of class BillController.
     */
    @Test
    public void testGetBills() {
        System.out.println("getBills");
        int userId = 0;
        BillController instance = new BillController();
        List<Bill> expResult = null;
        List<Bill> result = instance.getBills(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBill method, of class BillController.
     */
    @Test
    public void testGetBill() {
        System.out.println("getBill");
        String billId_p = "";
        int userId = 0;
        BillController instance = new BillController();
        Bill expResult = null;
        Bill result = instance.getBill(billId_p, userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBill method, of class BillController.
     */
    @Test
    public void testAddBill() {
        System.out.println("addBill");
        Bill bill_p = null;
        int userId = 0;
        HttpServletResponse httpResponse_p = null;
        WebRequest request_p = null;
        BillController instance = new BillController();
        instance.addBill(bill_p, userId, httpResponse_p, request_p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editBill method, of class BillController.
     */
    @Test
    public void testEditBill() {
        System.out.println("editBill");
        Bill bill_p = null;
        String billId_p = "";
        int userId = 0;
        HttpServletResponse httpResponse_p = null;
        BillController instance = new BillController();
        instance.editBill(bill_p, billId_p, userId, httpResponse_p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBill method, of class BillController.
     */
    @Test
    public void testDeleteBill() {
        System.out.println("deleteBill");
        String billId_p = "";
        int userId = 0;
        HttpServletResponse httpResponse_p = null;
        BillController instance = new BillController();
        instance.deleteBill(billId_p, userId, httpResponse_p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class BillController.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        String s_p = "";
        boolean expResult = false;
        boolean result = BillController.isEmpty(s_p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBillService method, of class BillController.
     */
    @Test
    public void testGetBillService() {
        System.out.println("getBillService");
        BillController instance = new BillController();
        BillService expResult = null;
        BillService result = instance.getBillService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBillService method, of class BillController.
     */
    @Test
    public void testSetBillService() {
        System.out.println("setBillService");
        BillService billService = null;
        BillController instance = new BillController();
        instance.setBillService(billService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
