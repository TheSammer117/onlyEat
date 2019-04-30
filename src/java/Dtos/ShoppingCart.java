/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author samiwise
 */
public class ShoppingCart {
    private int customer_id;
    private int food_id;
    private int quantity;
    
    public ShoppingCart(){
        
    }
    

    public ShoppingCart(int customer_id, int food_id, int quantity){
        this.customer_id = customer_id;
        this.food_id = food_id;
        this.quantity = quantity;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.customer_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingCart other = (ShoppingCart) obj;
        if (this.customer_id != other.customer_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "customer_id=" + customer_id + ", food_id=" + food_id + ", quantity=" + quantity + '}';
    }
    
    
}
