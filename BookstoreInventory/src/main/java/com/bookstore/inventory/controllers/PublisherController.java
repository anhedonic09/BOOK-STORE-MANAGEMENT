package com.bookstore.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.inventory.models.BookPublisher;
import com.bookstore.inventory.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/publisher")
public class PublisherController 
{
	@Autowired private PublisherService pservice;
	
	@RequestMapping("list")
	public String getPublisherList(Model model)
	{
		List<BookPublisher> list = pservice.getList();
		model.addAttribute("plist", list);
		return "publisher/publisher-list";
	}
	
	@RequestMapping("add")
	public String addPublisherList()
	{
		return "publisher/add-publisher";
	}
	
	@RequestMapping("save")
	public String savePublisher(BookPublisher pub)
	{
		pservice.savePublisher(pub);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String removePublisher(int publisherid)
	{
		pservice.deletePublisher(publisherid);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String editPublisher(int publisherid, Model model)
	{
		BookPublisher pub = pservice.editPublisher(publisherid);
		model.addAttribute("pub", pub);
		return "publisher/edit-publisher";
	}
	
	@RequestMapping("update")
	public String updatePublisher(BookPublisher pub)
	{
		pservice.savePublisher(pub);
		return "redirect:list";
	}
}
