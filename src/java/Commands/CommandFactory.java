/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author zbo97
 */
public class CommandFactory {

    private CommandFactory() {

    }

    public static Command createCommand(String action) {
        Command c = null;
        if (action != null) {
            switch (action) {
                case "customerRegister":
                    c = new CustomerRegisterCommand();
                    break;
                case "customerLogin":
                    c = new CustomerLoginCommand();
                    break;
                case "restaurantLogin":
                    c = new RestaurantLoginCommand();
                    break;
                case "restaurantRegister":
                    c = new RestaurantRegisterCommand();
                    break;
                case "viewRestaurants":
                    c = new ViewAllRestaurantsCommand();
                    break;
                case "viewMenu":
                    c = new ViewMenuCommand();
                    break;
                 case "addFood":
                    c = new AddFoodCommand();
                    break;    
                case "logout":
                    c = new LogoutCommand();
                    break;
                default:
                    c = new NoActionSuppliedCommand();
                    break;
            }
        } else {
            c = new NoActionSuppliedCommand();
        }
        return c;
    }
}
