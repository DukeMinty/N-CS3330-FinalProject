package edu.mu.maven.userOptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Scanner;

class AdminOptionsTest {

    private AdminOptions adminOptions;
    private Scanner scanner;

    @Mock
    private ShopperArraylistController mockShopperController;
    @Mock
    private AdminController mockAdminController;
    @Mock
    private ArrayList<Item> mockItems;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        scanner = new Scanner(System.in); 
        adminOptions = new AdminOptions(scanner, mockAdminController, mockShopperController, mockItems);
    }

    @AfterEach
    void tearDown() {
        scanner.close();
    }

    @Test
    void testAddStockToInventory() {
        // Setup initial conditions
        Item item = new Item("001", "Green Tea", 1.99, 100, Region.AMERICAN);
        mockItems.add(item);

        // Simulate adding stock
        int additionalStock = 50;
        adminOptions.addStockToInventory("001", additionalStock);

        // Verify the stock was increased
        assertEquals(150, item.getStock(), "Stock should be updated to 150");
    }

    @Test
    void testDeleteShopperAccounts() {
        // Setup conditions
        ShopperModel shopper = new ShopperModel("user1", "pass1", 100.0);
        when(mockShopperController.checkShopperExistence("user1", "pass1")).thenReturn(shopper);

        // Simulate deleting the account
        adminOptions.deleteShopperAccounts("user1", "pass1");

        // Verify the method to remove the shopper was called
        verify(mockShopperController).removeShopperFromList(shopper);
    }

    @Test
    void testChangePriceOfInventory() {
        // Setup initial conditions
        Item item = new Item("002", "Black Coffee", 2.99, 50, Region.KOREAN);
        mockItems.add(item);

        // Simulate price change
        adminOptions.changePriceOfInventory("002", 3.99);

        // Verify the price was changed
        assertEquals(3.99, item.getPrice(), "Price should be updated to 3.99");
    }


}
