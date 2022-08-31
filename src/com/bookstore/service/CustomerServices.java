/**
 * 
 */
package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Customer;

/**
 * @author Virus
 *
 */
public class CustomerServices {
	private CustomerDAO customerDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		customerDao = new CustomerDAO();
	}

	public void listCustomer(String message) throws ServletException, IOException {
		List<Customer> listCustomers = customerDao.listAll();
		request.setAttribute("listCustomers", listCustomers);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String customerPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(customerPage);
		requestDispatcher.forward(request, response);
	}

	public void listCustomer() throws ServletException, IOException {
		listCustomer(null);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");

		Customer existCustomer = customerDao.findByEmail(email);
		if (existCustomer != null) {
			String message = "Cound not create customer: the email " + email
					+ " is aldready registered by another customer.";
			listCustomer(message);

		} else {
			Customer newCustomer = new Customer();
			updateCustomerFieldFromForm(newCustomer);
			customerDao.create(newCustomer);
			String message = "New customer has been created successfully.";
			listCustomer(message);
		}

	}

	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.valueOf(request.getParameter("id"));
		Customer customer = customerDao.get(customerId);

		request.setAttribute("customer", customer);
		String customerPage = "customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(customerPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId = Integer.valueOf(request.getParameter("customerId"));
		String email = request.getParameter("email");
		Customer customerByEmail = customerDao.findByEmail(email);
		String message = null;

		if (customerByEmail != null && customerByEmail.getCustomerId() == customerId) {
			message = "Could not update the customer ID " + customerId
					+ " because there's an existing customer having the same mail.";
		} else {

			Customer customerById = customerDao.get(customerId);
			updateCustomerFieldFromForm(customerById);

			customerDao.update(customerById);
			message = "Customer has been updated successfully.";

		}
		listCustomer(message);

	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.valueOf(request.getParameter("id"));
		customerDao.delete(customerId);
		String message = "The customer has been deleted successfully.";
		listCustomer(message);

	}

	private void updateCustomerFieldFromForm(Customer newCustomer) {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipCode = request.getParameter("zipCode");
		String country = request.getParameter("country");
		if (email != null && !email.equals("")) {
			newCustomer.setEmail(email);
		}
		newCustomer.setFullname(fullname);
		if (password != null && !password.equals("")) {
			newCustomer.setPassword(password);
		}
		newCustomer.setPhone(phone);
		newCustomer.setAddress(address);
		newCustomer.setCity(city);
		newCustomer.setZipcode(zipCode);
		newCustomer.setCountry(country);
	}

	public void regiterCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDao.findByEmail(email);
		String message;
		if (existCustomer != null) {
			message = "Cound not register. The email " + email + " is aldready registered by another customer.";

		} else {

			Customer newCustomer = new Customer();
			updateCustomerFieldFromForm(newCustomer);
			customerDao.create(newCustomer);
			message = "You have registered successfully! Thank you<br/>"
					+ "<a href='login.jsp'>Click here</a> to login";
		}
		String messagePage = "frontend/message.jsp";
		request.setAttribute("message", message);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		requestDispatcher.forward(request, response);
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage = "frontend/login.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(loginPage);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = customerDao.checkLogin(email, password);
		if (customer == null) {
			String message = "Login faild ! Please check your mail and password";
			request.setAttribute("message", message);
			showLogin();
		} else {
			request.getSession().setAttribute("loggedCustomer", customer);
			showCustomerProfile();
		}

	}

	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(profilePage);
		requestDispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editProfilePage = "frontend/edit_profile.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editProfilePage);
		requestDispatcher.forward(request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldFromForm(customer);
		customerDao.update(customer);
		showCustomerProfile();
	}

}
