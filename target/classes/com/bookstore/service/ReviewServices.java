/**
 * 
 */
package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Review;

/**
 * @author Virus
 *
 */
public class ReviewServices {
	private ReviewDAO reviewDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

		reviewDao = new ReviewDAO();
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> listReviews = reviewDao.listAll();
		for (Review r : listReviews) {
			System.out.println("hahahahahahah" + r.getHeadline());
		}
		request.setAttribute("listReviews", listReviews);

		if(message !=null) {
			request.setAttribute("message", message);
		}
		String listPage = "review_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	public void listAllReview() throws ServletException, IOException {
		listAllReview(null);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.valueOf(request.getParameter("id"));
		Review review = reviewDao.get(reviewId);
		request.setAttribute("review", review);
		String editPage = "review_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);

	}

	
	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.valueOf(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		Review review = reviewDao.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		reviewDao.update(review);
		String message = "The review has been updated successfully";
		listAllReview(message);
		
	}

	
	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.valueOf(request.getParameter("id"));
		reviewDao.delete(reviewId);
		String message = "The review has been deleted successfully";
		listAllReview(message);
	}

}
