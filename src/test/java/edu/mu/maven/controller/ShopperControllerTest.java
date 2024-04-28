package edu.mu.maven.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperView;

public class ShopperControllerTest {

	ShopperModel m = null;
	ShopperView v = null;
	ShopperController c = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Running Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}


	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running Before Each");
		m = new ShopperModel("username","password",20);
		v = new ShopperView();
		c = new ShopperController(m, v);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testSetUsername() {
		c.setShopperUsername("John");
		assertEquals(c.getShopperUsername(), "John");
	}
	
	@Test
	void testGetBalance() {
		assertEquals(20,c.getShopperBalance());
	}
	
	@Test
	void testAddToBalance() {
		c.addToShopperBalance(5);
		assertEquals(25,c.getShopperBalance());
	}
	
	@Test
	void testUpdateView() {
		assertEquals(c.updateView(), true);
	}
}
