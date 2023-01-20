package com.bookstore.inventory.services;

import java.util.List;

import com.bookstore.inventory.models.BookCategory;
import com.bookstore.inventory.models.BookPublisher;

public interface PublisherService {

	List<BookPublisher> getList();

	void savePublisher(BookPublisher pub);

	void deletePublisher(int publisherid);

	BookPublisher editPublisher(int publisherid);

}
