package edu.mu.maven.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;

public class ShopperArraylistControllerTest {
	
	private ShopperModel s = null;
    private ShopperArraylistModel sm = null;
    private ShopperArraylistView sv = null;
    private ShopperArraylistController sc = null;
    
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
		s = new ShopperModel("username","password",20);
		sm = new ShopperArraylistModel();
		sv = new ShopperArraylistView();
		sc = new ShopperArraylistController(sm, sv);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testAddAndRemoveShopper(){
		sc.addShopperToList(s);
		assertEquals(sm.getList().get(0), s);
		
		sc.removeShopperFromList(s);
		assertEquals(sm.getList().size(), 0);
	}
	
	@Test
	void testLoadShoppersFromFile() {
		assertEquals(true,sc.loadShoppersFromFile());
	}
	
	@Test
	void testRefreshSourceFile() {
		assertEquals(true,sc.refreshSourceFile());
	}
	
	@Test
	void testCheckUsernameRepeat() {
		sc.addShopperToList(s);
		assertEquals(true,sc.checkUsernameRepeat("username"));
		
		assertEquals(false,sc.checkUsernameRepeat("fakeName"));
	}
	
	@Test
	void testCheckShopperExistence() {
		sc.addShopperToList(s);
		ShopperModel testModel = sc.checkShopperExistence("username", "password");
		assertEquals(s, testModel);
		
		testModel = sc.checkShopperExistence("badUsername", "password");
		assertEquals(null,testModel);
	}
	
	@Test
	void testUpdateView() {
		assertEquals(true,sc.updateView());
	}


}
