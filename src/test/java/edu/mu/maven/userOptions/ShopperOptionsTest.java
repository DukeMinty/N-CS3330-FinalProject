package edu.mu.maven.userOptions;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;
import edu.mu.maven.view.ShopperView;

public class ShopperOptionsTest {
	
	ShopperModel m = null;
	ShopperView v = null;
	ShopperController c = null;
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
		m = new ShopperModel("username","password",20);
		v = new ShopperView();
		c = new ShopperController(m, v);
		sm = new ShopperArraylistModel();
		sv = new ShopperArraylistView();
		sc = new ShopperArraylistController(sm, sv);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testShopperOptions() {
		Scanner scanner = new Scanner(System.in);
		new ShopperOptions(scanner,c,sc);
	}

}
