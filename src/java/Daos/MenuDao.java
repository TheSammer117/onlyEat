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
 * @author Sami
 */
public class MenuDao extends Dao implements MenuDaoInterface{
    
    public MenuDao(String databaseName){
        super(databaseName);
    }
    
    @Override
    public int getMenuIdByRestaurantId(int restaurantId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int menuId = 0;
        
        try{
            conn=getConnection();
            String query = "SELECT menu_id FROM menu WHERE restaurant_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, restaurantId);
            rs = ps.executeQuery();
            if(rs.next()){
                menuId = rs.getInt("menu_id");
            }
        } catch(SQLException e){
            System.out.println("Exception occured in the getMenuIdByRestaurantID() method: " + e.getMessage());
        } finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(conn != null){
                    freeConnection(conn);
                }
            } catch(SQLException e){
                System.out.println("Exception occured in the finally section of the getMenuIdByRestaurantId() method: " + e.getMessage());
            }
        }
        return menuId;
    }
}
