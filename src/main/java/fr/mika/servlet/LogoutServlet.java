package fr.mika.servlet;

import java.io.IOException;
import java.util.List;

import fr.mika.model.Formation;
import fr.mika.model.User;
import fr.mika.service.FormationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public LogoutServlet() {
       
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user!=null) session.removeAttribute("user");
		// request.getRequestDispatcher("/connexion.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/connexion.jsp");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
