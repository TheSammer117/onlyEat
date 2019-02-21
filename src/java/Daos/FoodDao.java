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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author samiwise
 */
public class FoodDao extends Dao implements FoodDaoInterface {

    public FoodDao(String databaseName) {
        super(databaseName);
    }

  
    @Override
    public ArrayList<Food> getFoodByRestaurantId(int restaurantId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Food food = null;
        ArrayList<Food> fList = new ArrayList<>();

        try {
            conn = getConnection();
            String query = "SELECT * FROM food WHERE restaurant_id = ?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, restaurantId);
            rs = ps.executeQuery();

            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getDouble("price"));
                food.setTypeId(rs.getInt("type_id"));
                fList.add(food);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured  in the getFoodByRestaurantId() method: " + e.getMessage());
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
    }

    @Override
    public int addAFood(Food f) {
          Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int newId = -1;
        try {
            con = this.getConnection();
            String query = "INSERT INTO food(food_id, restaurant_id, name, price, type_id) VALUES(NUll, ?, ?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            String name = f.getName();
            int restaurantId = f.getRestaurantId();
            double price = f.getPrice();
            int typeId = f.getTypeId();
            ps.setInt(1, restaurantId);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, typeId);
            ps.executeUpdate();
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred in addABook() " + ex.getMessage());
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
                System.err.println("A problem occurred when closing down the addABook():\n" + e.getMessage());
            }
        }
        return newId;
    }
}
