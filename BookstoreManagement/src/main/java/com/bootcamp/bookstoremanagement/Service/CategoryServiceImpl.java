package com.bootcamp.bookstoremanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Category;
import com.bootcamp.bookstoremanagement.Repository.ICategoryRepository;
import com.bootcamp.bookstoremanagement.exception.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public Category editCategory(Category category){
    	categoryRepository.findById(category.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("This category does not exists"));
        return categoryRepository.save(category);
    }
    @Override
    public List<Category> viewAllCategories(){
        
    	return categoryRepository.findAll();
    }
    @Override
    public Category removeCategory(int id){  
    	categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("This category does not exists"));
    	Optional<Category> category=categoryRepository.findById(id);
    	Category cat=category.get();
        categoryRepository.deleteById(id);;
        return cat;
    }

}
