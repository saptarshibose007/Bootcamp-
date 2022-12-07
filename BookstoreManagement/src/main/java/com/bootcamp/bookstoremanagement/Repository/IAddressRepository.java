package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

}
