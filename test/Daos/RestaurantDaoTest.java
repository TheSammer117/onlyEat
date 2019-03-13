/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Restaurant;
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
public class RestaurantDaoTest {

    private RestaurantDao restaurantDao;

    public RestaurantDaoTest() {
        restaurantDao = new RestaurantDao("delivery");
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
     * Test of registerRestaurant method, of class RestaurantDao.
     */
    @Test
    public void testRegisterRestaurant1() {
        System.out.println("registerRestaurant");
        String username = "1234";
        String password = "1234";
        String name = "zzh";
        String phone = "12345678";
        String street = "Dublin";
        String town = "dundalk";
        int countyId = 1;
        int result = restaurantDao.registerRestaurant(username, password, name, phone, street, town, countyId);
        assertTrue((result > 0));
    }

    @Test
    public void testRegisterRestaurant2() {
        System.out.println("registerRestaurant");
        String username = "12345";
        String password = "12345";
        String name = "zzh";
        String phone = "12345678";
        String street = "Dublin";
        String town = "dundalk";
        int countyId = 0;
        int result = restaurantDao.registerRestaurant(username, password, name, phone, street, town, countyId);
        assertTrue((result < 0));
    }

    /**
     * Test of getRestaurantByUsernamePassword method, of class RestaurantDao.
     */
    @Test
    public void testGetRestaurantByUsernamePassword() {
        System.out.println("getRestaurantByUsernamePassword");
        String username = "zzh";
        String password = "1234";
        Restaurant expResult = null;
        Restaurant result = restaurantDao.getRestaurantByUsernamePassword(username, password);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetRestaurantByUsernamePassword2() {
        System.out.println("getRestaurantByUsernamePassword");
        String username = "1234";
        String password = "1234";
        Restaurant expResult = new Restaurant("1234", "1234", "zzh", "12345678", "Dublin", "Dundalk", 1);
        Restaurant result = restaurantDao.getRestaurantByUsernamePassword(username, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllRestaurants method, of class RestaurantDao.
     */
    @Test
    public void testGetAllRestaurants() {
        System.out.println("getAllRestaurants");


        ArrayList<Restaurant> result = restaurantDao.getAllRestaurants();
           assertTrue((result.size() >0));

    }

    /**
     * Test of getHashedPasswordByUsername method, of class RestaurantDao.
     */
    @Test
    public void testGetHashedPasswordByUsername() {
        System.out.println("getHashedPasswordByUsername");
        String username = "1234";
        String expResult = "1234";
        String result = restaurantDao.getHashedPasswordByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRestaurantsByCountyId method, of class RestaurantDao.
     */
    @Test
    public void testGetRestaurantsByCountyId() {
        System.out.println("getRestaurantsByCountyId");
        int countyId = 1;
         Restaurant r1 = new Restaurant("1234", "1234", "zzh", "12345678", "Dublin", "Dundalk", 1);
        ArrayList<Restaurant> expResult = new ArrayList();
        expResult.add(r1);
        ArrayList<Restaurant> result = restaurantDao.getRestaurantsByCountyId(countyId);
        assertEquals(expResult, result);

    }

}
