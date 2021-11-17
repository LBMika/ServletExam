package fr.mika.servlet;

import java.io.IOException;
import java.util.List;

import fr.mika.model.Formation;
import fr.mika.model.User;
import fr.mika.service.FormationService;
import fr.mika.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/eleve")
public class EleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users;

    public EleveServlet() {
       users = UserService.getInstance().getUsers();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	User user = users.stream()
    				.filter(u -> u.getNom().equals(nom) && u.getPrenom().equals(prenom))
    				.findFirst().orElse(null);
    	if (user==null) {
    		response.sendRedirect("/eleves");
    		return;
    	}
    	
    	System.out.println("!!!!! "+user);
    	request.setAttribute("eleve", user);
		request.getRequestDispatcher("eleve.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
