/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author  Sami Mahmoud
 */
public class Menu {
    private int menuId;
    private int restaurantId;
    
    public Menu(int menuId, int restaurant){
        this.menuId = menuId;
        this.restaurantId = restaurantId;
    }
    
    public Menu(int countyId){
        this.restaurantId = countyId;
    }
    
    @Override 
        public int hashCode(){
        int hash = 3;
        hash = 41 * hash + this.restaurantId;
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
        final Menu other = (Menu) obj;
        if (this.menuId != other.menuId) {
            return false;
        }
        return true;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


@Override
public String toString(){
    return "Menu ID: " + menuId + "\nRestaurant ID: " + restaurantId;
}
        
        
}
