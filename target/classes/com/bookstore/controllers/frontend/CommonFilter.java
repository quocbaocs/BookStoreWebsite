package com.bookstore.controllers.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

@WebFilter("/*")
public class CommonFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private final CategoryDAO categoryDao;

	public CommonFilter() {
		this.categoryDao = new CategoryDAO();

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String viewUrl = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (!viewUrl.equals("/admin/")) {
			List<Category> listCategory = categoryDao.listAll();
			request.setAttribute("listCategory", listCategory);
		}
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
