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

@WebFilter(urlPatterns = { "/eleves" })
public class EleveFilter implements Filter{

	public EleveFilter() {
	}
	
	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Formation filter init !");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user==null) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/connexion.jsp");
			return;
		}
		
		chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("Formation filter destroy!");
	}

}
