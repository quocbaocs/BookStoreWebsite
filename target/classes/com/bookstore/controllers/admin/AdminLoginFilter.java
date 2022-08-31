package com.bookstore.controllers.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminLoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean loggedIn = session != null && session.getAttribute("userEmail") != null;
		String loginURI = httpRequest.getContextPath()+"/admin/login";
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if(loggedIn && (loginRequest|| loginPage)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(httpRequest, response);
		}
		if (loggedIn || loginRequest) {
			// pass the request along the filter chain
			System.out.println("User logged in");
			chain.doFilter(request, response);
		
		} else {
			System.out.println("User not logged in");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(httpRequest, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
