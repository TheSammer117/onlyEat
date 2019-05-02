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
    private String street;
    private String town;
    private int countyId;
    private String image;

    public Restaurant() {
        this.restaurantId = 0;
        this.username = null;
        this.password = null;
        this.name = null;
        this.phone = null;
        this.street = null;
        this.town = null;
        this.countyId = 0;
        this.image = null;

    }

    public Restaurant(int restaurantId, String username, String password, String name, String phone, String street, String town, int countyId) {
        this.restaurantId = restaurantId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.town = town;
        this.countyId = countyId;

    }  public Restaurant( String username, String password, String name, String phone, String street, String town, int countyId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.town = town;
        this.countyId = countyId;

    }public Restaurant(int restaurantId, String username, String password, String name, String phone, String street, String town, int countyId, String image) {
        this.restaurantId = restaurantId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.town = town;
        this.countyId = countyId;
        this.image = image;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.restaurantId;
        hash = 13 * hash + Objects.hashCode(this.username);
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
        return "Restaurant{" + "restaurantId=" + restaurantId + ", username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", street=" + street + ", town=" + town + ", countyId=" + countyId + '}';
    }

}
