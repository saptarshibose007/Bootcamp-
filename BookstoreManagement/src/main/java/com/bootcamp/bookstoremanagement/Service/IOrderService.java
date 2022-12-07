package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.OrderDetails;

public interface IOrderService {
	
	public List<OrderDetails> listAllOrders(); //admin
	public List<OrderDetails> listOrderByCustomer(Customer customer); //user
	public OrderDetails viewOrderFromCustomer(int id); //user
	public OrderDetails viewOrderFromAdmin(int id); //order
	public OrderDetails cancelOrder(int id);
	public OrderDetails addOrder(OrderDetails orderDetails);
	public OrderDetails updateOrder(OrderDetails orderDetails);
	public List<OrderDetails> viewOrderByBook(Book book);

}
