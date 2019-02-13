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
public class C_address {
    private int addressId;
    private int customerId;
    private String address1;
    private String address2;
    private String address3;
    
    public C_address(){
        this.addressId = 0;
        this.customerId = 0;
        this.address1 = null;
        this.address2 = null;
        this.address3 = null;
    }

    public C_address(int addressId, int customerId, String address1, String address2, String address3) {
        this.addressId = addressId;
        this.customerId = customerId;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.addressId;
        hash = 37 * hash + this.customerId;
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
        final C_address other = (C_address) obj;
        if (this.addressId != other.addressId) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "C_address{" + "addressId=" + addressId + ", customerId=" + customerId + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + '}';
    }
    
}
