package com.bookstore.inventory.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.inventory.models.Book;
import com.bookstore.inventory.repositories.BookRepository;
import com.bookstore.inventory.services.BookService;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired private BookRepository repo;

	@Override
	public Page<Book> getList(int pn)
	{
		Pageable page = PageRequest.of(pn, 4);
		return repo.findAll(page);
	}

	@Override
	public void saveBook(Book book) 
	{
		repo.save(book);
	}

	@Override
	public Book editBook(int bookid)
	{
		return repo.findById(bookid).orElse(null);
	}

	@Override
	public void deleteBook(int bookid) 
	{
		repo.deleteById(bookid);
	}

	@Override
	public List<Book> getCustomBookList(int categoryid, int price1, int price2) {
		return repo.findByCategoryAndRange(categoryid, price1, price2);
	}	
}
