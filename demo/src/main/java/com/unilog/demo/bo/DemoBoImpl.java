package com.unilog.demo.bo;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unilog.demo.dao.DemoDao;
import com.unilog.demo.entity.Book;
import com.unilog.demo.entity.BookRepository;

@Service
public class DemoBoImpl implements DemoBo {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DemoDao demoDao;
	
	@Override
	public void saveBook(Book book) {
		logger.info("DemoBoImpl : saveBook()");
		demoDao.saveBook(book);
	}

	@Override
	public List<Book> getBooks() {
		logger.info("DemoBoImpl : getBooks()");
		
		return demoDao.getBooks();
	}
	
	@Override
	public Book getBookById(Long bookId) {
		logger.info("DemoBoImpl : getBookById()");
		
		return demoDao.getBookById(bookId);
	}

	@Override
	public void deleteBook(Long bookId) {
		logger.info("DemoBoImpl : deleteBook()");
		demoDao.deleteBook(bookId);
	}

	@Override
	public Book updateBook(Book book) {
		logger.info("DemoBoImpl : updateBook()");
		return demoDao.updateBook(book);
	}
	
	
}
