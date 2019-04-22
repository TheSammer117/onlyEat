/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import java.util.ArrayList;

/**
 *
 * @author zbo97
 */
public interface CartDaoInterface {
    public ArrayList<Cart> getCartListByCustomerId(int customerId);
    
    public void addToCart(int customerId, int foodId, int quantity);
    
    public int removeAnItemFromCart(int customerId, int foodId, int quantity);
}
