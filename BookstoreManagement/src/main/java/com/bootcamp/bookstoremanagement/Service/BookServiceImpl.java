package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Book;
import com.bootcamp.bookstoremanagement.Repository.IBookRepository;
import com.bootcamp.bookstoremanagement.Repository.ICategoryRepository;
import com.bootcamp.bookstoremanagement.exception.BookNotFoundException;

@Service
public class BookServiceImpl implements IBookSerivce {
	
	@Autowired
	IBookRepository bookRepository;
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book deleteBook(int id) {		
		bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("The book is not present"));
		bookRepository.deleteById(id);		
		return null;
	}

	@Override
	public Book editBook(Book book) {	
		bookRepository.findById(book.getBookId()).orElseThrow(()-> new BookNotFoundException("The book is not present"));
		return bookRepository.save(book);
	}

	@Override
	public Book viewBook(int id) {
		return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("The book is not present"));
	}

	@Override
	public List<Book> listBookByCategory(String category) {		
//		List<Book> bookList = bookRepository.findAll();
//		List<Book>listBookByCategory = new ArrayList<>();
//		for(Book b : bookList){
//			if(category.equals(b.getCategory().getCategoryName())){
//				listBookByCategory.add(b);
//			}
//		}
//		return listBookByCategory;	
		List<Book> bookList = bookRepository.findAll();
		bookList.forEach(b->category.equals(b.getCategory().getCategoryName()));
		return bookList;
	}
	@Override
	public List<Book> listBestSellingBook() {
		// TODO Auto-generated method stub
		return null;
	}

}
