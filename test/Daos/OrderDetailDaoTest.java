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
 * @author d00189923
 */
public class OrderDetailDaoTest {
        private OrderDetailDao orderDetailDao;
    public OrderDetailDaoTest() {
    orderDetailDao = new OrderDetailDao("delivery");
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
     * Test of getFoodAmount method, of class OrderDetailDao.
     */
    @Test
    public void testGetFoodAmount() {
        System.out.println("getFoodAmount");
        int orderId = 77;
        int foodId = 77;
        int expResult = 0;
        int result = orderDetailDao.getFoodAmount(orderId, foodId);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFoodDetails method, of class OrderDetailDao.
     */
    @Test
    public void testGetFoodDetails() {
        System.out.println("getFoodDetails");
        int foodId = 77;

        ArrayList<OrderDetail> expResult = null;
        ArrayList<OrderDetail> result = orderDetailDao.getFoodDetails(foodId);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOrderIdByFoodId method, of class OrderDetailDao.
     */
    @Test
    public void testGetOrderIdByFoodId() {
        System.out.println("getOrderIdByFoodId");
        int foodId = 77;
        int expResult = 0;
        int result = orderDetailDao.getOrderIdByFoodId(foodId);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFoodIdByOrder method, of class OrderDetailDao.
     */
    @Test
    public void testGetFoodIdByOrder() {
        System.out.println("getFoodIdByOrder");
        int orderId = 0;
        OrderDetailDao instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getFoodIdByOrder(orderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
