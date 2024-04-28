package edu.mu.maven.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminArraylistView;

public class AdminArraylistControllerTest {

		private AdminModel a = null;
	    private AdminArraylistModel am = null;
	    private AdminArraylistView av = null;
	    private AdminArraylistController ac = null;

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
			am = new AdminArraylistModel();
			av = new AdminArraylistView();
			ac = new AdminArraylistController(am, av);
		}

		@AfterEach
		void tearDown() throws Exception {
		}
		
		@Test
		void testAddAdmin() {
			ac.addAdminToList(a);
			assertEquals(am.getList().get(0),a);
		}
		
		@Test
		void testCheckAdminExistenceTrue() {
			ac.addAdminToList(a);
			AdminModel testModel = ac.checkAdminExistence("username","password");
			assertEquals(a,testModel);
		}
		
		@Test
		void testCheckAdminExistenceFalse() {
			ac.addAdminToList(a);
			AdminModel testModel = ac.checkAdminExistence("badUsername","password");
			assertEquals(null, testModel);
		}
		
		@Test
		void testLoadAdminsFromFile() {
			assertEquals(true,ac.loadAdminsFromFile());
		}
		
		@Test
		void testUpdateView() {
			assertEquals(true,ac.UpdateView());
		}
		
		
}
