package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.OrderDetails;

public interface IOrderRepository extends JpaRepository<OrderDetails,Integer> {

}
