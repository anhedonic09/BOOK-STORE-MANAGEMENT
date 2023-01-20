package com.bookstore.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory/search")
public class SearchController {
	
	@RequestMapping("search")
	public String getSearchView()
	{
		return "search/search-page";
	}
	
}
