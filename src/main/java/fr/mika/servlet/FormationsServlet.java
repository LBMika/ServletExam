package fr.mika.servlet;

import java.io.IOException;
import java.util.List;

import fr.mika.model.Formation;
import fr.mika.service.FormationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/formations")
public class FormationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Formation> formations;

    public FormationsServlet() {
       formations = FormationService.getInstance().getFormations();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setAttribute("formations", this.formations);
		request.getRequestDispatcher("formations.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
