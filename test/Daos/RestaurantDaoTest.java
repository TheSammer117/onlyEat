/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Restaurant;
import Hashing.Decrypting;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        restaurantDao = new RestaurantDao("delivery_test");
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
    public void testRegisterRestaurant() {
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
     * Test of getAllRestaurants method, of class RestaurantDao.
     */
    @Test
    public void testGetAllRestaurants() {
        System.out.println("getAllRestaurants");

        ArrayList<Restaurant> result = restaurantDao.getAllRestaurants();
        assertTrue((result.size() > 0));

    }

    /**
     * Test of getHashedPasswordByUsername method, of class RestaurantDao.
     */
    @Test
    public void testGetHashedPasswordByUsername() {
        System.out.println("getHashedPasswordByUsername");
        String username = "1234567";
        String expResult = null;
        String result = restaurantDao.getHashedPasswordByUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHashedPasswordByUsername2() {
        System.out.println("getHashedPasswordByUsername");
        String username = "lee";
        String password = "password";
        boolean result = false;
        String securePass = restaurantDao.getHashedPasswordByUsername(username);
        try {
            result = Decrypting.validatePassword(password, securePass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(CustomerDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue((result = true));
    }

    /**
     * Test of getRestaurantsByCountyId method, of class RestaurantDao.
     */
    @Test
    public void testGetRestaurantsByCountyId() {
        System.out.println("getRestaurantsByCountyId");
        int countyId = 100;

        ArrayList<Restaurant> result = restaurantDao.getRestaurantsByCountyId(countyId);
        assertTrue((result.isEmpty()));

    }

    @Test
    public void testGetRestaurantsByCountyId2() {
        System.out.println("getRestaurantsByCountyId");
        int countyId = 20;
        int restaurantId = 3;
        String username = "Joe";
        String password = "password";
        String name = "fat beely";
        String phone = "832638491";
        String street = "10 Oriel Hall";
        String town = "Dundalk";
        ArrayList<Restaurant> expResult = new ArrayList<Restaurant>();
        Restaurant r = new Restaurant(restaurantId, username, password, name, phone, street, town, countyId);
        expResult.add(r);
        ArrayList<Restaurant> result = restaurantDao.getRestaurantsByCountyId(countyId);
        assertEquals(expResult, result);

    }

}
