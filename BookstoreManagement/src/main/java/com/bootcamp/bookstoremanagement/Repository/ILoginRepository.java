package com.bootcamp.bookstoremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.bookstoremanagement.Entity.User;

public interface ILoginRepository extends JpaRepository<User,Integer> {

}
