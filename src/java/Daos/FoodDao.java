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

    /**
     * Gets all the food by a specific restaurant by its id, passed via the param(menu)
     * @param restaurantId
     * @return arraylist of all the food the restaurant has on it's menu
     */
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

    /**
     * This method allows the restaurant to add food to their menu, taking in the values
     * @param restaurantId
     * @param food
     * @param price
     * @param typeId
     * @return new id of the food or -1 if failed
     */
    @Override
    public int addAFood(int restaurantId, String food, double price, int typeId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int newId = -1;
        try {
            con = this.getConnection();
            String query = "INSERT INTO food(food_id, restaurant_id, name, price, type_id) VALUES(NUll, ?, ?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, restaurantId);
            ps.setString(2, food);
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

    /**
     * removes a food item from a restaurants menu by the restaurants and food id
     * @param restaurantId
     * @param foordId
     * @return returns rows affected indicating how many rows were changed in the db
     */
    @Override
    public int removeFood(int restaurantId, int foordId) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = this.getConnection();

            String query = "DELETE FROM food WHERE restaurant_id = ? AND food_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, restaurantId);
            ps.setInt(2, foordId);

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the removeFood method:");
            System.err.println("\t" + e.getMessage());
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
                System.err.println("A problem occured when closing down the removeFood method:\n" + e.getMessage());
            }
        }
        return rowsAffected;
    }


    /**
     * allows the restaurant to update the price of one of their food items, by taking in new values
     * @param restaurantId
     * @param foordId
     * @param price
     * @return returns rows affected indicating how many rows were changed in the db
     */
    @Override
    public int updatePrice(int restaurantId, int foordId, double price) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;
        try {
            con = getConnection();

            String query = " UPDATE food SET price = ? WHERE food_id = ? AND restaurant_Id = ?";
            ps = con.prepareStatement(query);

            ps.setDouble(1, price);
            ps.setInt(2, foordId);
            ps.setInt(3, restaurantId);
            rowsUpdated = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updatePrice() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updatePrice() method");
                e.getMessage();
            }
        }
        return rowsUpdated;
    }

    /**
     * Gets a specific food item specified by the restaurant and food id
     * @param restaurantId
     * @param foodId
     * @return the Food item
     */
    @Override
    public Food getFood(int restaurantId, int foodId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Food food = null;

        try {
            conn = getConnection();
            String query = "SELECT * FROM food WHERE restaurant_id = ? AND  food_id =?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, restaurantId);
            ps.setInt(2, foodId);

            rs = ps.executeQuery();

            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getDouble("price"));
                food.setTypeId(rs.getInt("type_id"));

            }
        } catch (SQLException e) {
            System.out.println("Exception occured  in the getFood() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getFood() method: " + e.getMessage());
            }
        }
        return food;
    }
    /**
     * Gets a specific food item specified by food id
     * @param foodId
     * @return the Food
     */
    @Override
    public Food getFoodByFoodId(int foodId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Food food = null;

        try {
            conn = getConnection();
            String query = "SELECT * FROM food WHERE food_id =?";
            ps = conn.prepareStatement(query);

            
            ps.setInt(1, foodId);

            rs = ps.executeQuery();

            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getDouble("price"));
                food.setTypeId(rs.getInt("type_id"));

            }
        } catch (SQLException e) {
            System.out.println("Exception occured  in the getFoodByFoodId() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getFoodByFoodId() method: " + e.getMessage());
            }
        }
        return food;
    }
}
