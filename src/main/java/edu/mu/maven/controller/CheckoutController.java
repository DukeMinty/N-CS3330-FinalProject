package edu.mu.maven.controller;

import java.util.ArrayList;

import edu.mu.maven.address.Address;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.model.CheckoutModel;
import edu.mu.maven.view.CheckoutView;

public class CheckoutController {
	private CheckoutModel model = null;
	private CheckoutView view = null;
	
	public CheckoutController() {
		model = new CheckoutModel();
		view = new CheckoutView();
	}
	
	public void setCart(ArrayList<Item> userCart) {
		model.setCart(userCart);
	}
	
	public void setAddress(Address shippingAddress) {
		model.setShippingAddress(shippingAddress);
	}
	
	public void setArrivalDate(String date) {
		model.setArrivalDate(date);
	}
	
	public double getCartTotal() {
		double total = 0;
		for (Item i : model.getCart()) {
			total += i.getPrice();
		}
		
		return Math.floor(total*100) / 100;
	}
	
	public void printCart() {
		System.out.println("Your cart currently contains: ");
		for (Item i : model.getCart()) {
			System.out.println("\t" + i.getName());
		}
	}
	
	public void updateView() {
		view.setArrivalDate(model.getArrivalDate());
		view.setShippingAddress(model.getShippingAddress());
		view.setCartTotal(getCartTotal());
		view.setCart(model.getCart());
	}
	
	public CheckoutView getView() {
		CheckoutView viewCopy = new CheckoutView(view);
		return viewCopy;
	}
	
	
}
