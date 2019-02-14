/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samiwise
 */
public class FoodDao extends Dao implements FoodDaoInterface {

    public FoodDao(String databaseName) {
        super(databaseName);
    }

    /**@Override
    public ArrayList<Food> getFoodByMenuId(int menuId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Food food = null;
        ArrayList<Food> fList = new ArrayList<>();

        try {
            conn = getConnection();
            String query = "SELECT * FROM food WHERE menu_id = ?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, menuId);
            rs = ps.executeQuery();

            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("food_id"));
                food.setMenuId(rs.getInt("menu_id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getDouble("price"));
                food.setTypeId(rs.getInt("type_id"));
                fList.add(food);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getFoodByMenuId() method: " + e.getMessage());
            e.printStackTrace();
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
                System.out.println("Exception occured in the finally section of the getFoodByMenuId() method: " + e.getMessage());
            }
        }
        return fList;
    }*/
}
