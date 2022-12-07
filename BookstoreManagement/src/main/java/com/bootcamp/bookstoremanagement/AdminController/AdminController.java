package com.bootcamp.bookstoremanagement.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.bootcamp.bookstoremanagement.Entity.Address;
import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Category;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.OrderDetails;
import com.bootcamp.bookstoremanagement.Entity.Review;
import com.bootcamp.bookstoremanagement.Service.IAddressService;
import com.bootcamp.bookstoremanagement.Service.IBookSerivce;
import com.bootcamp.bookstoremanagement.Service.ICategoryService;
import com.bootcamp.bookstoremanagement.Service.ICustomerService;
import com.bootcamp.bookstoremanagement.Service.IOrderService;
import com.bootcamp.bookstoremanagement.Service.IReviewService;
import com.bootcamp.bookstoremanagement.exception.BookNotFoundException;
import com.bootcamp.bookstoremanagement.exception.CategoryNotFoundException;
import com.bootcamp.bookstoremanagement.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IBookSerivce bookService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	IReviewService reviewService;
	@Autowired
	IOrderService orderService;
	@Autowired
	IAddressService addressService;
	
	@GetMapping("/index")
	public String home(){
		return "Admin Home Page";
	}
	
	//1.Book Related Operations---->

	@GetMapping("/getAllBooks")
	public List<Book>getAllBooks(){
		
		if(bookService.listAllBooks().isEmpty())
		{
			throw new BookNotFoundException("No Books in the database");
		}
			
		 return bookService.listAllBooks();
	}
	@GetMapping("/getBook/{id}")
	public Book getBook(@PathVariable Integer id) { 	
		return bookService.viewBook(id);	
	}
	@PutMapping(path="/editBook", consumes="application/json")
	public Book editBook(@RequestBody Book book){
		return bookService.editBook(book);
	}
	@PostMapping(path="/saveBook", consumes="application/json")
	public String addBook(@RequestBody Book book){
		bookService.createBook(book); 
		return "Book Added";
	}
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id){
		bookService.deleteBook(id);
		return "Book Deleted";
	}
	@GetMapping("/bookByCategory/{cat}")
	public List<Book> listBookByCategory(@PathVariable String cat){
		return bookService.listBookByCategory(cat);
	}
	
	//2.Customer Related Operations-->
	
	@GetMapping("/getAllCustomers")
	public List<Customer> listCustomers(){
		
		if(customerService.listCustomers().isEmpty())
		{
			throw new CustomerNotFoundException("No Entry of Customers in Data Base");
		}
		
		return customerService.listCustomers();
	}
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable Integer id) { 	
		return customerService.viewCustomer(id);	
	}
	@PutMapping(path="/editCustomer", consumes="application/json")
	public Customer editCustomer(@RequestBody Customer customer){
		return customerService.updateCustomer(customer);
	}
	@PostMapping(path="/saveCustomer", consumes="application/json")
	public String addCustomer(@RequestBody Customer customer){
		customerService.createCustomer(customer); 
		return "Customer Added Succesfully";
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id){
		customerService.deleteCustomer(id);
		return "Customer Deleted";
	}
	@GetMapping(path="/customerByBook",consumes ="application/json")
	public List<Customer> listBookByCategoy(@RequestBody Book book){
		return customerService.listAllCustomersByBook(book);
	}
	
	//3.Category Related Operations--->
	
	@PostMapping(path="/saveCategory", consumes="application/json")
	public String addCategory(@RequestBody Category category){
		categoryService.addCategory(category);
		return "Category Added";
	}
	@GetMapping("/getAllCategories")
	public List<Category> viewAllCategory(){
		
		if(categoryService.viewAllCategories().isEmpty())
		{
			throw new CategoryNotFoundException("No category Found");
		}
		return categoryService.viewAllCategories();
	}
	@PutMapping(path="/editCategory",consumes="application/json")
	public Category editCategory(@RequestBody Category c){
		return categoryService.editCategory(c);
	}
	@DeleteMapping("/deleteCategory/{id}")
	public Category deleteCategory(@PathVariable int id){
		
		return categoryService.removeCategory(id);
		
		
		
	}
	//4.Order Related Ooperations--->
	
	@GetMapping("/listAllOrders")
	public List<OrderDetails> listAllOrders(){
		return orderService.listAllOrders();
	}
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
	
	//5.Review Related Operations--->
	
	@GetMapping("/listAllReviews")
	public List<Review> listAllReviews(){
		return reviewService.listAllReviews();
	}
	@GetMapping("/viewReview/{id}")
	public Review viewReview(@PathVariable int id){
		return reviewService.viewReview(id);
	}
	
	
	
	@GetMapping("/listAllReviewsByBook")
	public List<Review> listAllReviewsByBook(@RequestBody Book book){
		return reviewService.listAllReviewsByBook(book);
	}
	@GetMapping("/listAllReviewByCustomer")
	public List<Review> listAllReviewByCustomer(@RequestBody Customer customer){
		return reviewService.listAllReviewByCustomer(customer);
	}
	
	//6.Address Related Operations --->
	@GetMapping("/getAllAddresses")
	public List<Address> listAllAddresses(){
		return addressService.viewAllAddresses();
	}
}

