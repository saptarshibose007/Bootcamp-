package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.Review;

public interface IReviewRepository extends JpaRepository<Review,Integer> {

}
