package com.bootcamp.bookstoremanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Repository.IBookRepository;
import com.bootcamp.bookstoremanagement.Repository.ICustomerRepository;
import com.bootcamp.bookstoremanagement.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	@Autowired
	IBookRepository bookRepository;
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);		
	}
	@Override
	public List<Customer> listCustomers() {
		return customerRepository.findAll();	
	}
	@Override
	public Customer deleteCustomer(int id) {
		customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("This customer does not exist"));
		customerRepository.deleteById(id);
		return null;
	}
	@Override
	public Customer viewCustomer(int id) {
		return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("This customer does not exist"));	
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		customerRepository.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerNotFoundException("This customer does not exist"));
		return customerRepository.save(customer);	
	}
	@Override
	public List<Customer> listAllCustomersByBook(Book book) {
		// TODO Auto-generated method stub
		return null;
		
	}

}
