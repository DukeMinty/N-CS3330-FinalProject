package edu.mu.maven.shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.inventory.Region;
import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;
import edu.mu.maven.view.ShopperView;

public class ShoppingJapaneseTest {
	
	
	Scanner testScanner = null;
	String testInput = null;
	String testInput2 = null;
	String testInput3 = null;
	String testInput4 = null;
	String testInput5 = null;
	String testInput6 = null;
	String testInputP = null;
	private ShoppingJapanese testShopping = null;
	private List<Item> testList = null;
	private List<Item> testList2 = null;
	private List<Item> testList3 = null;
	private List<Item> testList4 = null;
	private List<Item> testList5 = null;
	private List<Item> testList6 = null;
	private List<Item> testListP = null;
	private ShopperModel testShopperModel = null;
	private ShopperController testShopperController = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Running Before All for shopping menu");
		}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}


	@BeforeEach
	void setUp() throws Exception {
		testShopping = new ShoppingJapanese();
		testShopperModel = new ShopperModel("1","123456",20.0);
		testShopperController = new ShopperController(testShopperModel, null);
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testShoppingMenu1() {
		testInput = "1\n";
		testScanner = new Scanner(testInput);
		testList = new ArrayList<>();
		Item item = new Item("010","Matcha Cake",4.0,110,Region.JAPANESE);
		testList.add(item);
		boolean testMenu = testShopping.ShopJapanese(testScanner, testList, testShopperModel, testShopperController);
		assertTrue(testMenu);
	}
	@Test
	@SuppressWarnings("static-access")
	void testShoppingMenu2() {
		testInput2 = "2\n";
		testScanner = new Scanner(testInput2);
		testList2 = new ArrayList<>();
		Item item2 = new Item("010","Matcha Cake",4.0,110,Region.JAPANESE);
		testList2.add(item2);
		boolean testMenu = testShopping.ShopJapanese(testScanner, testList2, testShopperModel, testShopperController);
		assertTrue(testMenu);
	}
	@Test
	@SuppressWarnings("static-access")
	void testShoppingMenu3() {
		testInput3 = "3\n";
		testScanner = new Scanner(testInput3);
		testList3 = new ArrayList<>();
		Item item3 = new Item("010","Matcha Cake",4.0,110,Region.JAPANESE);
		testList3.add(item3);
		boolean testMenu = testShopping.ShopJapanese(testScanner, testList3, testShopperModel, testShopperController);
		assertTrue(testMenu);
	}
	
	
	@Test
	@SuppressWarnings("static-access")
	void testShoppingMenuP() {
		testInputP = "P\n";
		testScanner = new Scanner(testInputP);
		testListP = new ArrayList<>();
		Item itemP = new Item("010","Matcha Cake",4.0,110,Region.JAPANESE);
		testListP.add(itemP);
		boolean testMenu = testShopping.ShopJapanese(testScanner, testListP, testShopperModel, testShopperController);
		assertTrue(testMenu);
	}
}
