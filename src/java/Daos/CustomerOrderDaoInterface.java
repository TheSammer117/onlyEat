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
public interface CustomerOrderDaoInterface {

    public int getCustomerIdByOrderId(int orderId);

    public ArrayList<OrderDetail> getOrderDetails(int foodId);

    public int FinishOrder(int orderId);
    
    public int createACustomerOrder(int customerId, String customerMessage);

}
