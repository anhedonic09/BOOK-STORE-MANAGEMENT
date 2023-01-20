package com.bookstore.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.inventory.models.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory, Integer>
{


}
