/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Date;

/**
 *
 * @author 82509
 */
public class CustomerOrder {
    private int orderId;
    private int customerId;
    private String customerMessage;
    private Date orderDate;
    private int isPaid;
    private int status;

    public CustomerOrder() {
         this.orderId = 0;
        this.customerId = 0;
        this.customerMessage = null;
        this.orderDate = null;
        this.isPaid = 0;
        this.status = 0;
    }

    public CustomerOrder(int orderId, int customerId, String customerMessage, Date orderDate, int isPaid, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerMessage = customerMessage;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.orderId;
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
        final CustomerOrder other = (CustomerOrder) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" + "orderId=" + orderId + ", customerId=" + customerId + ", customerMessage=" + customerMessage + ", orderDate=" + orderDate + ", isPaid=" + isPaid + ", status=" + status + '}';
    }
    
}
