/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
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
public class CartDaoTest {

    private CartDao cartDao;

    public CartDaoTest() {
        cartDao = new CartDao("delivery_test");
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
     * Test of getCartListByCustomerId method, of class CartDao.
     */
    @Test
    public void testGetCartListByCustomerId() {
        System.out.println("getCartListByCustomerId");
        int customerId = 0;
        ArrayList<Cart> result = cartDao.getCartListByCustomerId(customerId);
        assertTrue((result.isEmpty()));
    }
    @Test
    public void testGetCartListByCustomerId2() {
        System.out.println("getCartListByCustomerId");
        int customerId = 2;
        int foodId = 2;
        int quantity = 2;
        ArrayList<Cart> expResult = new ArrayList<Cart>();
        Cart c1 = new Cart(customerId, foodId, quantity);
        expResult.add(c1);
        ArrayList<Cart> result = cartDao.getCartListByCustomerId(customerId);
        assertEquals(expResult, result);

    }
    /**
     * Test of addToCart method, of class CartDao.
     */
    @Test
    public void testAddToCart() {
        System.out.println("addToCart");
        int customerId = 1;
        int foodId = 1;
        int quantity = 2;
        cartDao.addToCart(customerId, foodId, quantity);

    }



    /**
     * Test of removeAnItemFromCart method, of class CartDao.
     */
    @Test
    public void testRemoveAnItemFromCart() {
        System.out.println("removeAnItemFromCart");
        int customerId = 0;
        int foodId = 0;
        int quantity = 0;
        int expResult = 0;
        int result = cartDao.removeAnItemFromCart(customerId, foodId, quantity);
        assertEquals(expResult, result);

    }

    @Test
    public void testRemoveAnItemFromCart2() {
        System.out.println("removeAnItemFromCart");
        int customerId = 1;
        int foodId = 1;
        int quantity = 2;
        int expResult = 1;
        int result = cartDao.removeAnItemFromCart(customerId, foodId, quantity);
        assertEquals(expResult, result);

    }

    /**
     * Test of emptyCartByCustomerId method, of class CartDao.
     */
    @Test
    public void testEmptyCartByCustomerId() {
        System.out.println("emptyCartByCustomerId");
        int customerId = 10;
        int expResult = 0;
        int result = cartDao.emptyCartByCustomerId(customerId);
        assertEquals(expResult, result);

    }
    @Test
    public void testEmptyCartByCustomerId2() {
        System.out.println("emptyCartByCustomerId");
        int customerId = 2;
        int expResult = 1;
        int result = cartDao.emptyCartByCustomerId(customerId);
        assertEquals(expResult, result);

    }
}
