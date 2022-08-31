/**
 * 
 */
package com.bookstore.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

/**
 * @author Virus
 *
 */
public class CustomerDAOTest {
	private static CustomerDAO customerDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		customerDao = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		assertNotNull(customer);
	}

	@Test
	public void testDeleteObject() {
		Integer customerId = 1;
		customerDao.delete(customerId);
		assertNotNull(customerDao.get(1));
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDao.get(1);
		String fullName = "Nguyen Thi Thanh Thao";
		customer.setFullname("Nguyen Thi Thanh Thao");
		customerDao.update(customer);
		assertTrue(customer.getFullname().equals(fullName));

	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("thanhthao@gmail.com");
		customer.setFullname("Thanh Thao");
		customer.setCity("Ho Chi Minh");
		customer.setCountry("Viet Nam");
		customer.setAddress("117/15 Ho van long, phuong tan tao, Binh Tan");
		customer.setPassword("12345");
		customer.setPhone("03545648798");
		customer.setZipcode("700000");
		Customer newCustomer = customerDao.create(customer);
		assertTrue(newCustomer.getCustomerId() > 0);

	}

	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDao.listAll();
		for (Customer c : listCustomers) {
			System.out.println(c.getFullname());
		}

		assertTrue(listCustomers.size() > 0);
	}

	@Test
	public void testCountCustomer() {
		long total = customerDao.count();
		assertTrue(total == 1);
	}

	@Test
	public void testFindByEmail() {
		String email = "thanhthao@gmail.com";
		Customer customer = customerDao.findByEmail(email);
		assertNotNull(customer);
	}

	@Test
	public void textCheckLoginSuccess() {
		String email = "sangpham@gmail.com";
		String password = "12345";
		Customer customer = customerDao.checkLogin(email, password);
		assertNotNull(customer);
	}

}
