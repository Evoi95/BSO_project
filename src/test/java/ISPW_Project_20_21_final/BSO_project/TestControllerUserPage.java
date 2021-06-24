package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerUserPage;

class TestControllerUserPage {
	private ControllerUserPage cUP=new ControllerUserPage();

	@Test
	void testGetUtenti() {
		cUP.getUtenti();
		}

	
}
