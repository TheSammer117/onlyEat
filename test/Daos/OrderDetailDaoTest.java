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
        orderDetailDao = new OrderDetailDao("delivery_test");
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
    @Test
    public void testGetFoodAmount2() {
        System.out.println("getFoodAmount");
        int orderId = 1;
        int foodId = 3;
        int expResult = 1;
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
        ArrayList<OrderDetail> result = orderDetailDao.getFoodDetails(foodId);
        assertTrue((result.isEmpty()));

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
    @Test
    public void testGetOrderIdByFoodId2() {
        System.out.println("getOrderIdByFoodId");
        int foodId = 3;
        int expResult = 1;
        int result = orderDetailDao.getOrderIdByFoodId(foodId);
        assertEquals(expResult, result);

    }
    /**
     * Test of getFoodIdByOrder method, of class OrderDetailDao.
     */
    @Test
    public void testGetFoodIdByOrder() {
        System.out.println("getFoodIdByOrder");
        int orderId = 77;
        ArrayList<Integer> result = orderDetailDao.getFoodIdByOrder(orderId);
        assertTrue((result.isEmpty()));

    }
    @Test
    public void testGetFoodIdByOrder2() {
        System.out.println("getFoodIdByOrder");
        int orderId = 1;
           ArrayList<Integer> expResult = new  ArrayList<Integer>() ;
           expResult.add(3);
           expResult.add(10);
        ArrayList<Integer> result = orderDetailDao.getFoodIdByOrder(orderId);
     assertEquals(expResult, result);

    }
    /**
     * Test of createAnOrderDetailByOrderId method, of class OrderDetailDao.
     */
    @Test
    public void testCreateAnOrderDetailByOrderId() {
        System.out.println("createAnOrderDetailByOrderId");
        int orderId = 0;
        int foodId = 0;
        int quantity = 0;
        int expResult = -1;
        int result = orderDetailDao.createAnOrderDetailByOrderId(orderId, foodId, quantity);
        assertEquals(expResult, result);

    }
    @Test
    public void testCreateAnOrderDetailByOrderId2() {
        System.out.println("createAnOrderDetailByOrderId");
        int orderId = 3;
        int foodId = 5;
        int quantity = 1;
        int expResult = -1;
        int result = orderDetailDao.createAnOrderDetailByOrderId(orderId, foodId, quantity);
        assertEquals(expResult, result);

    }
}
