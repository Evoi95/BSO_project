package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerHomePageAfterLoginSE;
import users.singelton.User;

class TestControllerAfterLoginSE {

	@Test
	void testLogout() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		boolean state;
		User.getInstance().setNome("pippo");
		
		state=ControllerHomePageAfterLoginSE.logout();
		assertNotEquals(false,state);
}

}
