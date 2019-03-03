/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;


import Dtos.FoodType;
import java.util.ArrayList;

/**
 *
 * @author 82509
 */
public interface FoodTypeDaoInterface {
     public String getNameById(int typeId);
      public ArrayList<FoodType> getAllFoodType();
    
}
