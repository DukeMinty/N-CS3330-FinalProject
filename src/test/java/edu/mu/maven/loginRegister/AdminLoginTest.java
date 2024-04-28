package edu.mu.maven.loginRegister;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import edu.mu.maven.controller.AdminArraylistController;
import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminArraylistView;

public class AdminLoginTest {

	AdminArraylistModel model = null;
	AdminArraylistView view = null;
	AdminArraylistController cont = null;
	AdminModel am = null;
	
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
		model = new AdminArraylistModel();
		view = new AdminArraylistView();
		cont = new AdminArraylistController(model, view);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testLogin() {
		Scanner scanner = new Scanner(System.in);
		boolean testBool = false;
		cont.loadAdminsFromFile();
		am = AdminLogin.login(scanner, cont);
		for(AdminModel admins : model.getList()) {
			if(am.equals(admins)) {
				testBool = true;
				break;
			}
		}
		assertEquals(true,testBool);
	}

}
