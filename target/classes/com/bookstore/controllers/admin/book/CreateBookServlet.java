package com.bookstore.controllers.admin.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controllers.BaseServlet;
import com.bookstore.service.BookServices;


@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,//10KB
		maxFileSize = 1024*300 ,//300KB
		maxRequestSize = 1024*1024
		)

public class CreateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    
    public CreateBookServlet() {
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices = new BookServices(entityManager, request, response);
		bookServices.createBook();
	}

}
