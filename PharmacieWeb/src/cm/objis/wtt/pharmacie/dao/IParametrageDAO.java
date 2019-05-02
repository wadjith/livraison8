/**
 * 
 */
package cm.objis.wtt.pharmacie.dao;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public interface IParametrageDAO {
			
	/**
	 * @param user
	 * @throws SQLException
	 */
	public void enregistreUtilisateur(Utilisateur user) throws SQLException;
	
	/**
	 * Liste des utilisateurs
	 * 
	 * @return List<Utilisateur>
	 * @throws SQLException
	 */
	public List<Utilisateur> listUtilisateurs() throws SQLException;
	
	
	/**
	 * @param user
	 * @throws SQLException
	 */
	public void modifieUtilisateur(Utilisateur user) throws SQLException;
	
	/**
	 * @param login
	 * @param password
	 * @return Utilisateur
	 * @throws SQLException
	 */
	public Utilisateur rechercheUtilisateur(String login, String password) throws SQLException;
	
	/**
	 * Vérifie que le login renseigne existe dejà, en renvoyant un nombre entier qui représente le nombre d'occurence dans la BD
	 * 
	 * @param login : Nom d'utilisateur 
	 * @return
	 * @throws SQLException
	 */
	public int verifieLogin(String login) throws SQLException;
}
