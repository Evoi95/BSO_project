package boundary.laptop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import controller_app.ControllerCancUser;
import controller_app.ControllerModifUserPage;
import controller_app.ControllerUserPage;
import controller_app.SingeltonSystemState;
import logger.Log;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class BoundaryUserPage implements Initializable {
	@FXML
	private Pane pane;
	@FXML
	private Label header;
	@FXML
	private Button buttonA;
	@FXML
	private Button buttonM;
	@FXML
	private Button buttonDel;
	@FXML
	private Button buttonC;
	@FXML
	private Button indietro;
	@FXML
	private Button buttonP;
	@FXML
	private TextArea elencoUtenti;
	@FXML
	private Label idL;
	@FXML
	private TextField utenteTF;
	
	private ControllerUserPage cUP;
	private ControllerCancUser cCU;
	private ControllerModifUserPage cMPU;
	
	private SingeltonSystemState vis=SingeltonSystemState.getIstance();
	protected Scene scene ;
	protected Alert alert ;
	protected int max = 0;

	@FXML
	private void aggiungi() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("addUserPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	@FXML
	private void modifica() throws IOException, SQLException
	{
		vis.getIstance().setId(Integer.parseInt(utenteTF.getText()));
		max=cMPU.prendiIdMax();
		
		Log.logger.log(Level.INFO,"Utenti massimi {0}",max);

		
		if(Integer.parseInt(utenteTF.getText())<1)// && Integer.parseInt(utenteTF.getText())>max)
		{
	
			alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("ID Utente non trovato in quanto minore di 1");
			alert.setContentText("Re immetterlo");
			alert.showAndWait();
			
			

		}
		else if (Integer.parseInt(utenteTF.getText())>max)// && Integer.parseInt(utenteTF.getText())>max)
		{
	
			alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("ID Utente non trovato in quanto maggiore del numero utenti");
			alert.setContentText("Re immetterlo");
			alert.showAndWait();
			
			

		}

		else {
			
		
		Log.logger.log(Level.INFO,"Id in BoundaryUserPage : {0}",vis.getIstance().getId());
		Stage stage;
		Parent root;
		stage = (Stage) buttonM.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("modUserPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}

	}
	@FXML
	private void cancella()
	{
		cCU.cancellaUtente(Integer.parseInt(utenteTF.getText()));
	}
	@FXML
	private void torna() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) indietro.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	@FXML
	private void prendi() {
		cUP.getUtenti();
		elencoUtenti.clear();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("ReportFinale\\riepilogoUtenti.txt"));
			String line = reader.readLine();
			while(line!=null)
			{
				elencoUtenti.appendText(line.concat("\n"));
                Log.logger.log(Level.INFO,line);
                line = reader.readLine();
			}
		}
        catch(IOException e)
        {
        	e.getCause();
        }
        finally {
        try {
			reader.close();
		} catch (IOException e) {
				e.printStackTrace();
			}
        }

		    	    
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cUP=new ControllerUserPage();
		cCU=new ControllerCancUser();
		cMPU=new ControllerModifUserPage();
	}
	
	
	
	
	
	
	
	
	
	}
