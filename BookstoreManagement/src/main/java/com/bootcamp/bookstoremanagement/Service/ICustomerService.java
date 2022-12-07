package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;

public interface ICustomerService {
	
	public Customer createCustomer(Customer customer);
	public List<Customer> listCustomers(); // Admin
	public Customer deleteCustomer(int id);
	public Customer viewCustomer(int id);
	public Customer updateCustomer(Customer customer);
	public List<Customer> listAllCustomersByBook(Book book);

}
