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
        customerOrderDao = new CustomerOrderDao("delivery_test");
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
        @Test
    public void testGetCustomerIdByOrderId2() {
        System.out.println("getCustomerIdByOrderId");
        int orderId = 1;
    
        int expResult = 1;
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
        @Test
    public void testGetOrderDetails2() {
        System.out.println("getOrderDetails");
        int foodId = 10;
        ArrayList<OrderDetail> result = customerOrderDao.getOrderDetails(foodId);
        assertTrue((result.isEmpty()));
    }

    /**
     * Test of FinishOrder method, of class CustomerOrderDao.
     */
    @Test
    public void testFinishOrder() {
        System.out.println("FinishOrder");
        int orderId = 0;
        int expResult = 0;
        int result = customerOrderDao.FinishOrder(orderId);
        assertEquals(expResult, result);

    }
        @Test
    public void testFinishOrder2() {
        System.out.println("FinishOrder");
        int orderId = 1;
        int expResult = 1;
        int result = customerOrderDao.FinishOrder(orderId);
        assertEquals(expResult, result);

    }
    /**
     * Test of createACustomerOrder method, of class CustomerOrderDao.
     */
    @Test
    public void testCreateACustomerOrder() {
        System.out.println("createACustomerOrder");
        int customerId = 0;
        String customerMessage = "";
        int expResult = -1;
        int result = customerOrderDao.createACustomerOrder(customerId, customerMessage);
        assertEquals(expResult, result);

    }
    
}
