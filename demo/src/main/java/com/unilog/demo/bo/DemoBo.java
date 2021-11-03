package com.unilog.demo.bo;

import java.util.List;

import org.json.JSONObject;
import org.springframework.util.MultiValueMap;

import com.unilog.demo.entity.Book;

public interface DemoBo {

	public void saveBook(Book book);

	public List<Book> getBooks();

	public Book getBookById(Long bookId);

	public void deleteBook(Long bookId);

	public Book updateBook(Book book);

}
