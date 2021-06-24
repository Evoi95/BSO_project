package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerReportLibri;

class TestControllerReportLibri {
	private ControllerReportLibri cRL=new ControllerReportLibri();
	

	@Test
	void testGeneraReportLibri() {
		try {
			cRL.generaReportLibri();
		} catch (IOException | SQLException e) {
		 
			
		}
	}

}
