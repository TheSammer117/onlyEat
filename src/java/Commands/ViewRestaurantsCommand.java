/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CountyDao;
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
public class ViewRestaurantsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int countyId = 0;
        try {
            countyId = Integer.parseInt(request.getParameter("selectedCountyId"));
        } catch (NumberFormatException e) {
            String errorMessage = "IncorrectCountyId";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }

        if (countyId > 0) {
            RestaurantDao rDao = new RestaurantDao("delivery");
            ArrayList<Restaurant> rList = rDao.getRestaurantsByCountyId(countyId);
            CountyDao cDao = new CountyDao("delivery");
            
            String countyName = cDao.getCountyById(countyId).getName();
            HttpSession session = request.getSession();

            session.setAttribute("restaurantList", rList);
            session.setAttribute("countyName", countyName);

            forwardToJsp = "DisplayRestaurants.jsp";
        }else{
            String errorMessage = "IncorrectCountyId";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }

        return forwardToJsp;
    }

}
