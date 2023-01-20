package com.bookstore.inventory.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.inventory.models.User;
import com.bookstore.inventory.repositories.UserRepository;
import com.bookstore.inventory.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository repo;

	@Override
	public void addUser(User user) 
	{
		repo.save(user);
	}

	@Override
	public User getUserDetail(String name) 
	{
		return repo.findByName(name);
	}
}
