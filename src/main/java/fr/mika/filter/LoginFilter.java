package fr.mika.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.mika.model.User;
import fr.mika.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/accueil.jsp" })
public class LoginFilter implements Filter{

	public LoginFilter() {
	}
	
	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Login filter init !");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		System.out.println("Je suis là Login Filter");
		
		// Already connected
		if (user!=null) {
			System.out.println("Login Filter session en cours");
			chain.doFilter(req, res);
			return;
		}
		System.out.println("Login Filter pas de session");
		
		
		// Checking connexion
		String username =  req.getParameter("username");
		String pwd =  req.getParameter("pwd");

		System.out.println(username);
		System.out.println(pwd);
		
		List<User> users = UserService.getInstance().getUsers();
		user = users.stream()
				.filter(u -> u.getUsername().equals(username) && u.getPwd().equals(pwd))
				.findFirst().orElse(null);
		
		// Bad username or password
		if (user==null) {
			HttpServletResponse response = (HttpServletResponse) res;
			session.setAttribute("invalide", "oui");
			response.sendRedirect(request.getContextPath()+"/connexion.jsp");
			return;
		}
		
		// Setting up session
		session.setAttribute("user", user);
		
		chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("Login filter destroy!");
	}

}
