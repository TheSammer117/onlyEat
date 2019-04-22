/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author zbo97
 */
public class Cart {
    private int customerId;
    private int food_Id;
    private int quantity;
    
    public Cart(){
        this.customerId = 0;
        this.food_Id = 0;
        this.quantity = 0;
    }

    public Cart(int customerId, int food_Id, int quantity) {
        this.customerId = customerId;
        this.food_Id = food_Id;
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFood_Id() {
        return food_Id;
    }

    public void setFood_Id(int food_Id) {
        this.food_Id = food_Id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.customerId;
        hash = 43 * hash + this.food_Id;
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
        final Cart other = (Cart) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.food_Id != other.food_Id) {
            return false;
        }
        return true;
    }
    
}
