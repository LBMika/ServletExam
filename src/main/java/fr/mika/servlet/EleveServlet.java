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
@WebServlet("/eleves")
public class EleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users;

    public EleveServlet() {
       users = UserService.getInstance().getUsers();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setAttribute("users", this.users);
		request.getRequestDispatcher("eleves.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
