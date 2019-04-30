/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samiwise
 */
public class ShoppingCartDao extends Dao implements ShoppingCartDaoInterface{
    public ShoppingCartDao(String databaseName){
        super(databaseName);
    }
    
    @Override
    public int addToCart(int customer_id, int food_id, int quantity){
        Connection conn = null;
        PreparedStatement ps=null;
        int rowsAffected = 0;
        
        try{
            conn=this.getConnection();
            
            String query = "INSERT INTO shoppingCart(customer_id, food_id, quantity) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, food_id);
            ps.setInt(3, quantity);
            rowsAffected = ps.executeUpdate();
            
        }catch(SQLException e){
            System.err.println("\tA problem occured during the addFood() method in ShoppingCartDao");
            System.err.println("\t" + e.getMessage());
            rowsAffected = 0;
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(conn !=null){
                    freeConnection(conn);
                }
            } catch(SQLException e){
                System.err.println("A problem occured in the finally section of addFood() ShoppingCartDao");
            }
        }
        return rowsAffected;
    }
    
    @Override
    public int removeFromCart(int customer_id, int food_id){
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            conn = this.getConnection();
            
            String query = "DELETE FROM shoppingCart WHERE customer_id = ? AND food_id = ?";
            ps = conn.prepareStatement(query);
            
        }
    }
}
