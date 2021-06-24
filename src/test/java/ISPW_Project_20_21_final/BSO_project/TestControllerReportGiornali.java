package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerReportGiornali;

class TestControllerReportGiornali {
	private ControllerReportGiornali cRG=new ControllerReportGiornali();

	@Test
	void testGeneraReportGiornali() {
		try {
			cRG.generaReportGiornali();
		} catch (IOException | SQLException e) {
		 
			
		}
	}

}
