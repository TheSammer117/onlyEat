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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d00189923
 */
public class RestaurantDao extends Dao implements RestaurantDaoInterface {

    public RestaurantDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int registerRestaurant(String username, String password, String name, String phone, String street, String town, int countyId) {
        Connection con = null;
        PreparedStatement ps = null;

        ResultSet generatedKeys = null;

        int newId = -1;
        try {

            con = this.getConnection();

            String query = "INSERT INTO restaurant(username, password, name, phone, street, town, county_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, street);
            ps.setString(6, town);
            ps.setInt(7, countyId);

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
                String street = rs.getString("street");
                String town = rs.getString("town");
                int countyId = rs.getInt("county_id");

                r = new Restaurant(restaurantId, username, password, name, phone, street, town, countyId);
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

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            conn = getConnection();
            String query = "SELECT * FROM restaurant";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Restaurant r = new Restaurant(rs.getInt("restaurant_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("street"),
                        rs.getString("town"),
                        rs.getInt("county_id"));
                restaurants.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllRestaurants() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllRestaurants() method, " + e.getMessage());
            }
        }
        return restaurants;
    }

    @Override
    public String getHashedPasswordByUsername(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String securedPassword = null;
        try {
            con = getConnection();
            String query = "SELECT password FROM restaurant WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                securedPassword = rs.getString("password");
            }
        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting to select a specific user in the getHashedPasswordByUsername() method");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the resultset in the getHashedPasswordByUsername() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the prepared statement in the getHashedPasswordByUsername() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (con != null) {
                freeConnection(con);
            }
        }
        return securedPassword;
    }

    @Override
    public ArrayList<Restaurant> getRestaurantsByCountyId(int countyId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id;
        String username;
        String password;
        String name;
        String phone;
        String street;
        String town;

        ArrayList<Restaurant> restaurants = new ArrayList();
        try {
            con = getConnection();
            String query = "SELECT * FROM restaurant WHERE county_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, countyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("restaurant_id");
                username = rs.getString("username");
                password = rs.getString("password");
                name = rs.getString("name");
                phone = rs.getString("phone");
                street = rs.getString("street");
                town = rs.getString("town");
                countyId = rs.getInt("county_id");
                Restaurant r = new Restaurant(id, username, password, name, phone, street, town, countyId);
                restaurants.add(r);
            }
        } catch (SQLException ex) {
            System.out.println("Exception occured in the getRestaurantsByCountyId() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllRestaurants() method, " + e.getMessage());
            }
        }
        return restaurants;
    }
}
