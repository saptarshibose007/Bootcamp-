package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.Book;

public interface IBookRepository extends JpaRepository<Book,Integer> {

}
