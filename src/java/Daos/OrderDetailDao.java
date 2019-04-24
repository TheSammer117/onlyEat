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
public class OrderDetailDao extends Dao implements OrderDetailDaoInterface {

    public OrderDetailDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int getFoodAmount(int orderId, int foodId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int amount = 0;

        try {
            con = getConnection();

            String query = "SELECT quantity FROM order_detail WHERE order_id = ? AND food_id =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.setInt(2, foodId);
            rs = ps.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("quantity");
            }

        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting to select a specific user in the getFoodAmount() method");
            System.out.println("Error: " + ex.getMessage());
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
                System.err.println("A problem occurred when closing down the getFoodAmount() method:\n" + e.getMessage());
            }
            freeConnection(con);
        }
        return amount;
    }

    @Override
    public ArrayList<OrderDetail> getFoodDetails(int foodId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderDetail a = null;
        ArrayList<OrderDetail> OrderDetail = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM order_detail WHERE food_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, foodId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int quantity = rs.getInt("quantity");

                a = new OrderDetail(orderId, foodId, quantity);
                OrderDetail.add(a);
            }

        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting to select a specific user in the getFoodDetails() method");
            System.out.println("Error: " + ex.getMessage());
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
                System.err.println("A problem occurred when closing down the getFoodDetails() method:\n" + e.getMessage());
            }
            freeConnection(con);
        }
        return OrderDetail;
    }

    @Override
    public int getOrderIdByFoodId(int foodId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int orderId = 0;

        try {
            con = getConnection();

            String query = "Select order_id from order_detail where food_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, foodId);
            rs = ps.executeQuery();

            while (rs.next()) {
                orderId = rs.getInt("order_id");

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getOrderIdByFoodId() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getOrderIdByFoodId() method: " + e.getMessage());
            }
        }

        return orderId;
    }

    @Override
    public ArrayList<Integer> getFoodIdByOrder(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> foodIds = new ArrayList();
        try {
            con = this.getConnection();
            String query = "SELECT food_id FROM order_detail WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                foodIds.add(rs.getInt("food_id"));
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getFoodIdByOrder(): " + e.getMessage());
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
                System.err.println("A problem occurred when closing down the getFoodIdByOrder():\n" + e.getMessage());
            }
        }
        return foodIds;
    }

    @Override
    public int createAnOrderDetailByOrderId(int orderId, int foodId, int quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        Date currentDate;
        currentDate = new Date();
        int newId = -1;
        try {
            con = getConnection();
            String query = "INSERT INTO order_detail VALUES (?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderId);
            ps.setInt(2, foodId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("\tA problem occurred during the createAnOrderDetailByOrderId() method:");
            System.err.println("\t" + ex.getMessage());
            newId = -1;
        } finally {
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
                System.err.println("A problem occurred when closing down the createAnOrderDetailByOrderId method:\n" + e.getMessage());
            }
        }
        return newId;
    }

}
