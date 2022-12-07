package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.Review;
import com.bootcamp.bookstoremanagement.Repository.IReviewRepository;
import com.bootcamp.bookstoremanagement.exception.ReviewNotFoundException;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	private IReviewRepository reviewRepository;
	
	@Override
	public List<Review> listAllReviews() {
		return reviewRepository.findAll();
	}
	@Override
	public Review addReview(Review review) {	
		return reviewRepository.save(review);
	}
	@Override
	public Review updateReview(Review review) {
		reviewRepository.findById(review.getReviewId()).orElseThrow(()-> new ReviewNotFoundException("No such reviews exist"));
		return reviewRepository.save(review);
	}
	@Override
	public Review deleteReview(int id) {
		reviewRepository.findById(id).orElseThrow(()-> new ReviewNotFoundException("No such reviews exist"));
		reviewRepository.deleteById(id);;
		return null ;
	}
	@Override
	public Review viewReview(int id) {
		return reviewRepository.findById(id).orElseThrow(()-> new ReviewNotFoundException("No such reviews exist")); 
	}
	@Override
	public List<Review> listAllReviewsByBook(Book book) {
		List<Review> reviewList = reviewRepository.findAll();
		reviewList.forEach(r->book.equals(r.getBook()));
		if(!reviewList.equals(null)) {
			throw new ReviewNotFoundException("This book has no review records");
		}
		return reviewList;
	}
	@Override
	public List<Review> listAllReviewByCustomer(Customer customer) {
		List<Review> reviewList = reviewRepository.findAll();
		reviewList.forEach(r->customer.equals(r.getCustomer()));
		if(!reviewList.equals(null)) {
			throw new ReviewNotFoundException("This customer has no review records");
		}
		return reviewList;
	}
	@Override
	public List<Book> listMostFavoredBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
