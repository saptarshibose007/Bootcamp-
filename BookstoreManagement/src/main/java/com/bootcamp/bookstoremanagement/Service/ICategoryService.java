package com.bootcamp.bookstoremanagement.Service;

import java.util.List;

import com.bootcamp.bookstoremanagement.Entity.Category;

public interface ICategoryService {
	
	public Category addCategory(Category category); //done
	public Category editCategory(Category category); //done 
	public List<Category> viewAllCategories(); //done
	public Category removeCategory(int id); 

}
