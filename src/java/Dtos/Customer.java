/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author d00189969
 */
public class Customer {
    private int customerId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private int addressId;

    public Customer(){
        this.customerId = 0;
        this.username = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
        this.addressId = 0;
    }
    
    public Customer(int customerId, String username, String password, String firstName, String lastName, String phone, int addressId) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.addressId = addressId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.customerId;
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + this.addressId;
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
        final Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.addressId != other.addressId) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", addressId=" + addressId + '}';
    }
    
    
}
