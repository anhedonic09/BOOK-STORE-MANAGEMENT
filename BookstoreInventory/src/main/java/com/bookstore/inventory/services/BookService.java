package com.bookstore.inventory.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bookstore.inventory.models.Book;

public interface BookService 
{

	Page<Book> getList(int pn);

	void saveBook(Book book);

	Book editBook(int bookid);

	void deleteBook(int bookid);

	List<Book> getCustomBookList(int categoryid, int price1, int price2);

}
