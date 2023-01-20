package com.bookstore.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.inventory.models.BookCategory;
import com.bookstore.inventory.services.CategoryService;

@Controller
@RequestMapping("bookstore/inventory/category")
public class CategoryController 
{
	@Autowired private CategoryService cservice;
	
	@RequestMapping("list")
	public String getCategoryList(Model model)
	{
		List<BookCategory> list=cservice.getList();
		model.addAttribute("clist", list);
		return "category/category-list";
	}
	
	@RequestMapping("add")
	public String addCategoryList()
	{
		return "category/add-category";
	}
	
	@RequestMapping("save")
	public String saveCategory(BookCategory cat)
	{
		cservice.saveCategory(cat);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String removeCategory(int categoryid)
	{
		cservice.deleteCategory(categoryid);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String editCategory(int categoryid, Model model)
	{
		BookCategory cat = cservice.editCategory(categoryid);
		model.addAttribute("cat", cat);
		return "category/edit-category";
	}
	
	@RequestMapping("update")
	public String updateCategory(BookCategory cat)
	{
		cservice.saveCategory(cat);
		return "redirect:list";
	}
}
