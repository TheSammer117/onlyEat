/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author d00189923
 */
public class RestaurantDao extends Dao implements RestaurantDaoInterface {

    public RestaurantDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int registerRestaurant(String username, String password, String name, String phone) {
        Connection con = null;
        PreparedStatement ps = null;

        ResultSet generatedKeys = null;

        int newId = -1;
        try {

            con = this.getConnection();

            String query = "INSERT INTO restaurant(username, password, name, phone) VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, phone);

            ps.executeUpdate();

            generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the registerRestaurant method:");
            System.err.println("\t" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the registerRestaurant method:\n" + e.getMessage());
            }
        }
        return newId;
    }
    
    @Override
    public Restaurant getRestaurantByUsernamePassword(String username, String password) {
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Restaurant r = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM restaurant WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int restaurantId = rs.getInt("restaurant_id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                r = new Restaurant(restaurantId, username, password, name, phone);
            }

        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting to select a specific user in the getRestaurantByUsernamePassword() method");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the resultset in the getRestaurantByUsernamePassword() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the prepared statement in the getRestaurantByUsernamePassword() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (con != null) {
                freeConnection(con);
            }
        }
        return r;
    }
    
    

}
