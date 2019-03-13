/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Food;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author samiwise
 */
public class ShoppingCart {

    private double totalPrice;
    private ArrayList<Food> cart;

    public ShoppingCart() {
        totalPrice = 0.0;
        cart = new ArrayList<Food>();
    }

    public void addToCart(Food food) {
        cart.add(food);
        totalPrice += food.getPrice();
    }

    public void removeFromCart(Food food) {
        cart.remove(food);
        totalPrice -= food.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Food> displayCart() {
        ArrayList<Food> foodCart = new ArrayList<>();
        cart.forEach((food) -> {
            foodCart.add(food);
        });
        return foodCart;
    }

    public void display(JspWriter out) {
        try {
            java.text.DecimalFormat currency = new java.text.DecimalFormat("$ #,###,##0.00");
            //
            // start the table and output the header row
            //
            out.println("<h3>Cart contents</h3>");
            out.println("<table border=1>");
            out.println("<tr><th>UPC</th><th>Name</th><th>Price</th><th>Quantity</th><th>Total</th></tr>");

            double total = 0;
            // 
            // output one item at a time from the cart, one item to a row table
            //
            for (int i = 0; i < cart.size(); i++) {
                Food food = (Food) cart.get(i);
                out.println(
                        "<td>" + food.getName() + "</td>"
                        + "<td align=right>" + currency.format(food.getPrice()) + "</td>");
            }
            //
            // add summary information (total, tax, grand total)
            //
            out.println("<tr><td colspan = 4>Total purchase</td>");
            out.println("<td align=right>" + currency.format(total) + "</td></tr>");
            out.println("<tr><td colspan = 4>Sales tax @6%</td>"
                    + "<td align=right>" + currency.format(total * .06) + "</td></tr>");
            out.println("<tr><td colspan = 4>Amount due</td>"
                    + "<td align=right>" + currency.format(total * 1.06) + "</td></tr>");
            out.println("</table>");

        } catch (IOException ex) {
            // exception was thrown by the out object, so we can't really report it to the client
            System.err.println(ex.toString());  // just send the exception to the error log
        }
    }
}
