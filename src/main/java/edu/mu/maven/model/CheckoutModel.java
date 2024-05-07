package edu.mu.maven.model;

import java.util.ArrayList;

import edu.mu.maven.address.Address;
import edu.mu.maven.inventory.Item;

public class CheckoutModel {
	private Address shippingAddress = null;
	private String arrivalDate = "";
	private ArrayList<Item> cart = null;
	
	
	public CheckoutModel() {
	}


	public Address getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public ArrayList<Item> getCart() {
		return cart;
	}


	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
	
}
