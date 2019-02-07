/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author d00189923
 */
public class Restaurant {

    private int restaurantId;
    private String username;
    private String password;
    private String name;
    private String phone;


    public Restaurant() {
        this.restaurantId = 0;
        this.username = null;
        this.password = null;
        this.name = null;
        this.phone = null;

    }

    public Restaurant(int restaurantId, String username, String password, String name, String phone) {
        this.restaurantId = restaurantId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
       
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.restaurantId;
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
        final Restaurant other = (Restaurant) obj;
        if (this.restaurantId != other.restaurantId) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "restaurantId=" + restaurantId + ", username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + '}';
    }

  

}
