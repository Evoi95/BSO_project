package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import logger.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import pagamento.CartaCredito;

public class CartaCreditoDao {
	private PreparedStatement stmt=null;
	private String query;
	private Connection conn;
	private ResultSet rs;
	
	
	public ObservableList<CartaCredito> getCarteCredito(String nome) 
	{
		Connection conn= ConnToDb.generalConnection();
		/*
		 * uare funzione internet
		 */
		ObservableList<CartaCredito> catalogo=FXCollections.observableArrayList();
		 
			//ConnToDb.connection();
            try {
				rs=conn.createStatement().executeQuery("select nomeP,cognomeP,codiceCarta from cartacredito where nomeP='"+nome+"'");
			
            while(rs.next())
            {
            	String n=rs.getString(1);
            	String cog=rs.getString(2);
            	String cod=rs.getString(3);
            	
            	

        		try {             

					catalogo.add(new CartaCredito(n,cog,cod, null, cod,0));
        		} catch (Exception e) {
				 
					
				}
        		
            }
            } catch (SQLException e1) {
			 
				e1.printStackTrace();
			}
            finally {
                try {
					conn.close();
				} catch (SQLException e) {
				 
					
				}

            }
		   return catalogo;

		
	}	
	
	public void daiPrivilegi() throws SQLException
	{
		//PreparedStatement stmt=null;
	//	Double d=(double) disp;

		 try {
			  conn = ConnToDb.generalConnection();
			  stmt = conn.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }	
		 finally {
			// stmt.close();
			 conn.close();
			// Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"LibroDao. privilegi");

	}
	public void insCC(CartaCredito cc) throws SQLException
	{
		
		//PreparedStatement stmt=null;
		//Connection conn = null;
		
		
		Log.logger.log(Level.INFO,"\t\tEntro in ins cc");
		String n=cc.getUserNome();
		 String c=cc.getUserCognome();
		 String num=cc.getNumeroCC();
		 Date d=cc.getScadenza();
		 String pin=cc.getCiv();
		 Float amm=(float) cc.getPrezzoTransazine();		 
		// Log.logger.log(Level.INFO,"Entro in ins cc"+cc.getUserNome());
		 try {
			 conn=ConnToDb.generalConnection();
			 query="insert into cartacredito (nomeP,cognomeP,codiceCarta,scad,codicePin,ammontare)  values(?,?,?,?,?,?)";
			 stmt=conn.prepareStatement(query);
			

				stmt.setString(1,n);
				stmt.setString(2, c);
				stmt.setString(3, num);
				stmt.setDate(4,d);
				stmt.setString(5,pin);
				stmt.setFloat(6, amm);
			    stmt.executeUpdate();
			    
			   
			   /* Alert alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("  Riepilogo inserimento carta ");
    	        alert.setHeaderText("Risultato ");
    	        alert.setContentText(" Inserimento avvenuto con successo!!\n\n Digitare nome utente in apposito spazio sottostante ");
    	        alert.showAndWait();
*/
    	       
	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }
		 finally {conn.close();}
		
		
		 Log.logger.log(Level.INFO,"LibroDao. questy");

		}
	
	public float prendiSpesa() 
	{
		float spesa=0;
		try {
			conn=ConnToDb.generalConnection();
	          rs=conn.createStatement().executeQuery("select spesaTotale from pagamento  where 1+last_insert_id(id_op) order by id_op desc limit 1");
	          while (rs.next())
	          {
	        	  spesa=rs.getFloat("spesaTotale");
	          }
	          
	          conn.close();
		}catch(SQLException e)
		{
			e.getCause();
		}
		
		Log.logger.log(Level.INFO,"\n\n Spesa in Cdao :"+spesa);
		return spesa;
	}
	  
	
	public CartaCredito  popolaDati(CartaCredito cc) throws SQLException
	{
		String codice=cc.getNumeroCC();
		String n = null,cog = null,cod = null;
		Date scad = null;
		conn= ConnToDb.generalConnection();
		    rs=conn.createStatement().executeQuery("select nomeP,cognomeP,codiceCarta,scad from cartacredito where codiceCarta='"+codice+"'");

            while(rs.next())
            {
            	n=rs.getString(1);
            	 cog=rs.getString(2);
            	 cod=rs.getString(3);
            	 scad=rs.getDate(4);
            	
            	

            }
            
            cc.setNomeUser(n);
            cc.setCognomeUser(cog);
            cc.setNumeroCC(cod);
            cc.setScadenza(scad);
            conn.close();
			return cc;

	
	}
}

           
		 //  return catalogo;

		
	


		
	


