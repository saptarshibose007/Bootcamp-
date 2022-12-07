package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.Review;

public interface IReviewService {
	
	public List<Review> listAllReviews();  //done both
	public Review addReview(Review review); //done user
	public Review updateReview(Review review); // done user
	public Review deleteReview(int id); // user
	public Review viewReview(int id); // both
	public List<Review> listAllReviewsByBook(Book book); //both
	public List<Review> listAllReviewByCustomer(Customer customer); //both
	public List<Book> listMostFavoredBooks();

}
