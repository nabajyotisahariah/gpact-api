package com.genpact.api.service;

import java.io.IOException;
import java.util.List;

import com.genpact.api.model.Book;
import com.genpact.api.model.Library;


public interface BookService {
	
	List<Library> allLibrary() throws IOException, Exception;
	
	List<Book> getLibraryBooks(Long id) throws IOException, Exception;
	
	List<Book> allBooks() throws IOException, Exception;
	
	Book bookGet(Long id) throws IOException, Exception;
	
	Book bookSave(Book b) throws IOException, Exception;
	
	boolean bookEdit(Book b) throws IOException, Exception;
	
	boolean bookDelete(Book b) throws IOException, Exception;

}
