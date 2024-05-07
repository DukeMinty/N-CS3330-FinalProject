package edu.mu.maven.inventory;

public class Item {
	private String id;
    private String name;
    private Region region;
    private double price;
    private int stock;

    // Constructor
    public Item(String id, String name, double price, int stock, Region region) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.region = region;
    }
    
    
 // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}