package edu.mu.maven.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminArraylistModelTest {

    private AdminArraylistModel am = null;

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
		am = new AdminArraylistModel();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    void testAddAdmin() {
        // Create an admin model
        AdminModel admin = new AdminModel("username", "password");

        // Add the admin to the list
        am.addAdmin(admin);

        // Retrieve the list of admins from the model
        assertEquals(admin, am.getList().get(0));
    }
}
