/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author Sami
 */
public class Food {
    private int foodId;
    private int menuId;
    private String name;
    private double price;
    private int typeId;
    
    public Food(int foodId, int menuId, String name, double price, int typeId){
        this.foodId = foodId;
        this.menuId = menuId;
        this.price = price;
        this.typeId = typeId;
    }
    
        public Food(int menuId, String name, double price, int typeId){
        this.menuId = menuId;
        this.price = price;
        this.typeId = typeId;
    }
        
        public Food(){
            
        }
        
        @Override
        public int hashCode(){
            int hash = 3;
            hash = 41 * hash + this.foodId;
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
        final Food other = (Food) obj;
        if (this.foodId != other.foodId) {
            return false;
        }
        return true;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
        
        @Override
        public String toString(){
            return "Food ID:" + foodId +
                    "\nMenu ID: " + menuId +
                    "\nName: " + name+
                    "\nPrice: " + price +
                    "\nType ID: " + typeId;
        }
}
