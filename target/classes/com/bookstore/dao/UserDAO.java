package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
		
	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		// TODO Auto-generated method stub
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Users.class, id);
	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Users.findAll");
	}

	public Users findByEmail(String email) {
		List<Users> listUser = super.findWithNameQuery("Users.findByEmail", "email", email);
		if (listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		return null;
	}

	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Users> listUsers = super.findWithNameQuery("Users.checkLogin", parameters);
		if (listUsers.size() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNameQuery("Users.countAll");
	}

}
