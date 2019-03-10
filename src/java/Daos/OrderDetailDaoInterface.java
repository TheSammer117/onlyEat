/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.OrderDetail;
import java.util.ArrayList;

/**
 *
 * @author 82509
 */
public interface OrderDetailDaoInterface {

    public int getFoodAmount(int orderId, int foodId);

    public ArrayList<OrderDetail> getFoodDetails(int foodId);
     public int getOrderIdByFoodId(int foodId);
      public ArrayList<Integer> getFoodIdByOrder(int orderId);

}
