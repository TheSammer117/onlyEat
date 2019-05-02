/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.FoodType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 82509
 */
public class FoodTypeDao extends Dao implements FoodTypeDaoInterface {

    public FoodTypeDao(String databaseName) {
        super(databaseName);
    }
    
    /**
     * Gets the food type by its food type id
     * @param typeId
     * @return food type selected
     */
    @Override
    public String getNameById(int typeId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String name = null;

        try {
            con = getConnection();

            String query = "Select name from food_type where type_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, typeId);
            rs = ps.executeQuery();

            while (rs.next()) {

                name = rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getNameById() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getNameById() method: " + e.getMessage());
            }
        }

        return name;
    }

    /**
     * Gets a list of all food types
     * @return arraylist of food types
     */
    @Override
    public ArrayList<FoodType> getAllFoodType() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<FoodType> Arr = new ArrayList();

        try {
            con = this.getConnection();
            String query = "SELECT * FROM food_type";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int typeId = rs.getInt("type_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                FoodType l = new FoodType(typeId, name, description);
                Arr.add(l);
            }
        } catch (SQLException e) {
            System.err.println("A problem occurred in getAllFoodType() method:\n" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the getAllFoodType() method:\n" + e.getMessage());
            }
        }
        return Arr;
    }
}
