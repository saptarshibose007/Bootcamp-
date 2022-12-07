package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
