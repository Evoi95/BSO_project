package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerCancUser;
import users.singelton.TempUser;

class TestControllerCancUser {
	private static TempUser u=TempUser.getInstance();

	private ControllerCancUser cCU=new ControllerCancUser();

	@Test
	void testCancellaUtente() {
		u.setIdU(1);
		cCU.cancellaUtente(u.getIdU());
	}

}
