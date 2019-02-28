/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.FoodDao;
import Dtos.Food;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author d00189923
 */
public class AddFoodCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        if (restaurantId != 0) {
            String name = request.getParameter("name");
            double price = 0;
            int typeId = 0;
            try {
                price = Double.parseDouble(request.getParameter("price"));
                typeId = Integer.parseInt(request.getParameter("typeId"));
            } catch (NumberFormatException e) {
                forwardToJsp = "error.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Notvaliddata");
            }

            if (name != null && !name.equals("") && price != -1 && restaurantId != 0 && typeId != 0) {
                FoodDao fDao = new FoodDao("delivery");
                int foodId = 0;
                foodId = fDao.addAFood(restaurantId, name, price, typeId);
                if (foodId != -1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessage", "foodAddedsuccessfully");
                    forwardToJsp = "restaurantIndex.jsp";
                } else {
                    forwardToJsp = "error.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "somethingWentWrong");
                }
            } else {
                forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "A parameter value required for viewing the menu was missing.");
            }

        }
        return forwardToJsp;
    }
}
