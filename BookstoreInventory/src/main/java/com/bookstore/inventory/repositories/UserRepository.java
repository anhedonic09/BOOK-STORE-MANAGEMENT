package com.bookstore.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.inventory.models.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByName(String name);
	
}
