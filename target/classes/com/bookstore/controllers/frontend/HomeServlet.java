package com.bookstore.controllers.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controllers.BaseServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDAO categoryDao = new CategoryDAO(entityManager);
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
