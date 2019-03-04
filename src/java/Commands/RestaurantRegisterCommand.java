/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.RestaurantDao;
import Dtos.Restaurant;
import Hashing.Encrypting;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
        String securedPassword = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String street = request.getParameter("street");
        String town = request.getParameter("town");
        int countyId = 0;
     try {
            countyId = Integer.parseInt(request.getParameter("countyId"));
        } catch (NumberFormatException e) {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        if (username != null && !username.equals("") && !phone.equals("") && password != null && !password.equals("") && name != null && phone != null && street != null&& town != null&& countyId != 0) {
            RestaurantDao rDao = new RestaurantDao("delivery");
            try {
                securedPassword = Encrypting.generatePasswordHash(password);
            } catch (NoSuchAlgorithmException ex) {
                String errorMessage = "EncryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            } catch (InvalidKeySpecException ex) {
                String errorMessage = "EncryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
            int newId = rDao.registerRestaurant(username, securedPassword, name, phone, street, town ,countyId);
            if (newId != -1) {

                Restaurant r = rDao.getRestaurantByUsernamePassword(username, securedPassword);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "AccountCreadtedsuccessfully");
                session.setAttribute("loggedInRestaurant", r);

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
