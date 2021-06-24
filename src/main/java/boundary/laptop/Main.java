package boundary.laptop;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import database.CreateDefaultDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene;

		try {
			Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			scene = new Scene(root);
			primaryStage.setTitle("Benvenuto nella homePage");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			
		}

	}

	public static void main(String[] args) {

		try {
			CreateDefaultDB.createDefaultDB();
		} catch (ClassNotFoundException  eClass) {
			eClass.printStackTrace();
			
		} catch (FileNotFoundException eFile) {
			eFile.printStackTrace();
			
		} catch (SQLException eSQL) {
			eSQL.printStackTrace();			
		}

		launch(args);

	}
}
