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
 * @author samiwise
 */
public class ViewMenuOfRestaurantCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       String forwardToJsp = "";
       int menuId = Integer.parseInt(request.getParameter("menuId"));
       if(menuId > 0 ){
           FoodDao fDao = new FoodDao("delivery");
           
           ArrayList<Food> foodList = fDao.getFoodByMenuId(menuId);
           
           HttpSession session = request.getSession();
           session.setAttribute("foodList", foodList);
           
           forwardToJsp = "DisplayMenu.jsp";
       } else {
           forwardToJsp = "error.jsp";
           
           HttpSession session = request.getSession();
           
           session.setAttribute("errorMessage", "A parameter Value required for viewing the menu was missing.");
       }
       return forwardToJsp;
    }
    
}
