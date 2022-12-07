package com.bootcamp.bookstoremanagement.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class OrderDetails {
	
	@Id
	private int orderId;
	@OneToOne
	private Book book;
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BookOrder bookOrder;
	private int quantity;
	private double subtotal;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookOrder getBookOrder() {
		return bookOrder;
	}
	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
