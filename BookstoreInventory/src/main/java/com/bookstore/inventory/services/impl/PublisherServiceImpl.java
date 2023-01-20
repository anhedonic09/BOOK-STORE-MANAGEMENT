package com.bookstore.inventory.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.inventory.models.BookCategory;
import com.bookstore.inventory.models.BookPublisher;
import com.bookstore.inventory.repositories.PublisherRepository;
import com.bookstore.inventory.services.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService
{
	@Autowired private PublisherRepository repo;

	@Override
	public List<BookPublisher> getList() 
	{
		return repo.findAll();
	}

	@Override
	public void savePublisher(BookPublisher pub) 
	{
		repo.save(pub);
	}

	@Override
	public void deletePublisher(int publisherid) 
	{
		repo.deleteById(publisherid);
	}

	@Override
	public BookPublisher editPublisher(int publisherid) 
	{
		return repo.findById(publisherid).orElse(null);
	}
}
