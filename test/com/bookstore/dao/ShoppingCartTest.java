/**
 * 
 */
package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.controllers.frontend.shoppingcart.ShoppingCart;
import com.bookstore.entity.Book;

/**
 * @author Virus
 *
 */
public class ShoppingCartTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link com.bookstore.controllers.frontend.shoppingcart.ShoppingCart#addItem(com.bookstore.entity.Book)}.
	 */
	@Test
	public void testAddItem() {
		ShoppingCart cart = new ShoppingCart();
		Book book = new Book();
		book.setBookId(1);
		cart.addItem(book);
		Map<Book, Integer> items = cart.getItems();
		int quantity = items.get(book);
		assertEquals(1, quantity);
	}

	/**
	 * Test method for {@link com.bookstore.controllers.frontend.shoppingcart.ShoppingCart#getItems()}.
	 */
	@Test
	public void testGetItems() {
		fail("Not yet implemented");
	}

}
