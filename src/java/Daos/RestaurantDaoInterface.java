/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author d00189923
 */
public interface RestaurantDaoInterface {

    public int registerRestaurant(String username, String password, String name, String phone,String street, String town, int countyId);
     public Restaurant getRestaurantByUsernamePassword(String username, String password);
     public String getHashedPasswordByUsername(String username);
     public ArrayList<Restaurant> getAllRestaurants();
     public ArrayList<Restaurant> getRestaurantsByCountyId(int countyId);
}
