package ISPW_Project_20_21_final.BSO_project;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import database.PopulateDefaultDb;

class TestPopulatedefaultDb {
	//private static PopulateDefaultDb pDDB= new PopulateDefaultDb();

	@Test
	void testPopulateDefaultDb() throws FileNotFoundException {
		assertNotEquals(false,PopulateDefaultDb.populateDefaultDb());
	}

}
