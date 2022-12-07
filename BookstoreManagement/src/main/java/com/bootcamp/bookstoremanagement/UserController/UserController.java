package com.bootcamp.bookstoremanagement.UserController;

import java.util.List;

import org.jvnet.hk2.internal.InstantiationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.bookstoremanagement.Entity.Address;
import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.OrderDetails;
import com.bootcamp.bookstoremanagement.Entity.Review;
import com.bootcamp.bookstoremanagement.Entity.User;
import com.bootcamp.bookstoremanagement.Repository.ILoginRepository;
import com.bootcamp.bookstoremanagement.Service.IAddressService;
import com.bootcamp.bookstoremanagement.Service.IBookSerivce;
import com.bootcamp.bookstoremanagement.Service.ICategoryService;
import com.bootcamp.bookstoremanagement.Service.ICustomerService;
import com.bootcamp.bookstoremanagement.Service.ILoginService;
import com.bootcamp.bookstoremanagement.Service.IOrderService;
import com.bootcamp.bookstoremanagement.Service.IReviewService;
import com.bootcamp.bookstoremanagement.exception.ReviewNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IBookSerivce bookService;
	@Autowired
	ILoginService loginService;
	@Autowired
	IBookSerivce bookservice;
	@Autowired
	IOrderService orderService;
	@Autowired
	IReviewService reviewService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	IAddressService addressService;
	
	@GetMapping("/index")
	public String  home(){
		return "User Home";
	}
	
	//Login Related Activity--->
	
	@PostMapping(path="/register", consumes="application/json")
	public User registerationUser(@RequestBody User user){
		return loginService.addUser(user);
	}
	
	//Customer Related Activity-->
	
	@PostMapping(path="/saveCustomer", consumes="application/json")
	public String saveCustomer(@RequestBody Customer customer){
		customerService.createCustomer(customer); 
		return "Customer Added";
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleterCustomer(@PathVariable Integer id){
		customerService.deleteCustomer(id);
		return "Customer Deleted";
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer viewCustomer(@PathVariable int id){
		return customerService.viewCustomer(id);
	}
	
	@PutMapping(path="/editCustomer",consumes="application/json")
	public Customer updateCustomer(@RequestBody Customer customer){
		return customerService.updateCustomer(customer);
	}
	
	//Book Related Activity-->
	
	@GetMapping("/getBook/{id}")
	public Book getBook(@PathVariable Integer id) {	
		return bookService.viewBook(id);	
	}
	
	@GetMapping("/getAllBooks")
	public List<Book>getAllBooks(){
		return bookService.listAllBooks();
	}
	
	@GetMapping("/listBookByCategory/{cat}")
	public List<Book> listBookByCategory(@PathVariable String category){
		return bookService.listBookByCategory(category);
	}
	
	
	//Review Related Activity-->
	
	@PutMapping(path="/editReview",consumes="application/json")
	public Review updateReview(@RequestBody Review review){
		return reviewService.updateReview(review);
	}
	
	@PostMapping(path="/saveReview",consumes="application/json")
	public String addReview(@RequestBody Review review){
		reviewService.addReview(review);
		return  "Review Added";
	}
	
	@GetMapping("/listAllReviews")
	public List<Review> listAllReviews(){
		if(reviewService.listAllReviews().isEmpty())
		{
			throw new ReviewNotFoundException("No Review Found");
		}
		
		return reviewService.listAllReviews();
	}
	
	@DeleteMapping("/deleteReview/{id}")
	public String deleteReview(@PathVariable int id){
		reviewService.deleteReview(id);
		return "Review Deleted";
	}
	
	@GetMapping(path="/getReview/{id}")
	public Review viewAddress(@PathVariable int id){
		return reviewService.viewReview(id);
	}
	
	@GetMapping(path="/listAllReviewsByBook",consumes="application/json")
	public List<Review> listAllReviewsByBook(@RequestBody Book book){
		return reviewService.listAllReviewsByBook(book);
	}
	
	
	//Address Related Activity-->
	
	@GetMapping("/getAddress/{id}")
	public Address viewaddress(@PathVariable int id){
		return addressService.viewAddress(id);
	}
	@PostMapping(path="/saveAddress",consumes="application/json")
	public String addAddress(@RequestBody Address address){
		addressService.addAddress(address);
		return "Address Added";
	}
	
	@PutMapping(path="/editAddress",consumes="application/json")
	public Address editAddress(@RequestBody Address address){
		return addressService.editAddress(address);	 
	}
	 
	@DeleteMapping("/deleteAddress/{id}")
	public String deleteAddress(@PathVariable int id){
		addressService.deleteAddress(id);
		return "Address Deleted";
	}
	
	
	//Order Related Activity-->
	
	@PostMapping(path="/saveOrder",consumes ="application/json")
	public String addOrder(@RequestBody OrderDetails orderDetails) {
		orderService.addOrder(orderDetails);
		return "Order Added";
	}
	@PutMapping(path="/editOrder",consumes ="application/json")
	public OrderDetails editOrder(@RequestBody OrderDetails orderDetails) {
		return orderService.updateOrder(orderDetails);
	}
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id){
		orderService.cancelOrder(id);
		return "Order Deleted";
	}	
	
}
