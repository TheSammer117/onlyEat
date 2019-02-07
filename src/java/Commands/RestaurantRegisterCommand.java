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
 * @author d00189923
 */
public class RestaurantRegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        if (username != null && !username.equals("") && !phone.equals("") && password != null && !password.equals("") && name != null && phone != null ) {
            RestaurantDao rDao = new RestaurantDao("delivery");
            int newId = rDao.registerRestaurant(username, password, name, phone);
            if (newId != -1) {

                Restaurant r = rDao.getRestaurantByUsernamePassword(username, password);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "AccountCreadtedsuccessfully");
                session.setAttribute("loggedRestaurant", r);

                forwardToJsp = "restaurantIndex.jsp";
            } else {

                String errorMessage = "registerError1";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        } else {

            String errorMessage = "registerError2";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }

        return forwardToJsp;
    }
}
