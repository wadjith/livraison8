/**
 * 
 */
package cm.objis.wtt.pharmacie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageDaoImpl implements IParametrageDAO {

	@Override
	public void enregistreUtilisateur(Utilisateur user) throws SQLException {
		
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Création d'un objet  statement et preparation de la requete
		String sql = "INSERT INTO `utilisateur`(`nom`,`prenom`,`telephone`,`login`,`password`)" 
				+"VALUES (?,?,?,?,?)";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getTelephone());
		ps.setString(5, user.getLogin());
		ps.setString(6, user.getPassword());
		
		// Etape 3 : exécution de la requête
		ps.executeUpdate();
		
	}

	
	@Override
	public void modifieUtilisateur(Utilisateur user) throws SQLException {
		// TODO by WADJI
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Création d'un objet  statement et preparation de la requete
		String sql = "UPDATE Utilisateur SET prenom = ?, telephone = ? WHERE id = ?";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, user.getPrenom());
		ps.setString(2, user.getTelephone());
		
		// Etape 3 : exécution de la requête
		ps.executeUpdate();
		
	}

	@Override
	public Utilisateur rechercheUtilisateur(String login, String password) throws SQLException {
		//création d'un objet utilisateur null
		Utilisateur user = null;
	
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation de la requête
		String sql = "SELECT * FROM utilisateur WHERE utilisateur.login = ? AND utilisateur.password = ?";
		
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, login);
		pst.setString(2, password);

		// Etape 3 : exécution de la requête
		ResultSet rs = pst.executeQuery();

		// Etape 4 :parcours Resultset (optionnel)
		if (rs.next()) {
			
			//recuperation des valeurs du résultat, pour initialiser l'objet Utilisateur
			user = new Utilisateur();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setTelephone(rs.getString("telephone"));
			user.setLogin(rs.getString("login"));
			
		}
		
		return user;
	}

	@Override
	public int verifieLogin(String login) throws SQLException {
		
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation requête
		String sql = "SELECT COUNT(*) as nbuser FROM utilisateur WHERE login = ?";

		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setString(1, login);
		ResultSet rs=ps.executeQuery();

		rs.next();

		return rs.getInt("nbuser");
	}
	
	/**
	 * @return
	 */
	private static java.sql.Date getCurrentDate() {
		
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	
	@Override
	public List<Utilisateur> listUtilisateurs() throws SQLException {
		//création d'une collection des utilisateurs
				List<Utilisateur> userList = new ArrayList<Utilisateur>();
			
				// Etape 1 : récupération de la connexion
				Connection cn = ConnectionMYSQL.getInstance();

				// Etape 2 : préparation de la requête
				String sql = "SELECT * FROM utilisateur";
				
				Statement st = cn.createStatement();

				// Etape 3 : exécution de la requête
				ResultSet rs = st.executeQuery(sql);

				// Etape 4 :parcours Resultset (optionnel)
				while (rs.next()) {
					
					//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Agence
					Utilisateur user =  new Utilisateur();
					
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setTelephone(rs.getString("telephone"));
					user.setLogin(rs.getString("login"));
					
					//ajout d'une agence dans List
					userList.add(user); 
					
				}
				
				return userList;
	}


}
