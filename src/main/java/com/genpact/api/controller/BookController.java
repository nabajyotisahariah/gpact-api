package com.genpact.api.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.genpact.api.model.Book;
import com.genpact.api.model.EntityResponse;
import com.genpact.api.model.EntityResponseBook;
import com.genpact.api.model.EntityResponseLibrary;
import com.genpact.api.model.Library;
import com.genpact.api.service.BookService;
import com.genpact.api.util.AppConstants;


@Controller
@RequestMapping("library")
public class BookController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("getall")
	public ResponseEntity<EntityResponse> getAllLibrary()  {  
		
		EntityResponse response = new EntityResponse();	
		
		try {	
			List<Library> data = bookService.allLibrary();
			
			System.out.println("data "+data);
			
			response.setStatus(1);
			response.setMsg("Success");
			response.setData(data);
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			response.setError(AppConstants.ErrorDefault);			
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}
	
	@GetMapping("getbooks")
	public ResponseEntity<EntityResponse> getAllBooks()  {  
		
		EntityResponse response = new EntityResponse();	
		
		try {	
			List<Book> data = bookService.allBooks();
			
			System.out.println("data "+data);
			
			response.setStatus(1);
			response.setMsg("Success");
			response.setData(data);
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			response.setError(AppConstants.ErrorDefault);			
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}

	@GetMapping("get/{id}")
	public ResponseEntity<EntityResponse> getLibraryBooks(@PathVariable Long id)  {  
		
		EntityResponse response = new EntityResponse();	
		
		try {	
			Object data = bookService.getLibraryBooks(id);
			
			response.setStatus(1);
			response.setMsg("Success");
			response.setData(data);
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			response.setError(AppConstants.ErrorDefault);			
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}

	
	@GetMapping("/book/{id}")
	public ResponseEntity<EntityResponse> getBook(@PathVariable Long id)  {  
		
		EntityResponse response = new EntityResponse();	
		
		LOGGER.info("get "+id); 
		try {
			
			//List<Book> book = bookService.get(id).stream().filter(books -> book != null).collect(Collectors.toList());
			Object book = Arrays.asList(bookService.bookGet(id));
			//Object book = (Object)bookService.get(id);
			
			System.out.println(" book "+book);
			
			response.setStatus(1);
			response.setMsg("Success");
			response.setData(book);
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
		
			LOGGER.error("Missing get id "+id);
			
			response.setError(AppConstants.ErrorDefault);			
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}

	
	//@PostMapping("/book/add")
	public ResponseEntity<EntityResponse> addBook(@RequestParam("name") String name, 
			@RequestParam("sclass") String sclass)  {  
		
		EntityResponse response = new EntityResponse();	
		
		try {	
			Book b = new Book();	
			b.setName(name);
			b.setSclass(sclass);
			
			bookService.bookSave(b);
			
			response.setStatus(1);
			response.setMsg("Success");
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			System.out.println("Error "+e.getMessage());
			response.setError(AppConstants.ErrorDefault);
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}
	
	
	@PostMapping("/book/edit")
	public ResponseEntity<EntityResponse> editBook(@RequestParam("name") String name, 
			@RequestParam("sclass") String sclass, @RequestParam("id") Long id)  {  
		
		EntityResponse response = new EntityResponse();	
		
		try {
			
			Book b = new Book();
			b.setId(id);
			b.setName(name);
			b.setSclass(sclass);
			
			bookService.bookEdit(b);
			
			response.setStatus(1);
			response.setMsg("Success");
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			response.setError(AppConstants.ErrorDefault);
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}
	
	@PostMapping("/book/delete")
	public ResponseEntity<EntityResponse> deleteBook( @RequestParam("id") Long id)  {
		
		
		EntityResponse response = new EntityResponse();	
		
		try {	
			
			Book b = bookService.bookGet(id);
			
			if( b != null ) {
				
				bookService.bookDelete(b);
				
				response.setStatus(1);
				response.setMsg("Success");
			}
			
			
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);
			
		}catch(Exception e) {			
			
			response.setError(AppConstants.ErrorDefault);
			return new ResponseEntity<EntityResponse>(response, HttpStatus.OK);			
		}
	}
}
