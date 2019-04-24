/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 82509
 */
public class CustomerOrderDao extends Dao implements CustomerOrderDaoInterface {

    public CustomerOrderDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int getCustomerIdByOrderId(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int customerId = 0;

        try {
            con = getConnection();

            String query = "Select customer_id from customer_order where order_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            while (rs.next()) {
                customerId = rs.getInt("customer_id");

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCustomerIdByOrderId() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getCustomerIdByOrderId() method: " + e.getMessage());
            }
        }

        return customerId;
    }

    @Override
    public ArrayList<OrderDetail> getOrderDetails(int foodId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Date currentDate;
        currentDate = new Date();
        OrderDetail o = null;
        ArrayList<OrderDetail> OrderDetails = new ArrayList();
        try {
            con = this.getConnection();
            String query = "select * from order_detail inner join food on food.food_id = order_detail.food_id inner join customer_order  on customer_order.order_id = order_detail.order_id where food.food_id =? and order_date =? and status =1";
            ps = con.prepareStatement(query);
            ps.setInt(1, foodId);
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
            ps.setDate(2, sqlCurrentDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int quantiy = rs.getInt("quantity");
                o = new OrderDetail(orderId, foodId, quantiy);
                OrderDetails.add(o);
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getOrderDetails(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the getOrderDetails():\n" + e.getMessage());
            }
        }
        return OrderDetails;
    }

    @Override
    public int FinishOrder(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = this.getConnection();
            String query = "UPDATE customer_order SET status=0 WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the FinishOrder method:");
            System.err.println("\t" + e.getMessage());
            rowsAffected = 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the FinishOrder method:\n" + e.getMessage());
            }
        }
        return rowsAffected;
    }

    @Override
    public int createACustomerOrder(int customerId, String customerMessage) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        Date currentDate;
        currentDate = new Date();
        int newId = -1;
        try {
            con = getConnection();
            String query = "INSERT INTO customer_order (customer_id, customer_message, order_date, is_paid, status) VALUES (?, ?, ?, 1, 1)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.setString(2, customerMessage);
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
            ps.setDate(3, sqlCurrentDate);
            ps.executeUpdate();
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
            
        } catch (SQLException ex) {
            System.err.println("\tA problem occurred during the createACustomerOrder() method:");
            System.err.println("\t" + ex.getMessage());
            newId = -1;
        }finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the createACustomerOrder method:\n" + e.getMessage());
            }
        }
        return newId;
    }

}
