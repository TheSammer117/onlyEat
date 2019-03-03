/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.FoodDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 82509
 */
public class UpdatePriceCommand implements Command {

    public UpdatePriceCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int restaurantId = 0;
        int foodId = 0;
        double price = 0;
        //get necessary information
        try {
            //numberFormatException may occur when parse string to int
            price = Double.parseDouble(request.getParameter("price"));
            restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
            foodId = Integer.parseInt(request.getParameter("foodId"));
        } catch (NumberFormatException e) {
            //if the exception occur then go to the error page
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
//check if the information is valid
        if (restaurantId != 0 && foodId != 0 && price != 0) {
            //if they are  valid then make change to the database and add message to session
            FoodDao fDao = new FoodDao("delivery");
            fDao.updatePrice(restaurantId, foodId, price);
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Pricechangedsuccessfully");
             forwardToJsp = "restaurantIndex.jsp";
        } else {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        return forwardToJsp;
    }
}
