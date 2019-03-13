/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.FoodDao;
import Daos.ShoppingCart;
import Dtos.Food;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author samiwise
 */
public class AddToCartCommand implements Command {

    public AddToCartCommand() {
    }
 @Override
 public String execute(HttpServletRequest request, HttpServletResponse response){
     String forwardToJsp = "ViewMenu.jsp?restId=1";//or send to foodCart?
     ShoppingCart cart = new ShoppingCart();
     int foodId = 0;
     try{
     foodId = Integer.parseInt(request.getParameter("foodId"));
     }catch(NumberFormatException e){
         String errorMessage = "food id on addToCartCommand wasn't a number.";
         HttpSession session = request.getSession();
         session.setAttribute("errorMessage", errorMessage);
         forwardToJsp = "error.jsp";
     }
     FoodDao fd = new FoodDao("delivery");
     Food food = fd.getFoodByFoodId(foodId);
     HttpSession session = request.getSession();
     session.setAttribute("food", food);
     
     
     return forwardToJsp;
 }
}
