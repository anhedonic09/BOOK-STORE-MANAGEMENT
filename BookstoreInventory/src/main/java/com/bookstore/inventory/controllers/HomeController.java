package com.bookstore.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory")
public class HomeController {
	
	@RequestMapping("home")
	public String getLoginView()
	{
		return "home/home-page";
	}

}
