package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest{

	
	private static CategoryDAO categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDao = new CategoryDAO();
	}

	@Test
	public void testCreateCategory() {
		Category newCate = new Category("Python");
		Category category = categoryDao.create(newCate);
		assertTrue(category != null && category.getCategoryId() != 0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Java Core");
		cat.setCategoryId(1);

		Category category = categoryDao.update(cat);

		assertEquals(cat.getName(), category.getName());

	}

	@Test
	public void testGet() {
		Integer catId = 2;
		Category cat = categoryDao.get(catId);
		assertNotNull(cat);

	}

	@Test
	public void testDeleteCategory() {
		Integer cateId = 1;
		categoryDao.delete(cateId);
		Category cate = categoryDao.get(cateId);
		assertNull(cate);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDao.listAll();
		listCategory.forEach(c -> System.out.println(c.getName() + " ,"));
		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCountCategory() {
		long totalCategories = categoryDao.count();
		assertEquals(totalCategories, 4);
	}
	@Test
	public void testFindByName() {
		String name = "Java";
		Category cate = categoryDao.findByName(name);
		assertNotNull(cate);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryDao.close();

	}

}
