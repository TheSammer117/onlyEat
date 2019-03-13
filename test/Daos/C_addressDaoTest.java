/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.C_address;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 82509
 */
public class C_addressDaoTest {
        private C_addressDao c_addressDao;
    
    public C_addressDaoTest() {
        c_addressDao = new C_addressDao("delivery");
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
     * Test of getCustomerAddressByCustomerId method, of class C_addressDao.
     */
    @Test
    public void testGetCustomerAddressByCustomerId() {
        System.out.println("getCustomerAddressByCustomerId");
        int customerId = 100;
        String address1 = null;
        String address2 = null;
        String address3 = null;
        C_address expResult = new C_address(0,0,address1,address2,address3);
        C_address result = c_addressDao.getCustomerAddressByCustomerId(customerId);
        assertEquals(expResult, result);

    }

    /**
     * Test of addCustomerAddress method, of class C_addressDao.
     */
    @Test
    public void testAddCustomerAddress() {
        System.out.println("addCustomerAddress");
        int customerId = 100;
        String address1 = "dublin";
        String address2 = "louth";
        String address3 = "ireland";
        int expResult = 0;
        int result = c_addressDao.addCustomerAddress(customerId, address1, address2, address3);
        assertEquals(expResult, result);

    }

    /**
     * Test of updateCustomerAddress method, of class C_addressDao.
     */
    @Test
    public void testUpdateCustomerAddress() {
        System.out.println("updateCustomerAddress");
        int customerId = 100;
        String address1 = "fengtai";
        String address2 = "beijing";
        String address3 = "china";
        int expResult = 0;
        int result = c_addressDao.updateCustomerAddress(customerId, address1, address2, address3);
        assertEquals(expResult, result);

    }
    
}
