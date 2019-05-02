package cm.objis.wtt.pharmacie.util;

import java.util.ResourceBundle;

/**
 * Classe qui contient les param�tres de connexion � la Base de donn�es.
 * Les parametres sont lus dans un fichier de configration
 * 
 * @author thierry WADJI
 *
 */
public class DBParameter {
	
	/**
	 * Le fichier de configuration (config.properties) est dans le package: cm.objis.wtt.pharmacie.domaine.properties. 
	 * Il doit etre renseigne comme suit:
	 * dbhost=adresse IP ou nom du serveur de base de donn�e
	 * dbname=nom de la base de donn�e (BD)
	 * username=nom d'utilisateur de la BD
	 * password=mot de passe   
	 */
	private static final String CONFIG_FILE = "cm.objis.wtt.pharmacie.domaine.properties.config";
	
	private static ResourceBundle bundle;
	private static String dbhost;
	private static String dbname;
	private static String username;
	private static String password;
	
	static { // initialisation static
		bundle = ResourceBundle.getBundle(CONFIG_FILE);
		dbhost = bundle.getString("sgbd.host");
		dbname = bundle.getString("sgbd.db");
		username = bundle.getString("sgbd.login");
		password = bundle.getString("sgbd.password");
		
	}

	
	/**
	 * @return l'adresse IP ou nom du serveur de bases de donn�es
	 */
	public static String getDbhost() {
		return dbhost;
	}

	/**
	 * @return le nom de la base de donn�es
	 */
	public static String getDbname() {
		return dbname;
	}

	/**
	 * @return le nom d'utilisateur de la base de donn�es
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @return le mot de passe de la base de donn�es
	 */
	public static String getPassword() {
		return password;
	}
	
	
	
	

}
