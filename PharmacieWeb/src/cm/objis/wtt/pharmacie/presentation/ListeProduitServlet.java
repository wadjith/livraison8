package cm.objis.wtt.pharmacie.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.objis.wtt.pharmacie.domaine.Produit;
import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;

/**
 * Servlet implementation class ListeProduitServlet
 */
@WebServlet("/listeProduit")
public class ListeProduitServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupération de la liste des produits
		IService service = new ServiceImpl();
		List<Produit> listProduit = null;
		try {
			listProduit = service.listProduitService();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Enregistrement de la liste des produits dans l'objet request pour la page listeProduit.jsp
		request.setAttribute("listProduit", listProduit);
		
		//Redirection vers la page listeProduit.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/listeProduit.jsp")
	       .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
