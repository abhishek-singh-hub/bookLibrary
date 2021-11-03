package com.unilog.demo.dao;

import java.util.List;

import com.unilog.demo.entity.Book;

public interface DemoDao {

	public void saveBook(Book book);

	public List<Book> getBooks();

	Book getBookById(Long bookId);

	public void deleteBook(Long bookId);

	public Book updateBook(Book book);

}
