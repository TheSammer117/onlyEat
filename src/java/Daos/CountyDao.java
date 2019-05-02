/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.County;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 82509
 */
public class CountyDao extends Dao implements CountyDaoInterface {

    public CountyDao(String databaseName) {
        super(databaseName);
    }
/**
 * This pulls all the counties from the db
 * @return an arraylist of counties
 */
    @Override
    public ArrayList<County> getAllCounties() {
            Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<County> CountyArr = new ArrayList();

        try {
            con = this.getConnection();
            String query = "SELECT * FROM county";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int countyId = rs.getInt("county_id");
                String name = rs.getString("name");
                County l = new County(countyId, name);
                CountyArr.add(l);
            }
        } catch (SQLException e) {
            System.err.println("A problem occurred in getAllCounties() method:\n" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the getAllCounties() method:\n" + e.getMessage());
            }
        }
        return CountyArr;
    }

    /**
     * 
     * Gets a county by it's id
     * @param countyId
     * @return the county with the id of the parameter
     */
    @Override
    public County getCountyById(int countyId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        County c = new County();
        
        try {
            con = getConnection();
            String query = "SELECT * FROM county WHERE county_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, countyId);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setCountyId(countyId);
                c.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("Exception occured in the getCountyById() method: " + ex.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    freeConnection(con);
                }
            } catch(SQLException e){
                System.out.println("Exception occured in the finally section of the getCountyById() method, " + e.getMessage());
            }
        }
        return c;
    }
    
}
