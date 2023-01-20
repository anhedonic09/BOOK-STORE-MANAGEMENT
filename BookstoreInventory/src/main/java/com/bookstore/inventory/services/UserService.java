package com.bookstore.inventory.services;

import com.bookstore.inventory.models.User;

public interface UserService {

	void addUser(User user);

	User getUserDetail(String name);

}
