package edu.mu.maven.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopperArraylistModelTest {
	
	private ShopperArraylistModel sm = null;

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
		sm = new ShopperArraylistModel();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    void testAddAndRemoveShopper() {
        // Create an admin model
        ShopperModel shopper = new ShopperModel("username", "password",20);

        // Add the admin to the list
        sm.addShopper(shopper);

        // Retrieve the list of admins from the model
        assertEquals(shopper, sm.getList().get(0));
        
        sm.removeShopper(shopper);
        
        assertEquals(0, sm.getList().size());
    }
}
