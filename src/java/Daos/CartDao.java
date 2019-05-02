/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zbo97
 */
public class CartDao extends Dao implements CartDaoInterface {

    public CartDao(String databaseName) {
        super(databaseName);
    }

    /**
     * Takes in a customer id to retrieve the cart of that customer
     * @param customerId
     * @return an arraylist containing the customer's cart items
     */
    @Override
    public ArrayList<Cart> getCartListByCustomerId(int customerId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cart cart = null;
        ArrayList<Cart> cartList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM cart WHERE customer_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int foodId = rs.getInt("food_id");
                int quantity = rs.getInt("quantity");
                cart = new Cart(customerId, foodId, quantity);
                cartList.add(cart);
            }
        } catch (SQLException ex) {
            System.out.println("Exception occured  in the getCartListByCustomerId() method: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getCartListByCustomerId() method: " + e.getMessage());
            }
        }
        return cartList;
    }

    /**
     * This adds food to a cart for a customer
     * @param customerId
     * @param foodId
     * @param quantity 
     */
    @Override
    public void addToCart(int customerId, int foodId, int quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        try {
            con = getConnection();
            String query = "INSERT INTO cart VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerId);
            ps.setInt(2, foodId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception occured  in the addToCart() method: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the addToCart method:\n" + e.getMessage());
            }
        }
    }

    /**
     * This removes an item from a customers cart
     * @param customerId
     * @param foodId
     * @param quantity
     * @return rows affected indiacating how many rows in the db that were changed
     */
    @Override
    public int removeAnItemFromCart(int customerId, int foodId, int quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "DELETE FROM cart WHERE customer_id = ? AND food_id = ? AND quantity = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerId);
            ps.setInt(2, foodId);
            ps.setInt(3, quantity);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("\tA problem occurred during the removeAnItemFromCart method:");
            System.err.println("\t" + ex.getMessage());
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
                System.err.println("A problem occured when closing down the removeAnItemFromCart method:\n" + e.getMessage());
            }
        }
        return rowsAffected;
    }

    /**
     * Empties a customers cart after they checkout
     * @param customerId
     * @return 
     */
    @Override
    public int emptyCartByCustomerId(int customerId) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = getConnection();
            String query = "DELETE FROM cart WHERE customer_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerId);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("\tA problem occurred during the emptyCartByCustomerId method:");
            System.err.println("\t" + ex.getMessage());
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
                System.err.println("A problem occured when closing down the emptyCartByCustomerId method:\n" + e.getMessage());
            }
        }
        return rowsAffected;
    }

}
