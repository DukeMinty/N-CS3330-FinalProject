package edu.mu.maven.userOptions;

import java.util.Scanner;
import java.util.ArrayList;

import edu.mu.maven.Main;
import edu.mu.maven.address.Address;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.controller.CheckoutController;
import edu.mu.maven.shippingDetails.ShippingDetails;
import edu.mu.maven.shippingStrategies.ShippingContext;
import edu.mu.maven.shippingStrategies.strategies.*;


public class CheckoutOptions {
	public static void checkoutMenu(Scanner scanner, ShopperController shoppingController) {
		// Allows the user to checkout, continue shopping or logout.
		// Returns 1 or 0. If 0 is returned, the user can continue shopping. 

		CheckoutController checkoutController = new CheckoutController();
		checkoutController.setCart(shoppingController.getShopperCart());
		Boolean logout = false;
		int choice;
		while (!logout) {
			choice = menuChoices(scanner, shoppingController);
			
			switch(choice) {
			case 1:
				viewCart(checkoutController, scanner);
				break;
			case 2:
				checkoutCart(scanner, shoppingController, checkoutController);
				break;
			case 3:
				logout = true; // logout
			}
		}
		
		Main.callMain();
	}
	
	public static int menuChoices(Scanner scanner, ShopperController controller) {
		System.out.println("Hello " + controller.getShopperUsername() + ". What would you like to do?");
		System.out.println("1. View Cart\n2. Checkout\n3. Logout");
		int userMenuInput = 0;
		
        while (userMenuInput == 0) {
            try {
                userMenuInput = Integer.parseInt(scanner.nextLine());
                if(userMenuInput >= 1 && userMenuInput <= 3) {
                	break;
                }else {
                	System.out.println("Invalid choice");
                	userMenuInput = 0;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
                userMenuInput = 0;
            }
        }
        return userMenuInput;
	}
	
	public static void viewCart(CheckoutController controller, Scanner scanner) {
		System.out.println("Cart Total: $" + Double.toString(controller.getCartTotal()));
		controller.printCart();
		returnToCheckoutMenuOption(scanner);
		
	}
	public static void checkoutCart(Scanner scanner, ShopperController shopperCont, CheckoutController controller) {
		ArrayList<Item> cart = shopperCont.getShopperCart();
		if (cart.size() == 0) {
			System.out.println("The cart is currently empty. Returning to the checkout menu.");
		}
		else {
			controller.setCart(cart);
			
			Address destination = ShippingDetails.readShippingDetails(scanner);
			controller.setAddress(destination);
			
			ShippingContext context = new ShippingContext();
			context.setStrategy(getShippingStrategy(scanner));
			String arrivalDate = context.getArrivalDate();
			controller.setArrivalDate(arrivalDate);
			
			ShippingDetails.readBankingDetails(scanner);  // This is not being saved anywhere and is implemented purely for simulation purposes.
			
			controller.updateView();
			
			System.out.println("Success! Your order has been placed.");
			controller.getView().print();
			
			shopperCont.addToShopperBalance(-controller.getCartTotal());
			clearCart(shopperCont);
			returnToCheckoutMenuOption(scanner);
		}
	}
	
	private static void clearCart(ShopperController controller) {
		ArrayList<Item> cart = controller.getShopperCart();
		cart.clear();
	}
	
	public static AbstractShippingStrategy getShippingStrategy(Scanner scanner) {
		System.out.println("Please select a shipping type.");
		System.out.println("1. Express (1 day)\n2. Standard (1-2 weeks)");
		
		AbstractShippingStrategy strategy = null;
		int userMenuInput = 0;
		
        while (userMenuInput == 0) {
            try {
                userMenuInput = Integer.parseInt(scanner.nextLine());
                if (userMenuInput == 1) {
                	strategy = new ExpressStrategy();
                }
                else if (userMenuInput == 2) {
                	strategy = new StandardStrategy();
                }
                else {
                	System.out.println("Invalid choice");
                	userMenuInput = 0;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
                userMenuInput = 0;
            }
        }
        
        return strategy;
	}
	
	public static void returnToCheckoutMenuOption(Scanner scanner) {
		System.out.println("Enter any number to return to the checkout menu");
		Boolean finished = false;
		
		while (!finished) {
            try {
                Integer.parseInt(scanner.nextLine());
                finished = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
                finished = false;
            }
        }
	}
	
}
