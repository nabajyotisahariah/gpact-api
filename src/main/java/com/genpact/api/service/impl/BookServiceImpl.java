package com.genpact.api.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.api.model.Book;
import com.genpact.api.model.Library;
import com.genpact.api.repo.BookRepo;
import com.genpact.api.repo.LibraryRepo;
import com.genpact.api.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private LibraryRepo librayRepo;
	
	@Override
	public List<Library> allLibrary() throws IOException, Exception {
		
		return librayRepo.findAll();
	}
	
	@Override
	public List<Book> getLibraryBooks(Long id) throws IOException, Exception {
		
		return bookRepo.getBookByLibraryId(id);
	}
	
	@Override
	public List<Book> allBooks() throws IOException, Exception {
		
		return bookRepo.findAll();
	}

	@Override
	public Book bookGet(Long id) throws IOException, Exception {
		return  bookRepo.getOne(id);
	}
	
	@Override
	public Book bookSave(Book b) throws IOException, Exception {
		return bookRepo.save(b);
	}

	@Override
	public boolean bookEdit(Book b) throws IOException, Exception {
		return bookRepo.save(b) != null ? true : false;
	}

	@Override
	public boolean bookDelete(Book b) throws IOException, Exception {
		bookRepo.delete(b);
		return true;
	}

}
