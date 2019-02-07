/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.RestaurantDao;
import Dtos.Restaurant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 82509
 */
public class RestaurantLoginCommand implements Command {

    public RestaurantLoginCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         String forwardToJsp = null;


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            RestaurantDao rDao = new RestaurantDao("delivery");
            Restaurant r = rDao.getRestaurantByUsernamePassword(username, password);

            if (r != null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInRestaurant", r);
                forwardToJsp = "restaurantIndex.jsp";
            } else {

                String errorMessage = "Norestaurantfoundmatchingthosedetails";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        } else {

            String errorMessage = "loginError";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    
}
