/**
 * 
 */
package com.bookstore.controllers.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.bookstore.entity.Book;

/**
 * @author Virus
 *
 */
public class ShoppingCart {
	private Map<Book, Integer> cart = new HashMap<Book, Integer>();

	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		} else {
			cart.put(book, 1);
		}
	}

	public Map<Book, Integer> getItems() {
		return this.cart;
	}
}
