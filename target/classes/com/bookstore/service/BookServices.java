/**
 * 
 */
package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

/**
 * @author Virus
 *
 */
public class BookServices {
	private BookDAO bookDao;
	private CategoryDAO categoryDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;

	public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		bookDao = new BookDAO(entityManager);
		categoryDao = new CategoryDAO(entityManager);
	}

	public void listBooks(String message) throws ServletException, IOException {

		List<Book> listBooks = bookDao.listAll();
		request.setAttribute("listBooks", listBooks);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String listPage = "book_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public void listBooks() throws ServletException, IOException {

		listBooks(null);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */

	public void showBookNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("listCategory", listCategory);
		String newPage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);

	}

	public void createBook() throws ServletException, IOException {
		String title = request.getParameter("title");
		Book existBook = bookDao.findByTitle(title);
		if (existBook != null) {
			String message = "Cound not create new book because the title " + title + "already exists.";

			listBooks(message);
			return;
		}
		readBookFields(existBook);
		Book createdBook = bookDao.create(existBook);
		if (createdBook.getBookId() > 0) {
			String message = "A new book has been created successfully.";
			listBooks(message);
		}

	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void editBook() throws ServletException, IOException {
		Integer bookId = Integer.valueOf(request.getParameter("id"));
		Book book = bookDao.get(bookId);
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("book", book);
		request.setAttribute("listCategory", listCategory);
		String editPage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @throws ServletException
	 * @throws IOException
	 * 
	 */
	public void readBookFields(Book book) throws IOException, ServletException {
		Integer categoryId = Integer.valueOf(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Error parsing publish date (format is MM/dd/yyyy");
		}

		Part part = request.getPart("bookImage");

		Category category = categoryDao.get(categoryId);
		book.setCategory(category);
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setPublishDate(publishDate);
		book.setPrice(price);

		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}
	}

	public void updateBook() throws ServletException, IOException {
		Integer bookId = Integer.valueOf(request.getParameter("bookId"));
//		Integer categoryId = Integer.valueOf(request.getParameter("category"));
		String title = request.getParameter("title");

		Book existBook = bookDao.get(bookId);
		Book bookByTitle = bookDao.findByTitle(title);

		if (existBook.equals(bookByTitle)) {
			String message = "Cound not create new book because the title " + title + "already exists.";

			listBooks(message);
			return;
		}
		existBook.setBookId(bookId);
		readBookFields(existBook);
		bookDao.update(existBook);
		String message = "The book has been updated successffully";
		listBooks(message);

	}
}
