package com.bookstore.controllers.admin.book;

import com.bookstore.controllers.BaseServlet;
import com.bookstore.service.BookServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/edit_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,//10KB
		maxFileSize = 1024*300 ,//300KB
		maxRequestSize = 1024*1024
		)

public class EditBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public EditBookServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookServices bookServices = new BookServices(entityManager, request, response);
		bookServices.editBook();
	}

}
