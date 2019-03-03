/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CustomerDao;
import Dtos.Customer;
import Hashing.Decrypting;
import Hashing.Encrypting;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbo97
 */
public class CustomerLoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        String securedPassword = null;
        boolean matched = false;

        // Get the username and password information that the user
        // entered into the form on the previous page
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            CustomerDao cDao = new CustomerDao("delivery");
            securedPassword = cDao.getHashedPasswordByUsername(username);
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
                Customer c = cDao.getCustomerByUsernamePassword(username, securedPassword);
                if (c != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", c);
                    forwardToJsp = "index.jsp";
                } else {
                    // The username and/or password didn't match someone in the database
                    // Send the user to the error page and inform them of this
                    String errorMessage = "Nouserfoundmatchingthosedetails";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", errorMessage);
                    forwardToJsp = "error.jsp";
                }
            }else{
                String errorMessage = "Password or Username incorrect";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", errorMessage);
                    forwardToJsp = "error.jsp";
            }

        } else {
            // The username and/or password was missing
            // Send the user to the error page and inform them of this
            String errorMessage = "loginError";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }

}
