package com.bookstore.inventory.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.inventory.models.Book;
import com.bookstore.inventory.models.BookCategory;
import com.bookstore.inventory.repositories.CategoryRepository;
import com.bookstore.inventory.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired private CategoryRepository repo;

	@Override
	public List<BookCategory> getList() {
		return repo.findAll();
	}

	@Override
	public void saveCategory(BookCategory cat) {
		repo.save(cat);
	}

	@Override
	public void deleteCategory(int categoryid) 
	{
		repo.deleteById(categoryid);
	}

	@Override
	public BookCategory editCategory(int categoryid) 
	{
		return repo.findById(categoryid).orElse(null);
	}

}
