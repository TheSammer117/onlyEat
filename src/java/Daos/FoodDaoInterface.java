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
    
    public Food getFood(int restaurantId, int foodId);

    public int addAFood(int restaurantId, String food, double price, int typeId);

    public int removeFood(int restaurantId, int foordId);
    
     public int updatePrice(int restaurantId, int foordId,double price);
     
     public Food getFoodByFoodId(int foodId);
}
