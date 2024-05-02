package edu.mu.maven.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminModelTest {
	
	private AdminModel a = null;
	
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
		a = new AdminModel("username","password");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetUsername() {
	    assertEquals("username", a.getUsername());
	}
	
	@Test
	void testGetPassword() {
	    assertEquals("password", a.getPassword());
	}
	
}
