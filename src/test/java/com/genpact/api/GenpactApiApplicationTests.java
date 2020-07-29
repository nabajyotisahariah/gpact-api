package com.genpact.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.genpact.api.model.Book;
import com.genpact.api.model.Library;
import com.genpact.api.repo.BookRepo;
import com.genpact.api.repo.LibraryRepo;

//@ActiveProfiles("dev")
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenpactApiApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class GenpactApiApplicationTests {
	
	@Autowired
	private LibraryRepo libraryRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Test
	public void createLibarry() throws Exception {
		System.out.println("createLibarry");
		
		Library l = new Library();
		l.setName("Library I");
		
		
		List<Book> bookList = new ArrayList<>();
		
		Book b1 = new Book();
		b1.setName("Hindi Book for I");
		b1.setSclass("I");
		b1.setLibrary(l);
		
		
		Book b2 = new Book();
		b2.setName("English Book For I");
		b2.setSclass("I");
		b2.setLibrary(l);
				
		
		bookList.add(b1);bookList.add(b2);
		
		l.setBooks(bookList);
		
		libraryRepo.save(l);
	
	}
	

	@Test
	public void createLibarry2() throws Exception {
		System.out.println("createLibarry2");
		
		Library l = new Library();
		l.setName("Library 2");
		
		
		List<Book> bookList = new ArrayList<>();
		
		Book b1 = new Book();
		b1.setName("Maths Book for II");
		b1.setSclass("II");
		b1.setLibrary(l);
		
		
		Book b2 = new Book();
		b2.setName("Science Book For II");
		b2.setSclass("II");
		b2.setLibrary(l);
				
		
		bookList.add(b1);bookList.add(b2);
		
		l.setBooks(bookList);
		
		libraryRepo.save(l);
	
	}
	

	@Test
	public void getLibrary() throws Exception {
		System.out.println("getLibrary");
		
		//Library l = libraryRepo.getOne(2L);//.getBooks();
		
		//System.out.println("getLibrary "+l);
		
		List<Library> libraryList = libraryRepo.findAll();
		
		
		for(Library library : libraryList) {
			
			System.out.println("Library Info "+library.getId()+" === "+library.getName());
			
			List<Book> booksList = bookRepo.getBookByLibraryId(library.getId());
				
			for(Book book : booksList) {
				
				System.out.println("  ===== Book Info "+book.getId()+" === "+book.getName());	
			}
		}
	}
}