package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerPassword;

class TestControllerPassword {
	private ControllerPassword cP;
	boolean status=false;

	@Test
	void testControllerPassword() throws SQLException {
		cP=new ControllerPassword();
		
		String email="baoPublishing@gmail.com";
		String vecchiaP="BaoPub2021";
		String nuovaP="BaoPub2022";
		status=cP.aggiornaPass(email, vecchiaP, nuovaP);
		
		assertEquals(true,status);
		
		//String email,String vecchiaP,String nuovaP
		//fail("Not yet implemented");
	}

}
