package edu.mu.maven.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopperModelTest {
		
		private ShopperModel m = null;

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
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		void testGetUsername() {
			assertEquals("username", m.getUsername());
		}


		@Test
		void testGetPassword() {
			assertEquals("password", m.getPassword());
		}
		
		@Test
		void testSetUsername() {
			m.setUsername("Aaron");
			assertEquals("Aaron", m.getUsername());
		}
		
		@Test
		void testGetAccountBalance() {
			assertEquals(20,m.getAccountBalance());
		}
		
		@Test
		void testSetAccountBalance() {
			m.setAccountBalance(0);
			assertEquals(0, m.getAccountBalance());
		}
		

}
