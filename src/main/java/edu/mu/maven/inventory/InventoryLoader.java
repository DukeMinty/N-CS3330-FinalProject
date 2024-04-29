package edu.mu.maven.inventory;

import edu.mu.maven.inventory.Item;
import edu.mu.maven.inventory.Region;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryLoader {
	public List<Item> loadItemsFromFile(String filename) throws IOException {
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String id = parts[0];
                        String name = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        int stock = Integer.parseInt(parts[3]);
                        Region region = Region.valueOf(parts[4].toUpperCase());

                        Item item = new Item(id, name, price, stock, region);
                        items.add(item);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid item line: " + line);
                    }
                }
            }
        }
        return items;
    }
}
