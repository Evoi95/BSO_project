package controller_app;

import java.time.LocalDate;
import java.util.logging.Level;

import database.UsersDao;
import users.singelton.User;
import logger.Log;

public class ControllerModificaUtente {
	private UsersDao uD;
	private boolean state = false;

	
	
	public ControllerModificaUtente()
	{
		uD=new UsersDao();
	}



	public User prendi() {
		
		return uD.pickData(User.getInstance());
		
		
	}

	public boolean aggiorna(String n, String c, String email, String pass, String desc, LocalDate localDate, String vecchiaMail) {
		
		
		try {
		if( !n.equals("") && !n.equals(null) && !n.equals(User.getInstance().getNome()))
		{
			
			User.getInstance().setNome(n);
			uD.aggiornaNome(User.getInstance());
			state =  true; 

		}
		if (!c.equals("") && !c.equals(null) && !c.equals(User.getInstance().getCognome()))
		{
			User.getInstance().setCognome(c);
			uD.aggiornaCognome(User.getInstance());
			state =  true; 

		}
		if(!email.equals("") && !email.equals(null) && !email.equals(vecchiaMail))
		{
			
			uD.aggiornaEmail(User.getInstance(),email);
			state =  true; 

	
		}
		if(!pass.equals("") && !pass.equals(null) && !pass.equals(User.getInstance().getPassword()))
		{
			User.getInstance().setPassword(pass);
			uD.aggiornaPass(User.getInstance());
			state =  true; 

		}
		if(!desc.equals("") && !desc.equals(null) && !desc.equals(User.getInstance().getDescrizione()))
		{
			User.getInstance().setDescrizione(desc);
			uD.aggiornaDesc(User.getInstance());
			state =  true; 
		}

		if(!localDate.equals("") && !localDate.equals(null) && !localDate.equals(User.getInstance().getDataDiNascita()))
		{
			User.getInstance().setDataDiNascita(localDate);
			state = true;
			
		}
		//qui controllo se i campi sono vuoti 
		else { 
			return state;
		}
			
		
		}
		catch(NullPointerException e)
		{
			Log.logger.log(Level.INFO,"Ho torvato LocalDate come : "+localDate);
			
		}
		return state;
			
	}
}
