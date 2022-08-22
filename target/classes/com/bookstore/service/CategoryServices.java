/**
 * 
 */
package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

/**
 * @author Virus
 *
 */
public class CategoryServices {
	private CategoryDAO categoryDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;

	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDao = new CategoryDAO(entityManager);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();

		request.setAttribute("listCategory", listCategory);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category existCategory = categoryDao.findByName(name);

		if (existCategory != null) {
			String message = "Could not create category." + " A category with name " + name + " already exists.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Category newCategory = new Category(name);
			categoryDao.create(newCategory);
			String message = "New Category created successfully.";
			listCategory(message);

		}

	}

	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.get(categoryId);
		request.setAttribute("category", category);
		String editPage = "category_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		Category categoryById = categoryDao.get(categoryId);
		Category categoryByName = categoryDao.findByName(categoryName);
		if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not update category." + " A category with name " + categoryName + " already exists";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			categoryById.setName(categoryName);
			categoryDao.update(categoryById);
			String message = "Category has been updated successfully.";
			request.setAttribute("message", message);
			listCategory(message);
		}

	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	public void deleteCategory() throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		categoryDao.delete(categoryId);
		String message = "The category " + categoryId + " has been removed successfully.";
		listCategory(message);
	}

}
