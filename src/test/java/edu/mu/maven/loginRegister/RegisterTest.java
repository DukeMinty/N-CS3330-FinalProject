package edu.mu.maven.loginRegister;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;

public class RegisterTest {
	
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
	void testShopperLogin() {
		Scanner scanner = new Scanner(System.in);
		sc.loadShoppersFromFile();
		s = ShopperLogin.login(scanner,sc);
		assertNotNull(s);
	}
	
	@Test
	void testRegister() {
		Scanner scanner = new Scanner(System.in);
		new Register(scanner,sc);
		assertEquals(sm.getList().size(),1);
	}
	


}
