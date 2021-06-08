package com.bookapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.IBook;
import com.bookapp.exceptions.BookAlreadyExistException;
import com.bookapp.exceptions.BookIdNotFoundException;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
@Service
public class BookServiceImpl implements BookService {

//	@Autowired
//	BookDao bookDao;
	@Autowired
	IBook bookDao;
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
      Book book1=bookDao.findById(book.getBookId()).orElse(null);
		if(book1!=null) {
			throw new BookAlreadyExistException("Book with this id already exist!!!!");
		}
      bookDao.save(book);
	}

	@Override
	public void deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		try {
		bookDao.deleteById(bookId);
		}catch(Exception e) {
			throw new BookIdNotFoundException("invalid book Id!!!!");
		}
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
//		bookDao.updateBook(bookId, Price);
		System.out.println(book);
		bookDao.save(book);
		
	
	}
	
	@Override
	public List<Book> getAllBooks() {
//		return null;
		// TODO Auto-generated method stub
		List<Book> bookList=bookDao.findAll();
	    return bookList;
	}

	@Override
	public List<Book> getByChoice(String choice) {
		List<Book> bookList=bookDao.findByChoice("%"+choice+"%");
		// TODO Auto-generated method stub
//		List<Book> bookList= bookDao.getByChoice(choice);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("No Books found of your choice");
		}
		return bookList;
	}

	@Override
	public Book getById(Integer bookId) {
		// TODO Auto-generated method stub
		Book book= bookDao.findById(bookId).orElseThrow(()-> new BookIdNotFoundException("Invalid book Id"));
		return book;
	}

}
