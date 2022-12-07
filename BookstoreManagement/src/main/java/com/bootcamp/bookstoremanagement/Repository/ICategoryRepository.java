package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
