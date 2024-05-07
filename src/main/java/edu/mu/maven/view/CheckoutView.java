package edu.mu.maven.view;

import java.util.ArrayList;

import edu.mu.maven.address.Address;
import edu.mu.maven.inventory.Item;

public class CheckoutView {
	private Address shippingAddress = null;
	private String arrivalDate = "";
	private double cartTotal = 0;
	private ArrayList<Item> cart = null;
	
	public CheckoutView() {
		
	}
	
	public CheckoutView(CheckoutView original) {  // Copy constructor
		shippingAddress = original.shippingAddress;
		arrivalDate = original.arrivalDate;
		cartTotal = original.cartTotal;
		cart = original.cart;
	}
	
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public void setCartTotal(double total) {
		this.cartTotal = total;
	}
	
	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
	
	public void printCart() {
		for (Item i : cart) {
			System.out.println("\t" + i.getName());
		}
	}
	public void print() {
		System.out.println("Order Details");
		System.out.println("Items:");
		printCart();
		System.out.println("Cart Total: " + Double.toString(cartTotal));
		System.out.println("Shipping to:");
		System.out.println(shippingAddress.toString());
		System.out.println("Arriving on:");
		System.out.println(arrivalDate);
	}
}
