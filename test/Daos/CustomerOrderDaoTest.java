/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.OrderDetail;
import java.util.ArrayList;
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
public class CustomerOrderDaoTest {
    private CustomerOrderDao customerOrderDao;
    
    public CustomerOrderDaoTest() {
        customerOrderDao = new CustomerOrderDao("delivery");
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
     * Test of getCustomerIdByOrderId method, of class CustomerOrderDao.
     */
    @Test
    public void testGetCustomerIdByOrderId() {
        System.out.println("getCustomerIdByOrderId");
        int orderId = 100;
    
        int expResult = 0;
        int result = customerOrderDao.getCustomerIdByOrderId(orderId);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getOrderDetails method, of class CustomerOrderDao.
     */
    @Test
    public void testGetOrderDetails() {
        System.out.println("getOrderDetails");
        int foodId = 100;
        ArrayList<OrderDetail> result = customerOrderDao.getOrderDetails(foodId);
        assertTrue((result.isEmpty()));
    }
    
}
