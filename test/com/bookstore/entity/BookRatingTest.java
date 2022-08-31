/**
 * 
 */
package com.bookstore.entity;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author Virus
 *
 */
public class BookRatingTest {

	@Test
	public void test() {
		Book book = new Book();
		Set<Review> reviews = new HashSet<Review>();
		Review review1 = new Review();
		review1.setRating(5);
		reviews.add(review1);
		
		book.setReviews(reviews);
		float averageRating = book.getAverageRating();
		assertEquals(5.0, averageRating,0.0);
	}
	
	@Test
	public void testAvarageRating3() {
		Book book = new Book();
		Set<Review> reviews = new HashSet<Review>();
		Review review1 = new Review();
		review1.setRating(5);
		reviews.add(review1);
		
		Review review2 = new Review();
		review2.setRating(4);
		
		Review review3 = new Review();
		review3.setRating(3);
		
		reviews.add(review3);
		reviews.add(review2);
		
		book.setReviews(reviews);
		
		float averageRating = book.getAverageRating();
		
		
		System.out.println(averageRating);
		assertEquals(4.0, averageRating,0.0);
	}
	
	@Test
	public void testRatingString() {
		Book book = new Book();
		float averageRating = 0.0f;
		String actual = book.getRatingString(averageRating);
		String expected = "off,off,off,off,off";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testRatingString2() {
		Book book = new Book();
		float averageRating = 5.0f;
		String actual = book.getRatingString(averageRating);
		String expected = "on,on,on,on,on";
		assertEquals(actual, expected);
	}


}
