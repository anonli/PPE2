package fitness.app;

import java.sql.*;
import java.util.Scanner;

public class Connexion {
	
	
	// VARIABLES BDD //
	
	private String dbhost = "";
	private String dbuser = "";
	private String dbpass = "";
	
	// VARIABLES CONNEXION BDD //
	
	private Connection laConnexion;
	private Statement transmission;
	private ResultSet leResultat;
	
	// VARIABLES LOGIN //
	
	private String user;
	private String mdpuser;
	private String mdptest;
	private Boolean userLog;
	private Boolean logger;
	
	// VARIABLE SESSION //
	
	// FONCTION _CONSTRUCT //

	public Connexion () {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			laConnexion = DriverManager.getConnection(this.dbhost, this.dbuser, this.dbpass);
			transmission = laConnexion.createStatement();
			
		}
		catch (Exception e) {
			
			System.out.println("Erreur de connexion à la BDD");
			
		}
	}
	
	// MODELES //
	
	public void testUser () throws SQLException {
		
			Scanner sc = new Scanner (System.in);
		
			System.out.println("User :");
			this.user = sc.nextLine();
			
		    leResultat = transmission.executeQuery("SELECT `mdp` FROM `Users` WHERE `username` ='"+this.user+"'");
			
		    try{
		    	  leResultat.next();
		    	  this.userLog = leResultat.getBoolean(1);
		    	}
		    	catch ( Exception e ) {
		    	  leResultat.close();
		    	}
				
	}
	
	public void testPass () throws SQLException {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("");
		System.out.println("Mot de passe.");
		System.out.println(this.user+ ":");
		this.mdptest = sc.nextLine();
	
		
		leResultat = transmission.executeQuery("SELECT `mdp` FROM `Users` WHERE `username` ='"+this.user+"'");
		  
		  while (leResultat.next())
	  	  {
	  		  this.mdpuser = leResultat.getString("mdp");
	  	  }
		  
		  if (this.mdpuser.equals(this.mdptest)) {
				
				this.logger = true;
				
			} else {
				
				this.logger = false;
				
			}
		
	}
	
	public void session_start(){
		
	}
	
	// GETTERS && SETTERS //
	
	public Boolean getLogger() {
		return logger;
	}

	public Boolean getUserLog() {
		return userLog;
	}

	public String getUser() {
		return user;
	}

}
