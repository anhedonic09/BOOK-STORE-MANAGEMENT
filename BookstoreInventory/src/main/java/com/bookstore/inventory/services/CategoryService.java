package com.bookstore.inventory.services;

import java.util.List;

import com.bookstore.inventory.models.Book;
import com.bookstore.inventory.models.BookCategory;

public interface CategoryService {

	List<BookCategory> getList();

	void saveCategory(BookCategory cat);

	void deleteCategory(int categoryid);

	BookCategory editCategory(int categoryid);


}
