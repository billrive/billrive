/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework.impl;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.uhsarp.billrive.domain.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 * @author Uhsarp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/spring/test-context.xml")
//@ContextConfiguration("classpath:spring-config.xml")
public class UserDAOImplTest {
    
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

    /**
     * Test of find method, of class UserDAOImpl.
     */
    @Test
    public void testFind_Long() {
        System.out.println("find");
        Long id = null;
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UserDAOImpl.
     */
    @Test
    public void testFind_LongArr() {
        System.out.println("find");
        Long[] ids = null;
        UserDAOImpl instance = new UserDAOImpl();
        User[] expResult = null;
        User[] result = instance.find(ids);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReference method, of class UserDAOImpl.
     */
    @Test
    public void testGetReference() {
        System.out.println("getReference");
        Long id = null;
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.getReference(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReferences method, of class UserDAOImpl.
     */
    @Test
    public void testGetReferences() {
        System.out.println("getReferences");
        Long[] ids = null;
        UserDAOImpl instance = new UserDAOImpl();
        User[] expResult = null;
        User[] result = instance.getReferences(ids);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class UserDAOImpl.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        User[] ts = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.persist(ts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class UserDAOImpl.
     */
    @Test
    public void testMerge_User() {
        System.out.println("merge");
        User t = null;
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.merge(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class UserDAOImpl.
     */
    @Test
    public void testMerge_UserArr() {
        System.out.println("merge");
        User[] ts = null;
        UserDAOImpl instance = new UserDAOImpl();
        User[] expResult = null;
        User[] result = instance.merge(ts);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserDAOImpl.
     */
    @Test
    public void testSave_User() {
        System.out.println("save");
        User t = null;
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.save(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserDAOImpl.
     */
    @Test
    public void testSave_UserArr() {
        System.out.println("save");
        User[] ts = null;
        UserDAOImpl instance = new UserDAOImpl();
        User[] expResult = null;
        User[] result = instance.save(ts);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UserDAOImpl.
     */
    @Test
    public void testRemove_User() {
        System.out.println("remove");
        User t = null;
        UserDAOImpl instance = new UserDAOImpl();
        boolean expResult = false;
        boolean result = instance.remove(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UserDAOImpl.
     */
    @Test
    public void testRemove_UserArr() {
        System.out.println("remove");
        User[] ts = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.remove(ts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeById method, of class UserDAOImpl.
     */
    @Test
    public void testRemoveById() {
        System.out.println("removeById");
        Long id = null;
        UserDAOImpl instance = new UserDAOImpl();
        boolean expResult = false;
        boolean result = instance.removeById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeByIds method, of class UserDAOImpl.
     */
    @Test
    public void testRemoveByIds() {
        System.out.println("removeByIds");
        Long[] ids = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.removeByIds(ids);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserDAOImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UserDAOImpl instance = new UserDAOImpl();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class UserDAOImpl.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        ISearch is = null;
        UserDAOImpl instance = new UserDAOImpl();
        List expResult = null;
        List result = instance.search(is);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchUnique method, of class UserDAOImpl.
     */
    @Test
    public void testSearchUnique() {
        System.out.println("searchUnique");
        ISearch is = null;
        UserDAOImpl instance = new UserDAOImpl();
        Object expResult = null;
        Object result = instance.searchUnique(is);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class UserDAOImpl.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        ISearch is = null;
        UserDAOImpl instance = new UserDAOImpl();
        int expResult = 0;
        int result = instance.count(is);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchAndCount method, of class UserDAOImpl.
     */
    @Test
    public void testSearchAndCount() {
        System.out.println("searchAndCount");
        ISearch is = null;
        UserDAOImpl instance = new UserDAOImpl();
        SearchResult expResult = null;
        SearchResult result = instance.searchAndCount(is);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAttached method, of class UserDAOImpl.
     */
    @Test
    public void testIsAttached() {
        System.out.println("isAttached");
        User t = null;
        UserDAOImpl instance = new UserDAOImpl();
        boolean expResult = false;
        boolean result = instance.isAttached(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class UserDAOImpl.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh");
        User[] ts = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.refresh(ts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flush method, of class UserDAOImpl.
     */
    @Test
    public void testFlush() {
        System.out.println("flush");
        UserDAOImpl instance = new UserDAOImpl();
        instance.flush();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilterFromExample method, of class UserDAOImpl.
     */
    @Test
    public void testGetFilterFromExample_User() {
        System.out.println("getFilterFromExample");
        User t = null;
        UserDAOImpl instance = new UserDAOImpl();
        Filter expResult = null;
        Filter result = instance.getFilterFromExample(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilterFromExample method, of class UserDAOImpl.
     */
    @Test
    public void testGetFilterFromExample_User_ExampleOptions() {
        System.out.println("getFilterFromExample");
        User t = null;
        ExampleOptions eo = null;
        UserDAOImpl instance = new UserDAOImpl();
        Filter expResult = null;
        Filter result = instance.getFilterFromExample(t, eo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUserId method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserByUserId() {
        System.out.println("getUserByUserId");
        Long userId = null;
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.getUserByUserId(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
