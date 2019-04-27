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
        foodDao = new FoodDao("delivery_test");
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

    @Test
    public void testAddAFood2() {
        System.out.println("addAFood");
        int restaurantId = 2;
        String food = "dumping";
        double price = 10.0;
        int typeId = 1;
        int expResult = 21;
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

    @Test
    public void testGetFoodByRestaurantId2() {
        System.out.println("getFoodByRestaurantId");
        int restaurantId = 8;
        int foodId = 19;
        String name = "Cookies";
        double price = 2.5;
        int typeId = 6;
        ArrayList<Food> expResult = new ArrayList<Food>();
        Food f = new Food(foodId,restaurantId,name,price,typeId);
        expResult.add(f);
        ArrayList<Food> result = foodDao.getFoodByRestaurantId(restaurantId);
        assertEquals(expResult, result);

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

    @Test
    public void testRemoveFood2() {
        System.out.println("removeFood");
        int restaurantId = 2;
        int foordId = 21;
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
 @Test
    public void testUpdatePrice2() {
        System.out.println("updatePrice");
        int restaurantId = 4;
        int foordId = 2;
        double price = 10.0;
        int expResult = 1;
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
        Food expResult = null;
        Food result = foodDao.getFood(restaurantId, foodId);
        assertEquals(expResult, result);

    }
    @Test
    public void testGetFood2() {
        System.out.println("getFood");
        int restaurantId = 6;
        int foodId = 11;
            String name = "7-up";
        double price = 1.4;
        int typeId = 7;
        Food expResult = new Food(foodId,restaurantId,name,price,typeId);
        Food result = foodDao.getFood(restaurantId, foodId);
        assertEquals(expResult, result);

    }
    /**
     * Test of getFoodByFoodId method, of class FoodDao.
     */
    @Test
    public void testGetFoodByFoodId() {
        System.out.println("getFoodByFoodId");
        int foodId = 0;
        Food expResult = null;
        Food result = foodDao.getFoodByFoodId(foodId);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetFoodByFoodId2() {
        System.out.println("getFoodByFoodId");
        int foodId = 2;
        Food expResult = new Food(2, 4, "Cheese & Tomato Pizza", 9.00, 1);
        Food result = foodDao.getFoodByFoodId(foodId);
        assertEquals(expResult, result);

    }
}
