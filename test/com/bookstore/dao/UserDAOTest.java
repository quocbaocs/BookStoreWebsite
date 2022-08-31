package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {


	private static UserDAO userDao;

	@BeforeClass
	public static void setupClass() {
		userDao = new UserDAO();
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("camthuy@gmail.com");
		user1.setFullName("Cam Thuy");
		user1.setPassword("123456444");

		user1 = userDao.create(user1);

		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDao.create(user1);

	}

	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("nam@gmail.com");
		user.setFullName("Bao Bao");
		user.setPassword("mysecret");
		user = userDao.update(user);
		String expected = "mysecret";
		String actual = user.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteUsers() {
		Integer userId = 6;
		userDao.delete(userId);
		Users user = userDao.get(userId);
		assertNull(user);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 66;
		userDao.delete(userId);

	}

	@Test
	public void testGetUsersFound() {
		Integer userId = 6;

		Users user = userDao.get(userId);
		assertNotNull(user);
	}

	@Test
	public void testListAll() {
		List<Users> listUsers = userDao.listAll();
		assertTrue(listUsers.size() > 0);
	}

	@Test
	public void testFindByEmail() {
		String email = "sangpham@gmail.com";
		Users user = userDao.findByEmail(email);
		assertNotNull(user);
	}

	@Test
	public void testCheckLoginSuccess() {
		String email = "sangpham@gmail.com";
		String password = "3213132";
		boolean actual = userDao.checkLogin(email, password);
		assertTrue(actual);

	}

	@Test
	public void testCheckLoginFailed() {
		String email = "sangpham@gmai";
		String password = "321313";
		boolean actual = userDao.checkLogin(email, password);
		assertFalse(actual);

	}

	
	@AfterClass
	public static void tearDownClass() {
		userDao.close();

	}

}
