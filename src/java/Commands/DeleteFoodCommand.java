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
public class DeleteFoodCommand implements Command {

    public DeleteFoodCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
          String forwardToJsp = "";
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        if (restaurantId != 0) {
            int foodId = 0;
            try {
            
                foodId = Integer.parseInt(request.getParameter("foodId"));
            } catch (NumberFormatException e) {
                forwardToJsp = "error.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Notvaliddata");
            }

            if (restaurantId != -1 && foodId != -1 ) {
                FoodDao fDao = new FoodDao("delivery");
                int rowsAffected = 0;
                rowsAffected= fDao.removeFood(restaurantId, foodId);
                if (rowsAffected != -1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessage", "foodDeletedSuccessfully");
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
