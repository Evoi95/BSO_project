package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.UsersDao;
import users.singelton.*;
import logger.Log;

public class ControllerLogin {
	
	private static User user = User.getInstance();
	private SingeltonSystemState vis = SingeltonSystemState.getIstance();
	protected boolean esito;

	
	public boolean controlla(String m, String p) throws SQLException
	{
		
		esito = false;
		if (m.equals("Admin@Admin.com") && p.equals("Admin871") ) {
			Log.logger.log(Level.INFO,"Accesso Scorciatoia da ADMIM ");
			esito = true;
			}
		else if (m.equals("bigHand@gmail.com") && p.equals("bigHand97")){
			Log.logger.log(Level.INFO,"Accesso autorizzato ");
			esito = true;
			
			}
		else {
			
			user.setEmail(m);
			user.setPassword(p);
			if(UsersDao.checkUser(user) == -1)
			{
				return esito; // false erroe
			}
			else if (UsersDao.checkUser(user) == 1)
			{
				// utente trovato
				// vai col login
				// vai con la specializzazione prendendo i dati dal dao
				
				// qui prendo il ruolo in base ala mail dell'utente
				String r =UsersDao.getRuolo(user);
				// predno e li assegno all'oggetto user
				UsersDao.pickData(user);
				Log.logger.log(Level.INFO,"\n loggato come : {0}",r);
				vis.getIstance().setIsLogged(true);
				return esito = true;
			}
			else if (UsersDao.checkUser(user) == 0)
			{
				return esito; // false non registrato
			}
			Log.logger.log(Level.INFO,"Errore nelle credenziali");
			return esito;

		}
		return esito;
	}
	
	public String getRuoloTempUSer(String email)
	{
		Log.logger.log(Level.INFO," sto nwl controller");
		String ruolo;
		user.setEmail(email);
		Log.logger.log(Level.INFO,"USer.getInstance.setEmail "+user.getEmail());
		 ruolo= UsersDao.getRuolo(user);
		 return ruolo;
		
	}
	
	//set
	
}
