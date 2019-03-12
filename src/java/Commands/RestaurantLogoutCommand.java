/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 82509
 */
public class RestaurantLogoutCommand implements Command {

    public RestaurantLogoutCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "restaurantIndex.jsp";
        HttpSession session = request.getSession();
        // To log a user out, wipe their session clear
        session.invalidate();
        return forwardToJsp;
    }
    
}
