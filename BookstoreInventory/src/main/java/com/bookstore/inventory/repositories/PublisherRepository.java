package com.bookstore.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.inventory.models.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher, Integer>
{

}
