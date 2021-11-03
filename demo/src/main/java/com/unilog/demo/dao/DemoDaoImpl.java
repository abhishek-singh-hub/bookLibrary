package com.unilog.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unilog.demo.entity.Book;
import com.unilog.demo.entity.BookRepository;

@Repository
public class DemoDaoImpl implements DemoDao {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private EntityManager entityManager;
	
	@Autowired  
	private BookRepository booksRepository;  
	
	
	@Override
	public void saveBook(Book book) {
		logger.info("DemoDaoImpl : saveBook()");
		booksRepository.save(book);
	}

	@Override
	public List<Book> getBooks() {
		logger.info("DemoDaoImpl : getBooks()");
		return booksRepository.findAll();
	}
	
	@Override
	public Book getBookById(Long bookId) {
		logger.info("DemoDaoImpl : getBookById()");
		return booksRepository.findById(bookId).get();
	}

	@Override
	public void deleteBook(Long bookId) {
		logger.info("DemoDaoImpl : deleteBook()");
		booksRepository.deleteById(bookId);
	}

	@Override
	public Book updateBook(Book book) {
		logger.info("DemoDaoImpl : saveBook()");
		return booksRepository.save(book);
	}

}
