/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author samiwise
 */
public interface ShoppingCartDaoInterface {
     public int addToCart(int customer_id, int food_id, int quantity);
     public int removeFromCart(int customer_id, int food_id);
}
