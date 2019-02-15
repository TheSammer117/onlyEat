/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Food;
import java.util.ArrayList;

/**
 *
 * @author samiwise
 */
public interface FoodDaoInterface {
  public ArrayList<Food> getFoodByRestaurantId(int restaurantId);
}
