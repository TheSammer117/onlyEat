/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CartDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbo97
 */
public class RemoveFromCartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int customerId = 0;
        int foodId = 0;
        int quantity = 0;
        int restaurantId = 0;
        try {
            customerId = Integer.parseInt(request.getParameter("customerId"));
            foodId = Integer.parseInt(request.getParameter("foodId"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        } catch (NumberFormatException e) {
            //if the exception occur then go to the error page
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        if(customerId != 0 && foodId != 0 && quantity != 0){
            CartDao cDao = new CartDao("delivery");
            cDao.removeAnItemFromCart(customerId, foodId, quantity);
            forwardToJsp = "ViewMenu.jsp?restId=" + restaurantId;
        }else {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }

        return forwardToJsp;
    }
    
}
