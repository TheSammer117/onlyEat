/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.RestaurantDao;
import Dtos.Restaurant;
import Hashing.Decrypting;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String securedPassword = null;
        boolean matched = false;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            RestaurantDao rDao = new RestaurantDao("delivery");
            securedPassword = rDao.getHashedPasswordByUsername(username);
            try {
                matched = Decrypting.validatePassword(password, securedPassword);
            } catch (NoSuchAlgorithmException ex) {
                String errorMessage = "DecryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            } catch (InvalidKeySpecException ex) {
                String errorMessage = "DecryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
            if (matched) {
                Restaurant r = rDao.getRestaurantByUsernamePassword(username, securedPassword);
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
                String errorMessage = "Password or Username incorrect";
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
