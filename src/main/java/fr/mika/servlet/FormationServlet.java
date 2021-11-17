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
@WebServlet("/formation")
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Formation> formations;

    public FormationServlet() {
       formations = FormationService.getInstance().getFormations();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String sujet = request.getParameter("sujet");
    	Formation formation = FormationService.getInstance().getFormationBySubject(sujet);
    	if (formation==null) {
    		response.sendRedirect("/formations");
    		return;
    	}
    	
    	request.setAttribute("formation", formation);
		request.getRequestDispatcher("formation.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
