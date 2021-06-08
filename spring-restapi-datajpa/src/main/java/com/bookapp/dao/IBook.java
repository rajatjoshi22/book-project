package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;



@Repository
public interface IBook extends JpaRepository<Book, Integer> {
List<Book> findBybookCategory(String bookCategory);
List<Book> findBybookAuthor(String bookAuthor);
@Query("from Book b where b.bookAuthor like:choice or b.bookCategory like:choice or b.bookTitle like:choice ")
List<Book> findByChoice(String choice);
	
}
