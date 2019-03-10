/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author 82509
 */
public class OrderDetail {

    private int orderId;
    private int foodId;
    private int quatity;

    public OrderDetail() {
        this.orderId = 0;
        this.foodId = 0;
        this.quatity = 0;

    }

    public OrderDetail(int orderId, int foodId, int quatity) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quatity = quatity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.orderId;
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
        final OrderDetail other = (OrderDetail) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderId=" + orderId + ", foodId=" + foodId + ", quatity=" + quatity + '}';
    }

}
