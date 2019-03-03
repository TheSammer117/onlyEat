/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author d00189969
 */
public class CustomerDao extends Dao implements CustomerDaoInterface {

    public CustomerDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int registerCustomer(String username, String password, String firstName, String lastName, String phone) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int newId = -1;
        try {
            con = this.getConnection();

            String query = "INSERT INTO customer(username, password, first_name, last_name, phone) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, phone);
            ps.executeUpdate();
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the registerCustomer() method:");
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
                System.err.println("A problem occurred when closing down the registerCustomer method:\n" + e.getMessage());
            }
        }
        return newId;
    }

    @Override
    public Customer getCustomerByUsernamePassword(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM customer WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                c = new Customer(customerId, username, password, firstName, lastName, phone);
            }
        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting to select a specific user in the getUserByUsernamePassword() method");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the resultset in the getUserByUsernamePassword() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the prepared statement in the getUserByUsernamePassword() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (con != null) {
                freeConnection(con);
            }
        }
        return c;
    }

    @Override
    public int updateCustomerProfile(int customerId, String username, String firstName, String lastName, String phone) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;
        try {
            conn = getConnection();
            String query = "update customer set username =  ?, first_name = ?, last_name = ?, phone = ? where customer_id = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, phone);
            ps.setInt(5, customerId);
            rowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An exception occurred in the updateCustomerProfile(): " + e.getMessage());
        } finally {

            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the updateCustomerProfile(): " + e.getMessage());
            }

            freeConnection(conn);
        }
        return rowsUpdated;
    }

    @Override
    public String getHashedPasswordByUsername(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String securedPassword = null;
        try {
            con = getConnection();
            String query = "SELECT password FROM customer WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                securedPassword = rs.getString("password");
            }
        }catch (SQLException ex) {
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
}
