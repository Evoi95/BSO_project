package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerVisualizzaRivista;

class TestControllerVisualizzaRiviste {
	private ControllerVisualizzaRivista cVR=new ControllerVisualizzaRivista();

	@Test
	void testSetID() {
		String id="1";
		cVR.setID(id);
	
	}

	@Test
	void testGetID() {
		int x=cVR.getID();
		assertNotEquals(-1,x);
		}

	@Test
	void testGetData() throws SQLException {
		int i=1;
		cVR.getData(i);
		assertNotEquals(-1,i);
	
	}

}
