package com.bookstore.controllers.frontend;

import java.io.IOException;
import java.util.List;

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

import com.bookstore.entity.Category;

@WebFilter("/*")
public class CustomerLoginFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] LoginRequiredURLs = { "/view_profile", "/update_profile", "/edit_profile" };

	public CustomerLoginFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		String viewUrl = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (viewUrl.equals("/admin/")) {
			chain.doFilter(request, response);
			return;
		}

		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;
		
		String requestURL = httpRequest.getRequestURL().toString();
		
		System.out.println("path: " + viewUrl);
		System.out.println("login: " + loggedIn);

		if (!loggedIn && isLoginRequired(requestURL)) {
			String loginPage = "frontend/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
			dispatcher.forward(httpRequest, response);
		} else {
			chain.doFilter(request, response);

		}

	}

	private boolean isLoginRequired(String requestURL) {
		for (String loginRequestURL : LoginRequiredURLs) {
			if (requestURL.contains(loginRequestURL)) {
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
