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
                    c = new ViewRestaurantsCommand();
                    break;
                case "saveCustomerProfile":
                    c = new SaveCustomerProfileCommand();
                    break;
                case "viewMenu":
                    c = new ViewMenuCommand();
                    break;
                case "addFood":
                    c = new AddFoodCommand();
                    break;
                case "deleteFood":
                    c = new DeleteFoodCommand();
                    break;
                case "updatePrice":
                    c = new UpdatePriceCommand();
                    break;
                case "confirmOrder":
                    c = new ConfirmOrderCommand();
                    break;
                case "logout":
                    c = new LogoutCommand();
                    break;
                case "restaurantLogout":
                    c = new RestaurantLogoutCommand();
                    break;
                case "addToCart":
                    c = new AddToCartCommand();
                    break;
                case "removeFromCart":
                    c = new RemoveFromCartCommand();
                    break;
                case "placeOrder":
                    c = new PlaceOrderCommand();
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
