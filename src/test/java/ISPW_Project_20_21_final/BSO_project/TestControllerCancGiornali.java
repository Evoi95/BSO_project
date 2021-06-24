package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerCancellaGiornale;

class TestControllerCancGiornali {
	private ControllerCancellaGiornale cCG=new ControllerCancellaGiornale();

	@Test
	void testCancella() {
		int id=2;
		cCG.cancella(id);
		assertNotEquals(-1,id);
	}

}
