package fitness.app;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		// ::LOGIN:: //
		
		Connexion uneConnexion = new Connexion();

		uneConnexion.testUser();
		Boolean loguser = uneConnexion.getUserLog();
		
		if ( loguser == null ) {
			
			System.out.println("L'utilisateur n'existe pas !");
			
		} else {

			uneConnexion.testPass();
			Boolean logger = uneConnexion.getLogger();
			
			if (logger == true) {
				
				System.out.println("Bienvenue ");
				System.out.println(":::::::::::::::::::::::::::::::");
				
				
			} else {
				
				System.out.println("Mauvais mot de passe !");
				
			}
			
		}
		

	}

}
