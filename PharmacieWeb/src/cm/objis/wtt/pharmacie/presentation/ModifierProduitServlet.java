package cm.objis.wtt.pharmacie.presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * Servlet implementation class ModifierProduitServlet
 */
@WebServlet("/modifierProduit")
public class ModifierProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produit produit = new Produit();
		// Je récupère la reference du produit
		String reference = request.getParameter("ref");
		
		//Je récupère la couche service
		IService service = new ServiceImpl();
		try {
			produit = service.rechercheProduitService(reference);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("produit", produit);
		//Forward vers la page /WEB-INF/modifierProduit.jsp car protégé pour un accès authentifié
		request.getRequestDispatcher("/WEB-INF/jsp/modifierProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperation des valeurs saisies par l'utilisateur
		String reference = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
		 // creation d'un objet produit et initialisation de ses attributions
		Produit produit = new Produit();
		produit.setReference(reference);
		produit.setLibelle(libelle);
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		
		//Enregistrement de l'objet agriculteur dans la couche service
		
		//appel de la couche service
		IService service = new ServiceImpl();
		
		//appel de la methode enregistreAgriculteurService de la couche service
		try {
			service.modifierProduitService(produit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Redirection vers la Servlet ListeServlet
		request.getRequestDispatcher("listeProduit").forward(request, response);
	}

}
