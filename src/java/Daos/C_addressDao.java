/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.C_address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zbo97
 */
public class C_addressDao extends Dao implements C_addressDaoInterface {

    public C_addressDao(String databaseName) {
        super(databaseName);
    }

    /**
     * 
     * This method is passed a customer's id, and queries
     * the db for a customer with that id
     * 
     * 
     * @param customerId
     * @return the address of the customer with the passed id 
     */
    @Override
    public C_address getCustomerAddressByCustomerId(int customerId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        C_address ca = new C_address();
        try {
            con = this.getConnection();
            String query = "SELECT * FROM c_address WHERE customer_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int addressId = rs.getInt("address_id");
                String address1 = rs.getString("address1");
                String address2 = rs.getString("address2");
                String address3 = rs.getString("address3");
                ca = new C_address(addressId, customerId, address1, address2, address3);
            }
        } catch (SQLException ex) {
            System.out.println("A problem occurred while attempting getCustomerAddressByCustomerId() method");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the resultset in the getCustomerAddressByCustomerId() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("A problem occurred while attempting to close the prepared statement in the getCustomerAddressByCustomerId() method");
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            if (con != null) {
                freeConnection(con);
            }
        }
        return ca;
    }

    /**
     * This method takes in values of a customer's address and inserts them
     * into the customer address table
     * 
     * @param customerId
     * @param address1
     * @param address2
     * @param address3
     * @return the new id of the customer address in the table if worked, if failed 
     * it returns -1
     */
    @Override
    public int addCustomerAddress(int customerId, String address1, String address2, String address3) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int newId = -1;
        try {
            con = getConnection();

            String query = "INSERT INTO c_address(customer_id, address1, address2, address3) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.setString(2, address1);
            ps.setString(3, address2);
            ps.setString(4, address3);
            ps.executeUpdate();
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("\tA problem occurred during the addCustomerAddress() method:");
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
                System.err.println("A problem occurred when closing down the addCustomerAddress method:\n" + e.getMessage());
            }
        }
        return newId;
    }

    /**
     * This method takes in values for a customer's address to be replaced (updates) 
     * the old address values.
     * @param customerId
     * @param address1
     * @param address2
     * @param address3
     * @return the number of rows updated if any.
     */
    @Override
    public int updateCustomerAddress(int customerId, String address1, String address2, String address3) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;
        try {
            conn = getConnection();
            String query = "update c_address set address1 =  ?, address2 = ?, address3 = ? where customer_id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, address1);
            ps.setString(2, address2);
            ps.setString(3, address3);
            ps.setInt(4, customerId);
            rowsUpdated = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("An exception occurred in the updateCustomerAddress(): " + ex.getMessage());
        }finally {

            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the updateCustomerAddress(): " + e.getMessage());
            }

            freeConnection(conn);
        }
        return rowsUpdated;
    }

}
