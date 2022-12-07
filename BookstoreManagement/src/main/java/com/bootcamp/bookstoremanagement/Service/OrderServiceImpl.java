package com.bootcamp.bookstoremanagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Entity.Customer;
import com.bootcamp.bookstoremanagement.Entity.OrderDetails;
import com.bootcamp.bookstoremanagement.Repository.IOrderRepository;
import com.bootcamp.bookstoremanagement.exception.OrderNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	IOrderRepository orderRepository;
	@Override
	public OrderDetails addOrder(OrderDetails orderDetails){
		return orderRepository.save(orderDetails);
	}
	@Override
	public List<OrderDetails> listAllOrders(){
		return orderRepository.findAll();
	}
	@Override
	public OrderDetails cancelOrder(int id){
		orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("this order does not exists"));
		orderRepository.deleteById(id);
		return null;
	}
	@Override
	public OrderDetails updateOrder(OrderDetails orderDetails){
		orderRepository.findById(orderDetails.getOrderId()).orElseThrow(()-> new OrderNotFoundException("this order does not exists"));
		return orderRepository.save(orderDetails);
	}
	@Override
	public OrderDetails viewOrderFromCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OrderDetails viewOrderFromAdmin(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderDetails> listOrderByCustomer(Customer customer){
		List<OrderDetails> orderList = orderRepository.findAll();
		orderList.forEach(o->customer.equals(o.getBookOrder().getCustomer()));
		if(!orderList.equals(null)) {
			throw new OrderNotFoundException("This customer has no order records");
		}
		return orderList;
	}
	@Override
	public List<OrderDetails> viewOrderByBook(Book book) {
		List<OrderDetails> orderList = orderRepository.findAll();
		orderList.forEach(o->book.equals(o.getBook()));
		if(!orderList.equals(null)) {
			throw new OrderNotFoundException("This book has no order records");
		}
		return orderList;
	}
}