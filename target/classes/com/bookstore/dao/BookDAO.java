package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	/**
	 * @param entityManager
	 */
	public BookDAO() {

	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);

	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {

		return super.findWithNameQuery("Book.findAll");
	}

	public Book findByTitle(String title) {
		List<Book> result = super.findWithNameQuery("Book.findByTitle", "title", title);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	public List<Book> listByCategory(int categoryId) {

		return super.findWithNameQuery("Book.findByCategory", "catId", categoryId);
	}

	public List<Book> listNewBooks() {
		return super.findWithNameQuery("Book.listNew", 0, 4);
	}

	public List<Book> search(String keyword) {
		return super.findWithNameQuery("Book.search", "keyword", keyword);
	}

	@Override
	public long count() {

		return super.countWithNameQuery("Book.countAll");
	}

	public long countByCategory(int categoryId) {
		
		return super.countWithNameQuery("Book.countByCategory", "catId", categoryId);
	}

}
