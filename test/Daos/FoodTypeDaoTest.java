/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.FoodType;
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
public class FoodTypeDaoTest {

    private FoodTypeDao foodTypeDao;

    public FoodTypeDaoTest() {
        foodTypeDao = new FoodTypeDao("delivery");
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
     * Test of getAllFoodType method, of class FoodTypeDao.
     */
    @Test
    public void testGetAllFoodType() {
        System.out.println("getAllFoodType");
        ArrayList<FoodType> result = foodTypeDao.getAllFoodType();
        assertTrue((result.isEmpty()));
    }

    /**
     * Test of getNameById method, of class FoodTypeDao.
     */
    @Test
    public void testGetNameById() {
        System.out.println("getNameById");
        int typeId = 100;
        String expResult = null;
        String result = foodTypeDao.getNameById(typeId);
        assertEquals(expResult, result);

    }

}
