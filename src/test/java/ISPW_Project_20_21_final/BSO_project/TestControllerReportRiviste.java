package ISPW_Project_20_21_final.BSO_project;


import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerReportRiviste;

class TestControllerReportRiviste {
	private ControllerReportRiviste cRR= new ControllerReportRiviste();

	@Test
	void testGeneraReportRiviste() {
		try {
			cRR.generaReportRiviste();
		} catch (IOException | SQLException e) {
		 
			}
		}

}
