/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Food;
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
public class FoodDaoTest {

    private FoodDao foodDao;

    public FoodDaoTest() {
        foodDao = new FoodDao("delivery");
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
     * Test of addAFood method, of class FoodDao.
     */
    @Test
    public void testAddAFood() {
        System.out.println("addAFood");
        int restaurantId = 100;
        String food = "dumping";
        double price = 10.0;
        int typeId = 1;
        int expResult = -1;
        int result = foodDao.addAFood(restaurantId, food, price, typeId);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFoodByRestaurantId method, of class FoodDao.
     */
    @Test
    public void testGetFoodByRestaurantId() {
        System.out.println("getFoodByRestaurantId");
        int restaurantId = 100;
        ArrayList<Food> result = foodDao.getFoodByRestaurantId(restaurantId);
        assertTrue((result.isEmpty()));

    }

    /**
     * Test of removeFood method, of class FoodDao.
     */
    @Test
    public void testRemoveFood() {
        System.out.println("removeFood");
        int restaurantId = 100;
        int foordId = 100;
        int expResult = 0;
        int result = foodDao.removeFood(restaurantId, foordId);
        assertEquals(expResult, result);
    }


    /**
     * Test of updatePrice method, of class FoodDao.
     */
    @Test
    public void testUpdatePrice() {
        System.out.println("updatePrice");
        int restaurantId = 100;
        int foordId = 10;
        double price = 10.0;
        int expResult = 0;
        int result = foodDao.updatePrice(restaurantId, foordId, price);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFood method, of class FoodDao.
     */
    @Test
    public void testGetFood() {
        System.out.println("getFood");
        int restaurantId = 100;
        int foodId = 100;
        Food expResult =null;
        Food result = foodDao.getFood(restaurantId, foodId);
        assertEquals(expResult, result);

    }

}
