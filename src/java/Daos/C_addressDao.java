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

/**
 *
 * @author zbo97
 */
public class C_addressDao extends Dao implements C_addressDaoInterface{

    public C_addressDao(String databaseName) {
        super(databaseName);
    }

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
        }finally {
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
    
}
