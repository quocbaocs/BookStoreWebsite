package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	/**
	 * 
	 */
	@Test
	public void testCreateReview() {
		Review review = new Review();
		Book book = new Book();
		book.setBookId(33);
		Customer customer = new Customer();
		customer.setCustomerId(1);

		review.setCustomer(customer);
		review.setBook(book);

		review.setHeadline("This is a very good book!");
		review.setRating(5);
		review.setComment("I have just read this book. Very good.");
		Review savedReview = reviewDao.create(review);
		assertTrue(savedReview.getReviewId() > 0);
	}

	@Test
	public void testGet() {
		Integer reviewId = 3;
		Review review = reviewDao.get(reviewId);
		assertTrue(review.getReviewId() > 0);
	}

	@Test
	public void testUpdateReview() {
		Integer reviewId = 3;
		Review review = reviewDao.get(reviewId);
		review.setHeadline("Exellent Book");
		Review updatedReview = reviewDao.update(review);
		assertEquals(review.getHeadline(), updatedReview.getHeadline());

	}

	@Test
	public void testListAll() {
		List<Review> listReview = reviewDao.listAll();
		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCout() {
		long count = reviewDao.count();
		assertTrue(count == 1);
	}

	@Test
	public void testDeleteReview() {
		int reviewId = 3;
		reviewDao.delete(reviewId);
		Review review = reviewDao.get(reviewId);
		assertNull(review);
	}

}
