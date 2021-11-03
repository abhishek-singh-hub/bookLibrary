package com.unilog.demo.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unilog.demo.bo.DemoBo;
import com.unilog.demo.entity.Book;

@RestController
@RequestMapping("/book")
public class DemoController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DemoBo demoBo;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST}, consumes = "application/json")
	public ResponseEntity saveBook(@RequestBody Book book ) {
		logger.info("DemoController : saveBook()");
		try {
			demoBo.saveBook(book);
			
			return new ResponseEntity("Book Saved successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping
	public ResponseEntity getBooks() {
		logger.info("DemoController : getBooks()");
		try {
			return new ResponseEntity(demoBo.getBooks(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity getBookById(@PathVariable("bookId") Long bookId) {
		logger.info("DemoController : getBookById()");
		try {
			return new ResponseEntity(demoBo.getBookById(bookId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{bookId}")  
	private ResponseEntity deleteBook(@PathVariable("bookId") Long bookId) {  
		logger.info("DemoController : deleteBook()");
		try {
			demoBo.deleteBook(bookId);
			return new ResponseEntity("Item Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}  
	
	@PutMapping 
	private ResponseEntity updateBook(@RequestBody Book book) {  
		logger.info("DemoController : updateBook()");
		try {
			
			return new ResponseEntity(demoBo.updateBook(book), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}  

}
