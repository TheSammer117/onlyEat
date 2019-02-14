/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.RestaurantDao;
import Dtos.Restaurant;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author samiwise
 */
public class ViewAllRestaurantsCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
     
        RestaurantDao rDao = new RestaurantDao("delivery");
        
        ArrayList<Restaurant> rList = rDao.getAllRestaurants();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("restaurantList", rList);
        
        forwardToJsp = "DisplayRestaurants.jsp";
        
        return forwardToJsp;
    }
    
    
}
