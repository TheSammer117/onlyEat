/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.County;
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
public class CountyDaoTest {

    private CountyDao countyDao;

    public CountyDaoTest() {
        countyDao = new CountyDao("delivery");
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
     * Test of getAllCounties method, of class CountyDao.
     */
    @Test
    public void testGetAllCounties() {
        System.out.println("getAllCounties");
        ArrayList<County> result = countyDao.getAllCounties();
        assertTrue((result.size() > 0));
    }

}
