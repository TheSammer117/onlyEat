/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.County;
import java.util.ArrayList;

/**
 *
 * @author 82509
 */
public interface CountyDaoInterface {
    
     public ArrayList<County> getAllCounties();
     public County getCountyById(int countyId);
    
}
