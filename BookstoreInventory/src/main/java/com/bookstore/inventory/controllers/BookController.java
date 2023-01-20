package com.bookstore.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.inventory.models.Book;
import com.bookstore.inventory.services.BookService;
import com.bookstore.inventory.services.CategoryService;
import com.bookstore.inventory.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/book")
public class BookController 
{
	@Autowired  
	private BookService bservice;
	
	@Autowired 
	private PublisherService pservice;
	
	@Autowired  
	private CategoryService cservice;
	
	@RequestMapping("list")
	public String getBookList(Model model, int pn)
	{
		Page<Book> pagelist = bservice.getList(pn-1);
		List<Book> list = pagelist.toList();
		int totalPages = pagelist.getTotalPages();
		model.addAttribute("blist", list);
		model.addAttribute("tp", totalPages);
		model.addAttribute("pn", pn);
		return "book/book-list";
	}
	
	@RequestMapping("add")
	public String getAddView(Model model)
	{
		model.addAttribute("clist", cservice.getList());
		model.addAttribute("plist", pservice.getList());
		return "book/add-book";
	}
	
	@RequestMapping("save")
	public String saveBook(Book book)
	{
		bservice.saveBook(book);
		return "redirect:list?pn=1";
	}
	
	@RequestMapping("edit")
	public String editBook(int bookid, Model model)
	{
		Book book = bservice.editBook(bookid);
		model.addAttribute("clist", cservice.getList());
		model.addAttribute("plist", pservice.getList());
		model.addAttribute("book", book);
		return "book/edit-book";
	}
	
	@RequestMapping("remove")
	public String deleteBook(int bookid)
	{
		bservice.deleteBook(bookid);
		return "redirect:list";
	}
	
	@RequestMapping("update")
	public String updateBook(Book book)
	{
		bservice.saveBook(book);
		return "redirect:list?pn=1";
	}
	
	
}
