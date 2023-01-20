package com.bookstore.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.inventory.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{

	@Query("from Book where categoryid=:cid and price between :pr1 and :pr2")
	List<Book> findByCategoryAndRange(@Param("cid")int categoryid,@Param("pr1") int price1,@Param("pr2") int price2);

}
