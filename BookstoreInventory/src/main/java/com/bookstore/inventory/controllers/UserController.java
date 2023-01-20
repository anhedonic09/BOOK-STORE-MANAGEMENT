package com.bookstore.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.inventory.models.Book;
import com.bookstore.inventory.models.User;
import com.bookstore.inventory.services.BookService;
import com.bookstore.inventory.services.CategoryService;
import com.bookstore.inventory.services.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("bookstore/user")
public class UserController
{
	@Autowired
	private UserService uservice;
	@Autowired
	private BookService bservice;
	@Autowired
	private CategoryService cservice;
	
	@RequestMapping("home")
	public String getHomeView(String name, String pass, Model model)
	{
		User user=uservice.getUserDetail(name);
		Page<Book> list = bservice.getList(0);
		
		if(user!=null)
		{
			String dpass=user.getPass();
			if(pass.equals(dpass))
			{
				model.addAttribute("blist", list);
				return "userhome/user-home";
			}
		}
		return "redirect:/bookstore/inventory/login/userauth";
	}
	
	@RequestMapping("register")
	public String getRegisterView()
	{
		return "userhome/registration";
	}
	
	@RequestMapping("add")
	public String addUser(User user)
	{
		uservice.addUser(user);
		return "redirect:/bookstore/inventory/login/userauth";
	}
	
	@RequestMapping("search")
	public String searchBookView(Model model)
	{
		model.addAttribute("clist",  cservice.getList());
		return "usersearch/searchpage";
	}
	
	@RequestMapping("searchByNa&Pr")
	public String searchByPriceAndRange(int categoryid, int price1, int price2, Model model)
	{
		List<Book> list = bservice.getCustomBookList(categoryid, price1, price2);
		model.addAttribute("blist", list);
		return "usersearch/searchresult";
	}
}
