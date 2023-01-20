package com.bookstore.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory/login")
public class LoginController 
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "home/admin-login";
	}

	@RequestMapping("authentication")
	public String adminValidateLogin(String uid, String pass, Model model)
	{
		if(uid.equals("admin") && pass.equals("admin"))
		{
			return "redirect:../home";
		}
		model.addAttribute("msg", "Wrong Credentials Authentication failed...");
//		return "redirect:../invalidlogin";
		return "home/admin-login";
	}
	
	@RequestMapping("userauth")
	public String userValidateLogin()
	{
		return "userhome/user-login";
	}
	
}
