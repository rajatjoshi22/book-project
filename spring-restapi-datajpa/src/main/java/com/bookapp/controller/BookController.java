package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;

@CrossOrigin("http://localhost:4600")
@RestController
@RequestMapping("/book-api")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/Book")
	@ResponseBody
	public String addBook(@RequestBody Book book) {
	  bookService.addBook(book);
	  return "bookaddedsuccessfully!!!";
	}
	
	@DeleteMapping("/Book")
    public String  deleteBook(@RequestParam("bookId")Integer bookId) {
		bookService.deleteBook(bookId);
		return "bookdeletedsuccessfully!!!";
	}
	
	@PutMapping("/Book")
	public String  updateBook(@RequestBody Book book) {
		System.out.println(book);
		bookService.updateBook(book);
		return "bookupdatedsuccessfully!!!!";
	}
	
	   @GetMapping("/Books")
	   public List<Book> getAllBooks(){
		   System.out.println(bookService.getAllBooks());
		   return bookService.getAllBooks();
	   }
	
	   @GetMapping("/book-By-Choice")
	   public List<Book> getByChoice(@RequestParam("choice")String choice){
		  return bookService.getByChoice(choice);
	   } 
	   
	   @GetMapping("/book-By-Id")
	public Book getById(@RequestParam("bookId")Integer bookId) {
		   return bookService.getById(bookId);
	   } 
	
	
}
