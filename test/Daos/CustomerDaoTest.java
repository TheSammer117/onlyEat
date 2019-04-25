/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Customer;
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
public class CustomerDaoTest {
        private  CustomerDao  customerDao;
    public CustomerDaoTest() {
            customerDao = new CustomerDao("delivery_test");
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
     * Test of registerCustomer method, of class CustomerDao.
     */
    @Test
    public void testRegisterCustomer() {
        System.out.println("registerCustomer");
        String username = "1234";
        String password = "1234";
        String firstName = "sweaty";
        String lastName = "paul";
        String phone = "12345678";
        int result =  customerDao.registerCustomer(username, password, firstName, lastName, phone);
        assertTrue((result > 0));
    }
    @Test
    public void testRegisterCustomer2() {
        System.out.println("registerCustomer");
        String username = "1234";
        String password = "1234";
        String firstName = "sweaty";
        String lastName = "paul";
        String phone = "12345678";
        int expResult = -1;
        int result =  customerDao.registerCustomer(username, password, firstName, lastName, phone);
         assertEquals(expResult, result);
    }
    /**
     * Test of getCustomerByUsernamePassword method, of class CustomerDao.
     */
    @Test
    public void testGetCustomerByUsernamePassword() {
        System.out.println("getCustomerByUsernamePassword");
        String username = "zzh";
        String password = "1234";

        Customer expResult = null;
        Customer result = customerDao.getCustomerByUsernamePassword(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateCustomerProfile method, of class CustomerDao.
     */
    @Test
    public void testUpdateCustomerProfile() {
        System.out.println("updateCustomerProfile");
        int customerId = 100;
        String username = "zzh";
        String firstName = "joe";
        String lastName = "dean";
        String phone = "12345678";
        int expResult = 0;
        int result = customerDao.updateCustomerProfile(customerId, username, firstName, lastName, phone);
        assertEquals(expResult, result);
    }
        @Test
    public void testUpdateCustomerProfile2() {
        System.out.println("updateCustomerProfile");
        int customerId = 3;
        String username = "zzh";
        String firstName = "joe";
        String lastName = "dean";
        String phone = "12345678";
        int expResult = 0;
        int result = customerDao.updateCustomerProfile(customerId, username, firstName, lastName, phone);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHashedPasswordByUsername method, of class CustomerDao.
     */
    @Test
    public void testGetHashedPasswordByUsername() {
        System.out.println("getHashedPasswordByUsername");
        String username = "1234567";
        String expResult = null;
        String result = customerDao.getHashedPasswordByUsername(username);
        assertEquals(expResult, result);

    }
    
}
