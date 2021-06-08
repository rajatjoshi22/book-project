package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@Api(value="bookcontrols")

//@RestController
@RequestMapping("/book-app")
public class MyBookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/Book")
//	@ApiOperation(value="addbookoperation" ,response=String.class)
//	 @ApiResponses(value= {
//			    @ApiResponse(code = 200,message = "success"),
//	            @ApiResponse(code = 401,message = "Message not found")
//	 })
	
	public ResponseEntity<String>addBook( Book book) {
	  HttpStatus status=HttpStatus.ACCEPTED;
	  HttpHeaders headers=new HttpHeaders();
	  headers.add("message","Adding One book data");
	  bookService.addBook(book);
	  return ResponseEntity.status(status).headers(headers).body("book added Successfully!!!");
	  
	}
	
	@DeleteMapping("/Book")
    public ResponseEntity<String> deleteBook(@RequestParam("bookId")Integer bookId) {
		HttpStatus status=HttpStatus.ACCEPTED;
		  HttpHeaders headers=new HttpHeaders();
		  headers.add("message","deleting One book data");
		  bookService.deleteBook(bookId);
		return ResponseEntity.status(status).headers(headers).body("book deleted successfully!!!!!");
	}
	
	@PutMapping("/Book")
	public ResponseEntity<String> updateBook( Book book) {
		HttpStatus status=HttpStatus.ACCEPTED;
		  HttpHeaders headers=new HttpHeaders();
		  headers.add("message","Updating One book data");
		bookService.updateBook(book);
		return ResponseEntity.status(status).headers(headers).body("Book updated successfully!!!!");
		
	}
	
	   @GetMapping("/Books")
//	   @ApiOperation(value="getAllBookOperation" ,response=List.class)
//		 @ApiResponses(value= {
//				    @ApiResponse(code = 200,message = "success"),
//		            @ApiResponse(code = 401,message = "Message not found")
//		 })
	   public ResponseEntity<List<Book>> getAllBooks(){
		   HttpStatus status=HttpStatus.FOUND;
			  HttpHeaders headers=new HttpHeaders();
			  headers.add("message","getting All Books");
		   List<Book> bookList= bookService.getAllBooks();
		   return ResponseEntity.status(status).headers(headers).body(bookList);
	   }
	
	   @GetMapping("/book-by-choice")
//	   @ApiOperation(value="getbychoiceoperation" ,response=String.class)
//		 @ApiResponses(value= {
//				    @ApiResponse(code = 200,message = "success"),
//		            @ApiResponse(code = 401,message = "Message not found")
//		 })
	   public ResponseEntity<List<Book>> getByChoice(@RequestParam("choice")String choice){
		   HttpStatus status=HttpStatus.FOUND;
			  HttpHeaders headers=new HttpHeaders();
			  headers.add("message","getting Book by choice!!!!");
		  List<Book> bookList= bookService.getByChoice(choice);
		  return ResponseEntity.status(status).headers(headers).body(bookList);
	   } 
	   
	   @GetMapping("/getById")
	public ResponseEntity<Book> getById(@RequestParam("bookId")Integer bookId) {
		   HttpStatus status=HttpStatus.FOUND;
			  HttpHeaders headers=new HttpHeaders();
			  headers.add("message","getting Book by Id!!!!");
		   Book book= bookService.getById(bookId);
		   return ResponseEntity.status(status).headers(headers).body(book);
	   } 
	
	
}