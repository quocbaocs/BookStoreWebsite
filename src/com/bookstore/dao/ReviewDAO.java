/**
 * 
 */
package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import com.bookstore.entity.Review;

/**
 * @author Virus
 *
 */
public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		return super.create(review);
	}

	@Override
	public Review update(Review review) {
		
		return super.update(review);
	}

	@Override
	public Review get(Object reviewId) {
		// TODO Auto-generated method stub
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		// TODO Auto-generated method stub
		super.delete(Review.class, reviewId);
	}

	@Override
	public List<Review> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Review.listAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNameQuery("Review.countAll");
	}

}
