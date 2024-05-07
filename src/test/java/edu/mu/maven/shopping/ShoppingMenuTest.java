package edu.mu.maven.shopping;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.inventory.Region;
import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;
import edu.mu.maven.view.ShopperView;

public class ShoppingMenuTest {
	
	
	Scanner testScanner = null;
	String testInput = null;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("Running Before All");
		}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}


	@BeforeEach
	void setUp() throws Exception {
		testInput = "1\n";
		testScanner = new Scanner(testInput);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testShoppingMenu() {
		boolean testMenu = ShoppingMenu.Menu(testScanner, null, null);
		assertTrue(testMenu);
	}

}
