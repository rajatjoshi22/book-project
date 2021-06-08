package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="springbook")
public class Book {
@Column(name="booktitle")
private String bookTitle;
@Id
@Column(name="bookid")
private Integer bookId;
@Column(name="bookcategory")
private String bookCategory;
@Column(name="bookauthor")
private String bookAuthor;
@Column(name="bookprice")
private Double bookPrice;
}
