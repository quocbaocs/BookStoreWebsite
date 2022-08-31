/**
 * 
 */
package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Customer;

/**
 * @author Virus
 *
 */
public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer get(Object customerId) {

		return super.find(Customer.class, customerId);
	}

	@Override
	public void delete(Object customerId) {

		super.delete(Customer.class, customerId);

	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Customer.findAll");
	}

	@Override
	public long count() {
		long countCustomer = super.countWithNameQuery("Customer.count");
		return countCustomer;
	}

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}

	@Override
	public Customer update(Customer customer) {

		return super.update(customer);
	}

	public Customer findByEmail(String email) {
		List<Customer> result = super.findWithNameQuery("Customer.findByEmail", "email", email);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	/**
	 * 
	 */
	public Customer checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Customer> check = super.findWithNameQuery("Customer.checkLogin", parameters);
		if(!check.isEmpty()) {
			return check.get(0);
		}
		return null;
	}

}
