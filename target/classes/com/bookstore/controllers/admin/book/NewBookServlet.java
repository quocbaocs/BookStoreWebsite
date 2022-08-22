package com.bookstore.controllers.admin.book;

import com.bookstore.controllers.BaseServlet;
import com.bookstore.service.BookServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/new_book")
public class NewBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public NewBookServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BookServices bookServices = new BookServices(entityManager, request, response);
		bookServices.showBookNewForm();
	}

}
