/**
 * 
 */
package cm.objis.wtt.pharmacie.service;

import java.sql.SQLException;
import java.util.List;
import cm.objis.wtt.pharmacie.dao.IParametrageDAO;
import cm.objis.wtt.pharmacie.dao.ParametrageDaoImpl;
import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageServiceImpl implements IParametrageService {
	
	private IParametrageDAO dao;

	public ParametrageServiceImpl() {
		super();
		this.dao = new ParametrageDaoImpl();
	}

	

	@Override
	public boolean enregistreUtilisateur(Utilisateur user) {
		boolean result = false;
		try {
			dao.enregistreUtilisateur(user);
			result = true;
		} catch (SQLException e) {
			// TODO: Log exception message
			
		}
		return result;
	}

	
	@Override
	public boolean modifieUtilisateur(Utilisateur user) {
		boolean result = false;
		try {
			dao.modifieUtilisateur(user);
			result = true;
		} catch (SQLException e) {
			// TODO: Log exception message
			
		}
		return result;
	}

	@Override
	public Utilisateur connecteUtilisateur(String login, String password) {
		Utilisateur user = null;
		try {
			user = dao.rechercheUtilisateur(login, password);
		} catch (SQLException e) {
			// TODO Log execption message
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean utilisateurExist(String login) {
		boolean result = false;
		try {
			if(dao.verifieLogin(login) != 0) result = true;
		} catch (SQLException e) {
			// TODO Log exception message
			e.printStackTrace();
		} 
		return result;
	}

	
	@Override
	public List<Utilisateur> listUtilisateurs() {
		List<Utilisateur> users = null;
		
		try {
			users = dao.listUtilisateurs();
		} catch (SQLException e) {
			// TODO: Log Exception
			e.printStackTrace();
		}
		return users;
	}

}
